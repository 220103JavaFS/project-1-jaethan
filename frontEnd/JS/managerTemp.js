let viewBtn = document.getElementById("viewBtn");
let updateRqstBtn = document.getElementById("updateRqstBtn");
let viewUpdateBtb = document.getElementById("viewUpdatedBtn");
let reimbTbl = document.getElementById("reimbTbl");
let reimbRqstTbl = document.getElementById("reimbRqstTbl");

const url = "http://localhost:7000/"

viewBtn.addEventListener("click", viewAllFunc);
viewUpdateBtb.addEventListener("click", viewUpdatedFunc);
updateRqstBtn.addEventListener("click", updateFunc);

async function viewAllFunc(){

    let response = await fetch(url + "manager/allRequest", {
        credentials: "include"
    });

    if (response.status === 200) {
        let reimbs = await response.json();
        listReimb(reimbs);
    }else{
        console.log("error getting the reimbursement records")
    }
}

function listReimb(reimbs){
    reimbTbl.innerText = "";
  
      for (let reimb of reimbs){
  
          let row = document.createElement("tr");
  
          for (let data in reimb){
              console.log(reimb[data]);
              let td = document.createElement("td");
              td.innerText = reimb[data];
              
              if (data == "reimbSubmitted" || data == "reimbResolved") {
                  td.innerText = new Date(reimb[data]);
              }
              if (data == "reimbAmount"){
                  td.innerText = "$" + reimb[data];
              }
              if(data == "reimbAuthor" || data == "reimbResolver"){
                  
                  if(reimb[data] == null){
                      td.innerText = null;
                  }else{
                      td.innerText = reimb[data].username;
                      console.log(reimb[data].username);
                  }
              }
              if(data == "reimbStatusId"){
                  td.innerText = reimb[data].reimbStatus;
              }
              if(data == "reimbTypeId"){
                  td.innerText = reimb[data].reimbType;
              }
              row.appendChild(td);
          }
          reimbTbl.appendChild(row);
      }
}

async function viewUpdatedFunc(){
    let response = await fetch(url + "manager/viewUpdate", {
        credentials: "include"
    });

    if (response.status === 200) {
        let reimbs = await response.json();
        listReimb(reimbs);
    }else{
        console.log("error getting the updated reimbursement records")
    }
}

async function updateFunc(){
    let  statusId_value = 2;

    if (document.querySelector('#status').value == "denied"){
      statusId_value = 3;
    }
    let update = {
        
        reimbId:document.getElementById("reimbId").value,
        reimbResolver:{
          userId:parseInt(document.getElementById("reimbResolver").value)
        },
        reimbStatusId:{
          statusId:statusId_value
        }
    
    }
    console.log(update);

    let response = await fetch(url + "manager/update", {
        method: "PUT",
        body:JSON.stringify(update),
        credentials: "include"
    });

    if(response.status === 200){
        
      console.log("Reimbursement request sent successfully!");
      
    }else {
  
      console.log("Unsuccessful" +response.status);
    }  
}
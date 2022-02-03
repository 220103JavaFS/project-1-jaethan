let username = document.getElementById("username");
let password = document.getElementById("password");
let loginBtn = document.getElementById("loginBtn");
let login_div = document.getElementById("loginDiv");
let employee_div = document.getElementById("employeeDiv");
let manager_div = document.getElementById("managerDiv");
let logout_btn = document.getElementById("logoutBtn");
let requestBtn = document.getElementById("requestBtn");
let searchBtn = document.getElementById("searchBtn");
let reimbTbl = document.getElementById("reimbTbl");
let reimbTbl2 = document.getElementById("reimbTbl2");
let viewUpdateBtn = document.getElementById("viewUpdatedBtn");
let viewBtn = document.getElementById("viewBtn");
let updateRqstBtn = document.getElementById("updateRqstBtn");
let reimbRqstTbl = document.getElementById("reimbRqstTbl");

const url = "http://localhost:7000/"

loginBtn.addEventListener("click", loginFunc);
logout_btn.addEventListener("click", logoutFunc);
searchBtn.addEventListener("click", getPastReimb);
requestBtn.addEventListener("click", requestFunc);
viewBtn.addEventListener("click", viewAllFunc);
viewUpdateBtn.addEventListener("click", viewUpdatedFunc);
updateRqstBtn.addEventListener("click", updateFunc);

async function loginFunc(){
    let user = {
        username: username.value,
        password: password.value
    }

    console.log("User and Pass:" + user.username + " | " + user.password);

    let response = await fetch(
      url+"login",
      {
        method : "POST",
        body : JSON.stringify(user),
        credentials: "include"
      }
    );
    
      if(response.status===200){
        login_div.style.display = 'none';
        if (username.value == "manager") {
          manager_div.style.display = 'block';
          logout_btn.style.display = 'block';
        } else {
            employee_div.style.display = 'block';
            logout_btn.style.display = 'block';
        }
      }else{
        console.log("Login unsuccessful. Returned status code of:"+response.status);
      }
}
async function logoutFunc(){
    
  
  let response = await fetch(
    url+"logout",
    {
      method : "POST",   
      credentials: "include"
    }
  );

  if(response.status===200){
      sessionStorage.clear();
      console.log("logging out");
      manager_div.style.display = 'none';
      employee_div.style.display = 'none';
      logoutBtn.style.display = 'none';
      login_div.style.display = 'block';
  }else{
    console.log("Logout unsuccessful. Returned status code of:"+response.status);
  }
}

async function getPastReimb(){
  let userId = document.getElementById('authorId').value;
  
      let response = await fetch(url + "employee/" + userId, {
          credentials: "include"
      });
  
      if (response.status === 200) {
          let reimbs = await response.json();
          listReimb(reimbs);
      }else{
          console.log("error getting the past reimbursement records")
      }
  }
  
async function viewAllFunc(){

    let response = await fetch(url + "manager/allRequest", {
        credentials: "include"
    });

    if (response.status === 200) {
        let reimbs = await response.json();
        listReimb2(reimbs);
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
                if(reimb[data] == null){
                  td.innerText == null;
                }else{
                  td.innerText = new Date(reimb[data]);
                }
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
function listReimb2(reimbs){
  reimbTbl2.innerText = "";

    for (let reimb of reimbs){

        let row = document.createElement("tr");

        for (let data in reimb){
            console.log(reimb[data]);
            let td = document.createElement("td");
            td.innerText = reimb[data];
            
            if (data == "reimbSubmitted" || data == "reimbResolved") {
                if(reimb[data] == null){
                  td.innerText == null;
                }else{
                  td.innerText = new Date(reimb[data]);
                }
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
        reimbTbl2.appendChild(row);
    }
}

async function viewUpdatedFunc(){
  let response = await fetch(url + "manager/viewUpdate", {
      credentials: "include"
  });

  if (response.status === 200) {
      let reimbs = await response.json();
      listReimb2(reimbs);
  }else{
      console.log("error getting the updated reimbursement records")
  }
}

async function requestFunc() {
   
  let typeId_value = 1;

  if (document.querySelector('#types').value == "etc"){
    typeId_value = 2;
  }

  // sending reimbursement request
  console.log("The selected reimbursement type: " + document.querySelector('#status').value);
  let status = {
      
    reimbAmount:parseInt(document.getElementById("reimbAmount").value),
    reimbDescription:document.getElementById("reimbDescr").value,
    reimbAuthor:{
      userId:parseInt(document.getElementById("reimbAuthor").value)
    },
    reimbTypeId:{
      typeId:typeId_value
    }

  } 
  console.log(status);

  // for parsing the input and only allowing two decimal places
  let num_amount = status.amount;
  console.log("your parsed amount: " + num_amount);


  let response = await fetch(url + "employee", {
      method:"POST",
      body:JSON.stringify(status),
      credentials:"include"
  })

  if(response.status === 202){

      console.log("Reimbursement request sent successfully!");
      
  }else {

    console.log("Unsuccessful" +response.status);
  }
  
}

async function updateFunc(){
  let  statusId_value = 1;

  if (document.querySelector('#status').value == "approved"){
    statusId_value = 2;
  } else if (document.querySelector('#status').value == "denied"){
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

  if(response.status === 202){
      
    console.log("Reimbursement request sent successfully!");
    
  }else {

    console.log("Unsuccessful" +response.status);
  }  
}
  
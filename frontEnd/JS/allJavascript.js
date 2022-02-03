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

const url = "http://localhost:7000/"


if (sessionStorage.getItem("userSession") == null){
  manager_div.style.display = 'none';
  logout_btn.style.display = 'none';
  employee_div.style.display = 'none';
  login_div.style.display = 'block';
}

loginBtn.addEventListener("click", loginFunc);
logout_btn.addEventListener("click", logoutFunc);
searchBtn.addEventListener("click", getPastReimb);
requestBtn.addEventListener("click", requestFunc);

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

async function requestFunc() {
   
  let typeId_value = 1;

  if (document.querySelector('#types').value == "etc"){
    typeId_value = 2;
  }

  // sending reimbursement request
  console.log("The selected reimbursement type: " + document.querySelector('#select1').value);
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
  
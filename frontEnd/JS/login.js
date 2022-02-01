let username = document.getElementById("username");
let password = document.getElementById("password");
let loginBtn = document.getElementById("loginBtn");
let login_verify = document.getElementById("username_verify");
let pasword_verify = document.getElementById("password_verify");
let login_div = document.getElementById("loginDiv");
let employee_div = document.getElementById("employeeDiv");
let manager_div = document.getElementById("managerDiv");
let logout_btn = document.getElementById("logoutBtn");

const url = "http://localhost:7000/"


if (sessionStorage.getItem("userSession") == null){
  manager_div.style.display = 'none';
  logout_btn.style.display = 'none';
  employee_div.style.display = 'none';
  login_div.style.display = 'block';
}

loginBtn.addEventListener("click", loginFunc);
logout_btn.addEventListener("click", logoutFunc);

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
      logoutBtn.style.display = 'none';
      login_div.style.display = 'block';
  }else{
    console.log("Logout unsuccessful. Returned status code of:"+response.status);
  }
}
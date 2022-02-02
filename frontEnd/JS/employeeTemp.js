let requestBtn = document.getElementById("requestBtn");
let searchBtn = document.getElementById("searchBtn");

const url = "http://localhost:7000/"

async function getPastReimb(){
let userId = 

    let response = await fetch(url + "employee/", {
        credentials: "include"
    });

    if (response.status === 200) {
        let homes = await response.json();
        populateHomes(homes);
    }else{
        console.log("There was an error getting your homes")
    }
}
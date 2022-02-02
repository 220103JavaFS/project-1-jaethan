let requestBtn = document.getElementById("requestBtn");
let searchBtn = document.getElementById("searchBtn");
let viewRequests = document.getElementById("viewPastRequest");

const url = "http://localhost:7000/"

requestBtn.addEventListener("click", requestFunc);
searchBtn.addEventListener("click", searchFunc);
viewRequests.addEventListener("click", getPastReimb);

async function getPastReimb(){
let userId = something.value;

    let response = await fetch(
        url + "employee/" + userId, 
        {
        credentials: "include"
    });

    if (response.status === 200) {
        let reimb = await response.json();
        listReimb(reimb);
    }else{
        console.log("error getting the past reimbursement records")
    }
}

function listReimb(reimbursement){
    viewRequests.innerText = "";
    for (let reimb of reimbursement){
        let row = document.createElement("tr");
        for (let data in reimb){
            let td = document.createElement("td");
            td.innerText = reimb[data];
            row.appendChild(td);
        }
        viewRequests.appendChild(row);
    }
}
let requestBtn = document.getElementById("requestBtn");
let searchBtn = document.getElementById("searchBtn");
let reimbTbl = document.getElementById("reimbTbl");

const url = "http://localhost:7000/"

//requestBtn.addEventListener("click", requestFunc);
searchBtn.addEventListener("click", getPastReimb);

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
            let td = document.createElement("td");
            td.innerText = reimb[data];
            row.appendChild(td);
        }
        reimbTbl.appendChild(row);
    }
}
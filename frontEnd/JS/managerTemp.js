let viewBtn = document.getElementById("viewBtn");
let updateBtn = document.getElementById("updateBtn")
let reimbTbl = document.getElementById("reimbTbl");
let reimbRqstTbl = document.getElementById("reimbRqstTbl");

const url = "http://localhost:7000/"

viewBtn.addEventListener("click", viewAllFunc);
updateBtn.addEventListener("click", updateFunc);

async function viewAllFunc(){

    let response = await fetch(url + "manager/allRequest", {
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

// async function updateFunc(){

//     let response = await fetch(url + "manager/update", {
//         method: "POST",
//         credentials: "include"
//     )};

//     if(response.status === 200){
//         let 
//     }
// }
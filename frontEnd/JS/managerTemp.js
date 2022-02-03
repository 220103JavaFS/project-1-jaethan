let viewBtn = document.getElementById("viewBtn");
let updateBtn = document.getElementById("updateBtn");
let viewUpdateBtb = document.getElementById("viewUpdatedBtn");
let reimbTbl = document.getElementById("reimbTbl");
let reimbRqstTbl = document.getElementById("reimbRqstTbl");

const url = "http://localhost:7000/"

viewBtn.addEventListener("click", viewAllFunc);
viewUpdateBtb.addEventListener("click", viewUpdatedFunc);
updateBtn.addEventListener("click", updateFunc);

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
            let td = document.createElement("td");
            td.innerText = reimb[data];
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

// async function updateFunc(){

//     let response = await fetch(url + "manager/update", {
//         method: "POST",
//         credentials: "include"
//     )};

//     if(response.status === 200){
//         let 
//     }
// }
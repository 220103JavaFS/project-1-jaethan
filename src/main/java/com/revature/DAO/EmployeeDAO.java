package com.revature.DAO;

import com.revature.models.Reimbursement;

import java.util.List;

public interface EmployeeDAO {
    List<Reimbursement> viewPastRequest();
    Reimbursement reimbRequest(Reimbursement r) ;
}

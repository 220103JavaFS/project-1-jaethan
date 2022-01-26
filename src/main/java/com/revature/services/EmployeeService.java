package com.revature.services;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAOImpl;
import com.revature.models.Reimbursement;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public List<Reimbursement> viewPastRequest(){
        return employeeDAO.viewPastRequest();
    }
    Reimbursement reimbRequest(Reimbursement r){
        return employeeDAO.reimbRequest(r);
    }

}

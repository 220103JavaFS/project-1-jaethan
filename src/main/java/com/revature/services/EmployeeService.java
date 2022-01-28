package com.revature.services;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAOImpl;
import com.revature.models.Reimbursement;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public List<Reimbursement> viewPastRequest(int authorId){
        return employeeDAO.viewPastRequest(authorId);
    }
    public boolean reimbRequest(Reimbursement r){
        return employeeDAO.reimbRequest(r);
    }

}

package com.revature.services;

import com.revature.DAO.ManagerDAO;
import com.revature.DAO.ManagerDAOImpl;
import com.revature.models.Reimbursement;

import java.util.List;

public class ManagerService {
    private ManagerDAO managerDAO = new ManagerDAOImpl();

    public List<Reimbursement> viewAllRequest(){
        return managerDAO.viewAllRequest();
    }
    public List<Reimbursement> viewUpdatedStatus(){
        return managerDAO.viewUpdatedStatus();
    }
    public boolean updateRequest(Reimbursement r){
        return managerDAO.updateRequest(r);
    }
}

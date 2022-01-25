package com.revature.DAO;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

import java.util.List;

public interface ManagerDAO {
    List<Reimbursement> viewAllRequest();
    List<Reimbursement> viewUpdatedStatus();
    boolean updateRequest(Reimbursement r);

}

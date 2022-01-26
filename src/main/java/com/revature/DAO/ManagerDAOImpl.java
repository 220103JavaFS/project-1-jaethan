package com.revature.DAO;

import com.revature.models.*;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAOImpl implements ManagerDAO{
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<Reimbursement> viewAllRequest() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 2;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<>();

            while(result.next()){
                Reimbursement request = new Reimbursement();
                request.setReimbId(result.getInt("reimb_id"));
                request.setReimbAmount(result.getInt("reimb_amount"));
                request.setReimbSubmitted(result.getLong("reimb_submitted"));
                request.setReimbResolved(result.getLong("reimb_resolved"));
                request.setReimbDescription(result.getString("reimb_description"));
                request.setReimbReceipt(result.getBytes("reimb_receipt"));
                int author = result.getInt("reimb_author");
                Users authorUser = userDAO.findbyId(author);
                request.setReimbAuthor(authorUser);
                int resolver = result.getInt("reimb_resolver");
                Users resolverUser = userDAO.findbyId(resolver);
                request.setReimbAuthor(resolverUser);
                ReimbursementStatus status = new ReimbursementStatus(result.getInt("reimb_status_id"),
                        result.getString("reimb_status"));
                request.setReimbStatusId(status);
                ReimbursementType type = new ReimbursementType(result.getInt("reimb_type_id"),
                        result.getString("reimb_type"));
                request.setReimbTypeId(type);
                list.add(request);
            }

            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Reimbursement> viewUpdatedStatus() {
        return null;
    }

    @Override
    public boolean updateRequest(Reimbursement r) {
        return false;
    }
}

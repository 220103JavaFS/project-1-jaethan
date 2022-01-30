package com.revature.DAO;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<Reimbursement> viewPastRequest(int authorId) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement AS r LEFT JOIN ers_reimbursement_type t ON  t.reimb_type_id = r.reimb_type_id LEFT JOIN ers_reimbursement_status " +
                    "s ON s.reimb_status_id = r.reimb_status_id WHERE reimb_author = "+ authorId + " AND (r.reimb_status_id = 2 OR r.reimb_status_id = 3);";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<>();

            while(result.next()){
                Reimbursement request = new Reimbursement();
                request.setReimbId(result.getInt("reimb_id"));
                request.setReimbAmount(result.getInt("reimb_amount"));
                request.setReimbSubmitted(result.getTimestamp("reimb_submitted"));
                request.setReimbResolved(result.getTimestamp("reimb_resolved"));
                request.setReimbDescription(result.getString("reimb_description"));
                request.setReimbReceipt(result.getBytes("reimb_receipt"));
                int author = result.getInt("reimb_author");
                if(author != 0){
                    Users authorUser = userDAO.findbyId(author);
                    request.setReimbAuthor(authorUser);
                }
                int resolver = result.getInt("reimb_resolver");
                if(resolver != 0) {
                    Users resolverUser = userDAO.findbyId(resolver);
                    request.setReimbAuthor(resolverUser);
                }
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
    public boolean reimbRequest(Reimbursement r) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)" +
                    "VALUES (?, (SELECT CURRENT_TIMESTAMP), ?, ?, 1, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setInt(++count, r.getReimbAmount());
            statement.setString(++count, r.getReimbDescription());
            statement.setInt(++count, r.getReimbAuthor().getUserId());
            statement.setInt(++count, r.getReimbTypeId().getTypeId());
            statement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

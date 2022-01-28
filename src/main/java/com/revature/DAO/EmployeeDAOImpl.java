package com.revature.DAO;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public List<Reimbursement> viewPastRequest() {
        return null;
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
            statement.setString(++count, r.getReimbAuthor().toString());
            statement.setInt(++count, r.getReimbTypeId().getTypeId());
            statement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

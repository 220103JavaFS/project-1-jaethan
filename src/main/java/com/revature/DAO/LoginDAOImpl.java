package com.revature.DAO;

import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean Login(String username, String password) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_users WHERE ers_username = '" + username +"' and ers_password = '" + password + "';";
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

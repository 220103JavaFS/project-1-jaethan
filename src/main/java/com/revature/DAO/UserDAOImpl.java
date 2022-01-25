package com.revature.DAO;

import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO{
    @Override
    public boolean Login(String username, String password) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE user_acc = '" + username +"' and user_password = '" + password + "';";
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

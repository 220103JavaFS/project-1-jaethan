package com.revature.DAO;

import com.revature.models.Roles;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

import java.sql.*;

public class UserDAOImpl implements UserDAO{
    @Override
    public Users findbyName(String userName) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM (SELECT * FROM ers_users u LEFT JOIN ers_user_roles r ON r.ers_user_role_id = u.user_role_id)" +
                " AS role_id WHERE ers_username = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet result = statement.executeQuery();

            Users user = new Users();

            while(result.next()){
                user.setUserId(result.getInt("ers_users_id"));
                user.setUsername(result.getString("ers_username"));
                user.setPassword(result.getString("ers_password"));
                user.setUserFirstName(result.getString("user_first_name"));
                user.setUserLastName(result.getString("user_last_name"));
                user.setEmail(result.getString("user_email"));
                Roles role = new Roles(result.getInt("user_role_id"),
                        result.getString("user_role"));
                user.setRoleId(role);
            }
            return user;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Users();
    }

    @Override
    public Users findbyId(int userId) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM (SELECT * FROM ers_users u LEFT JOIN ers_user_roles r ON r.ers_user_role_id = u.user_role_id)" +
                    " AS role_id WHERE ers_users_id = " + userId + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Users user = new Users();

            while(result.next()){
                user.setUserId(result.getInt("ers_users_id"));
                user.setUsername(result.getString("ers_username"));
                user.setPassword(result.getString("ers_password"));
                user.setUserFirstName(result.getString("user_first_name"));
                user.setUserLastName(result.getString("user_last_name"));
                user.setEmail(result.getString("user_email"));
                Roles role = new Roles(result.getInt("ers_user_role_id"),
                        result.getString("user_role"));
                user.setRoleId(role);
            }
            return user;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Users();
    }
}

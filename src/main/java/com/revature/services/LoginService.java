package com.revature.services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;

public class LoginService {
    private UserDAO userDAO = new UserDAOImpl();
    public boolean login(String username, String password){
        return userDAO.Login(username, password);
    }
}

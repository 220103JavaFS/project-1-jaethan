package com.revature.services;

import com.revature.DAO.LoginDAO;
import com.revature.DAO.LoginDAOImpl;

public class LoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();
    public boolean login(String username, String password){
        return loginDAO.Login(username, password);
    }
}

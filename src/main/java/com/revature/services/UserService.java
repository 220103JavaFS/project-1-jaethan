package com.revature.services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.Users;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();
    public Users findbyName(String userName){
        return userDAO.findbyName(userName);
    }
}

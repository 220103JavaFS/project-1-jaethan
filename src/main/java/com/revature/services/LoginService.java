package com.revature.services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.Encrypt;
import com.revature.models.Users;

import java.security.NoSuchAlgorithmException;

public class LoginService {

    public LoginService() {
    }

    public LoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private UserDAO userDAO = new UserDAOImpl();
    private static Encrypt encryptor = new Encrypt();

    public boolean login(String username, String password) throws NoSuchAlgorithmException {
        Users getuser = userDAO.findbyName(username);
        if(getuser != null){
            String passCheck = encryptor.encoder(password);
            String securePassword = getuser.getPassword();
            if(securePassword.equals(passCheck)){
                return true;
            }else {
                System.out.println("Password didnt match");
                return false;
            }
        }else{
            return false;
        }
    }
}

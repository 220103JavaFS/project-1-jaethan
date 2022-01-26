package com.revature.DAO;

import com.revature.models.Users;

public interface UserDAO {
    Users findbyId(int userId);
}

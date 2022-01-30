package com.revature.DAO;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.Roles;
import com.revature.models.Users;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    @Mock
    private static UserDAO mockedDAO = new UserDAOImpl();
    private static Roles testRole = new Roles(
            2,
            "Manager");

    private static Users testUser = new Users(
            1,
            "manager",
            "2e2b24f8ee40bb847fe85bb23336a39ef5948e6b49d897419ced68766b16967a",
            "admin",
            "god",
            "admin@admin.com",
            testRole
    );

    @Test
    @Order(1)
    public void testFindByUsername() {
        assertEquals(testUser,mockedDAO.findbyName(testUser.getUsername()));
    }

    @Test
    @Order(2)
    public void testFindById() {
        assertEquals(testUser,mockedDAO.findbyId(testUser.getUserId()));
    }
}

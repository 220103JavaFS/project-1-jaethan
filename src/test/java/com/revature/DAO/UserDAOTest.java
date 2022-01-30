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
            1,
            "admin");

    private static Users testUser = new Users(
            2,
            "admin",
            "password",
            "fname",
            "lname",
            "test@test.com",
            testRole
    );
    private static ReimbursementStatus testStatus = new ReimbursementStatus(
            3,
            "pending"
    );
    private static Reimbursement reimbursement = new Reimbursement(
            1,
            testUser,
            testStatus
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

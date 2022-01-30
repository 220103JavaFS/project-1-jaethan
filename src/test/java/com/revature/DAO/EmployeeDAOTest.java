package com.revature.DAO;

import com.revature.models.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDAOTest {

    @Mock
    private static EmployeeDAO mockedDAO = new EmployeeDAOImpl();
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
    private static ReimbursementType testType = new ReimbursementType(
            1,
            "ABC"
    );
    private static Reimbursement reimbursement = new Reimbursement(
            1,
            400,
            null,
            null,
            "adsfsd",
            null,
            testUser,
            null,
            testStatus,
            testType
    );

    @Test
    @Order(1)
    public void testViewPastRq() {
        assertFalse(mockedDAO.viewPastRequest(reimbursement.getReimbAuthor().getUserId()).isEmpty());
    }

    @Test
    @Order(2)
    public void testReimbRq() {
        assertTrue(mockedDAO.reimbRequest(reimbursement));
    }
}

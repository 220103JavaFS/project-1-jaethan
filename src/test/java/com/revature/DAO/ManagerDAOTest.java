package com.revature.DAO;

import com.revature.models.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerDAOTest {

    @Mock
    private static ManagerDAO mockedDAO = new ManagerDAOImpl();
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
    public void testViewAllRq() {
        assertFalse(mockedDAO.viewAllRequest().isEmpty());
    }

    @Test
    @Order(2)
    public void testViewUpdate() {
        assertFalse(mockedDAO.viewUpdatedStatus().isEmpty());
    }

    @Test
    @Order(3)
    public void testUpdateRq() {
        assertTrue(mockedDAO.updateRequest(reimbursement));
    }
}

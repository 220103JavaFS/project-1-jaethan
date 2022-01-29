package com.revature.services;

import com.revature.DAO.UserDAOImpl;
import com.revature.models.Encrypt;
import com.revature.models.Roles;
import com.revature.models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest {

    private static LoginService testInstance;

    @Mock
    private static UserDAOImpl mockedDAO;
    private static Users testUser = new Users();
    private static Roles testRole = new Roles();
    private static Encrypt testEncrypt = new Encrypt();

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        testUser.setUserId(3);
        testUser.setUsername("employee");
        testUser.setPassword(testEncrypt.encoder("password"));
        testUser.setUserFirstName("whyso");
        testUser.setUserLastName("serious");
        testUser.setEmail("test@test.com");
        testRole.setRoleId(3);
        MockitoAnnotations.openMocks(this);
        testInstance = new LoginService(mockedDAO);
        Mockito.when(mockedDAO.findbyName("employee")).thenReturn(testUser);
    }

    @Test
    @Order(1)
    public void testLoginSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.login("employee", "password"));
    }

    @Test
    @Order(2)
    public void testLoginWrongUsername() throws NoSuchAlgorithmException {
        assertFalse(testInstance.login("employeeee", "password"));
    }

    @Test
    @Order(3)
    public void testLoginWrongPassword() throws NoSuchAlgorithmException {
        assertFalse(testInstance.login("employee", "pass"));
    }

    @Test
    @Order(4)
    public void testLoginWrongEverything() throws NoSuchAlgorithmException {
        assertFalse(testInstance.login("employeeee", "pass"));
    }

}

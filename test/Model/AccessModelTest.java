/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import Helper.DBException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class AccessModelTest {
    
    public AccessModelTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testAuthenticate() throws DBException {
        AccessModel instance = new AccessModel();

        // Valid account
        {
            String username = "admin";
            String password = "123";
            boolean expResult = true;
            boolean result = instance.authenticate(username, password);
            assertEquals(expResult, result);
        }

        // Invalid username
        {
            String username = "nonexistent";
            String password = "123";
            boolean expResult = false;
            boolean result = instance.authenticate(username, password);
            assertEquals(expResult, result);
        }

        // Incorrect password
        {
            String username = "admin";
            String password = "wrongpassword";
            boolean expResult = false;
            boolean result = instance.authenticate(username, password);
            assertEquals(expResult, result);
        }

        // Empty credentials
        {
            String username = "";
            String password = "";
            boolean expResult = false;
            boolean result = instance.authenticate(username, password);
            assertEquals(expResult, result);
        }
    }
}

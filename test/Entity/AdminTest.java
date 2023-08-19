/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class AdminTest {
    
    public Admin newAdmin;
    
    public AdminTest() {
        newAdmin = new Admin(1,"bminh","123");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Admin.
     */
    @Test
    public void testGetId() {
        int expResult = 1;
        int result = newAdmin.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Admin.
     */
    @Test
    public void testSetId() {
        int expResult = 2;
        int id = 2;
        newAdmin.setId(id);
        int result = newAdmin.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Admin.
     */
    @Test
    public void testGetUsername() {
        String expResult = "bminh";
        String result = newAdmin.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Admin.
     */
    @Test
    public void testSetUsername() {
        String expResult = "minhnew";
        String username = "minhnew";
        newAdmin.setUsername(username);
        String result = newAdmin.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        String expResult = "123";
        String result = newAdmin.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() {
        String expResult = "123456";
        String password = "123456";
        newAdmin.setPassword(password);
        String result = newAdmin.getPassword();
        assertEquals(expResult, result);
    }
    
}

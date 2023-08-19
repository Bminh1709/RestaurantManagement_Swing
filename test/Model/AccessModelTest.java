/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

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
    public void testAuthenticate() {
        System.out.println("authenticate");
        String username = "adminms4";
        String password = "1232d";
        AccessModel instance = new AccessModel();
        boolean expResult = false;
        boolean result = instance.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
}

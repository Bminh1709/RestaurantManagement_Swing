/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class OrderTest {

    //Order newOrder = new Order(1, "Minh", false, df.parse("2023-08-18"), 20000);
    
    public OrderTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Order instance = new Order();
        instance.setId(id);
    }
    
}

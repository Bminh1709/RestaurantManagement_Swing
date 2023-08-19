/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class OrderTest {

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Order newOrder;
    
    public OrderTest() {
        try {
            newOrder = new Order(1, "Minh", false, df.parse("2023-08-18"), 20000);
            // Rest of your code
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet() {
        String formattedDate = df.format(newOrder.getDateOrder());
        // Correct Order
        assertEquals(1, newOrder.getId());
        assertEquals("Minh", newOrder.getCustomerName());
        assertEquals(false, newOrder.isStatus());
        assertEquals("2023-08-18", formattedDate);
        assertTrue(20000 == newOrder.getTotalPrice());
        // Incorrect Order
        assertFalse(3 == newOrder.getId());
        assertFalse("Dung" == newOrder.getCustomerName());
        assertFalse(true == newOrder.isStatus());
        assertFalse("2024-09-18" == formattedDate);
        assertFalse(50000 == newOrder.getTotalPrice());
    }
    
}

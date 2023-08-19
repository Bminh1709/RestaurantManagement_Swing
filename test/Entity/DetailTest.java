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
public class DetailTest {
    
    Detail detail = new Detail(1, 2, 4);
    
    public DetailTest() {
    }

    @Test
    public void testGet() {
        Detail instance = new Detail(1, 2, 4);
        assertEquals(detail.getId(), instance.getId());
        assertEquals(detail.getIdCustomer(), instance.getIdCustomer());
        assertEquals(detail.getIdDish(), instance.getIdDish());
    }

  
    
}

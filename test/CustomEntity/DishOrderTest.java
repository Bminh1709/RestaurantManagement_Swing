/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CustomEntity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class DishOrderTest {
    
    @Test
    public void testDishOrderAttributes() {
        DishOrder dishOrder = new DishOrder();
        dishOrder.setId(20);
        dishOrder.setName("Spaghetti");
        dishOrder.setQuantity(2);
        dishOrder.setTotalPrice(20000);

        assertEquals(20, dishOrder.getId());
        assertEquals("Spaghetti", dishOrder.getName());
        assertEquals(2, dishOrder.getQuantity());
        assertEquals(20000, dishOrder.getTotalPrice(), 0.01); // Delta is used for double comparison
    }

    @Test
    public void testDishOrderConstructor() {
        DishOrder dishOrder = new DishOrder(30, "Pizza", 3, 30000);

        assertEquals(30, dishOrder.getId());
        assertEquals("Pizza", dishOrder.getName());
        assertEquals(3, dishOrder.getQuantity());
        assertEquals(30000, dishOrder.getTotalPrice(), 0.01); // Delta is used for double comparison
    }
}

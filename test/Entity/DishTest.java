/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class DishTest {
    
    Dish newDish = new Dish(1,2,"Salmon",20000);
    
    public DishTest() {
    }
   
    @Test
    public void testGet() {
        // Correct Dish
        assertEquals(1, newDish.getId());
        assertEquals(2, newDish.getCategoryId());
        assertEquals("Salmon", newDish.getName());
        assertTrue(20000 == newDish.getPrice());
        // Incorrect Dish
        assertFalse(2 == newDish.getId());
        assertFalse(1 == newDish.getCategoryId());
        assertFalse("Salmonnnn".equals(newDish.getName()));
        assertFalse(40000 == newDish.getPrice());
    }

    @Test
    public void testSet() {
        Dish instance = new Dish();
        instance.setId(5);
        instance.setCategoryId(12);
        instance.setName("Lemon");
        instance.setPrice(40000);
        
        assertFalse(instance.getId() == 1);
        assertFalse(instance.getCategoryId() == 2);
        assertFalse(instance.getName().equals("Salmon"));
        assertFalse(instance.getPrice() == 20000);
    } 
}

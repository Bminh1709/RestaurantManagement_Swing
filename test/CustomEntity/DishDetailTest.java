/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CustomEntity;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author MINH
 */
public class DishDetailTest {
    
    private DishDetail dishDetail;

    @Before
    public void setUp() {
        dishDetail = new DishDetail(1, "Appetizer", "Fried Chicken", 10000);
    }

    @Test
    public void testGetDishID() {
        assertEquals(1, dishDetail.getDishID());
    }

    @Test
    public void testSetDishID() {
        dishDetail.setDishID(2);
        assertEquals(2, dishDetail.getDishID());
    }

    @Test
    public void testGetCategory() {
        assertEquals("Appetizer", dishDetail.getCategory());
    }

    @Test
    public void testSetCategory() {
        dishDetail.setCategory("Main Course");
        assertEquals("Main Course", dishDetail.getCategory());
    }

    @Test
    public void testGetDish() {
        assertEquals("Fried Chicken", dishDetail.getDish());
    }

    @Test
    public void testSetDish() {
        dishDetail.setDish("Grilled Salmon");
        assertEquals("Grilled Salmon", dishDetail.getDish());
    }

    @Test
    public void testGetPrice() {
        double price = 10000;
        assertTrue(price == dishDetail.getPrice());
    }

    @Test
    public void testSetPrice() {
        dishDetail.setPrice(15000);
        assertTrue(15000 == dishDetail.getPrice());
    }
}

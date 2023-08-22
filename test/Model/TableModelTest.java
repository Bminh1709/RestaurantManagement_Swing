/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import Entity.Category;
import Entity.Dish;
import Entity.Order;
import Helper.DBException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author MINH
 */
public class TableModelTest {
    
    private TableModel tableModel;

    @Before
    public void setUp() throws DBException {
        tableModel = new TableModel();
    }

    @Test
    public void testGetListOrders() throws DBException {
        ArrayList<Order> orders = tableModel.getListOrders();

        assertNotNull(orders); // Check if the list is not null
        assertTrue(orders.size() > 0); // Check length
    }

    @Test
    public void testGetListCategory() throws DBException {
        List<Category> categories = tableModel.getListCategory();

        assertNotNull(categories); // Check if the list is not null
        assertTrue(categories.size() > 0); // Check length
    }

    @Test
    public void testGetListDishes() throws DBException {
        int categoryId = 1; 
        List<Dish> dishes = tableModel.getListDishes(categoryId);

        assertNotNull(dishes); // Check if the list is not null
        assertTrue(dishes.size() > 0); // Check if there are dishes in the list
    }

    @Test
    public void testAddNewTable() throws DBException {
        String customerName = "Test Customer";
        tableModel.addNewTable(customerName);
    }

    @Test
    public void testDeleteEmptyOrder() throws DBException {
        int orderId = 17; // Order just added above
        boolean result = tableModel.deleteEmptyOrder(orderId);
        assertTrue(result);
    }

    @Test
    public void testAddDishForOrder() throws DBException {
        int dishId = 36;
        int orderId = 18;
        int quantity = 2;
        double modifiedPrice = 12999;

        boolean result = tableModel.addDishForOrder(dishId, orderId, quantity, modifiedPrice);
        assertTrue(result);
    }
    
}

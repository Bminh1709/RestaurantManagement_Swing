/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import CustomEntity.DishOrder;
import Entity.Order;
import Helper.DBException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author MINH
 */
public class InvoiceModelTest {
    
    private InvoiceModel invoiceModel;

    @Before
    public void setUp() throws DBException {
        invoiceModel = new InvoiceModel();
    }

    @Test
    public void testGetListOrderDishes() throws DBException {
        int orderId = 7; // Adjust the order ID based on your data
        ArrayList<DishOrder> dishOrders = invoiceModel.getListOrderDishes(orderId);
        assertNotNull(dishOrders);
        assertTrue(dishOrders.size() > 0);
    }

    @Test
    public void testGetTotalMoney() throws DBException {
        int orderId = 7; // Adjust the order ID based on your data
        double totalMoney = invoiceModel.getTotalMoney(orderId);
        assertTrue(totalMoney >= 0);
    }

    @Test
    public void testCheckBillStatus() throws DBException {
        int orderId = 7; 
        boolean billStatus = invoiceModel.checkBillStatus(orderId);
        assertFalse(billStatus);
        
        int orderId2 = 10;
        boolean billStatus2 = invoiceModel.checkBillStatus(orderId);
        assertFalse(billStatus2);
    }

    @Test
    public void testSetBillStatus() throws DBException {
        int orderId = 7; // Adjust the order ID based on your data
        boolean updatedStatus = invoiceModel.setBillStatus(orderId);
        assertTrue(updatedStatus);
    }

    @Test
    public void testGetInfoBill() throws DBException {
        int orderId = 7; // Adjust the order ID based on your data
        Order order = invoiceModel.getInfoBill(orderId);
        assertNotNull(order);
        assertEquals(orderId, order.getId());
    }
}

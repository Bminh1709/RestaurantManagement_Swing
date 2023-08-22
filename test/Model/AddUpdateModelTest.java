/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import Entity.Category;
import Helper.DBException;
import Helper.NumberException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author MINH
 */
public class AddUpdateModelTest {
    
    private AddUpdateModel addUpdateModel;

    @Before
    public void setUp() throws DBException {
        // Initialize the addUpdateModel instance if needed
        addUpdateModel = new AddUpdateModel();
    }

    @Test
    public void testGetListCategory() throws DBException {
        List<Category> categories = addUpdateModel.getListCategory();

        assertNotNull(categories);
        assertTrue(categories.size() > 0);
    }

    @Test
    public void testCheckDishExist() throws DBException {
        int idCat = 36;
        String dishName = "Test Dish";

        boolean result = addUpdateModel.checkDishExist(idCat, dishName);

        assertFalse(result);
    }

    @Test
    public void testAddDish() throws DBException, NumberException {
        int idCat = 2; 
        String name = "Test Dish";
        double price = 10999;

        boolean result = addUpdateModel.addDish(idCat, name, price);

        assertTrue(result);
    }

    @Test
    public void testUpdateDish() throws DBException, NumberException {
        int idDish = 51; 
        int idCat = 1; 
        String name = "Updated Dish";
        double price = 15999;

        boolean result = addUpdateModel.updateDish(idDish, idCat, name, price);

        assertTrue(result);
    }
}

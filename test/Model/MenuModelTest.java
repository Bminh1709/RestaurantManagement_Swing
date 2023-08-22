/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import CustomEntity.DishDetail;
import Entity.Category;
import Helper.DBException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MINH
 */
public class MenuModelTest {
    
    private MenuModel menuModel;
    
    public MenuModelTest() throws DBException {
        menuModel = new MenuModel();
    }

    @Test
    public void testGetListDish() throws DBException {
        ArrayList<DishDetail> result = menuModel.getListDish();
        // Assert that the result is not null
        assertNotNull(result);
        // check if the list size > 0
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetListCategory() throws DBException {
        List<Category> result = menuModel.getListCategory();
        // Assert that the result is not null
        assertNotNull(result);
        // check if the list size > 0
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetListFilterDish() throws DBException {
        List<DishDetail> result = menuModel.getListFilterDish("Seafood", "fish");
        // Assert that the result is not null
        assertNotNull(result);
        // check if the list size > 0
        assertTrue(result.size() > 0);
    }

    @Test
    public void testDeleteDish() throws DBException {
        int idToDelete = 4; 
        boolean result = menuModel.deleteDish(idToDelete);
        assertTrue(result); 
    }

    @Test
    public void testCheckDishExist() throws DBException {
        int categoryId = 2;
        String nameDish = "Fresh salad"; 
        boolean result = menuModel.checkDishExist(categoryId, nameDish);
        assertTrue(result);
    }

    @Test
    public void testAddDish() throws DBException {
        int idCat = 1; 
        String name = "Test Dish";
        double price = 10999;
        boolean result = menuModel.addDish(idCat, name, price);
        assertTrue(result);
    }
}

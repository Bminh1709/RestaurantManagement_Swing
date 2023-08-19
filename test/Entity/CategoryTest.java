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
public class CategoryTest {
    
    public CategoryTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Category instance = new Category(1,"Seafood");
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Category instance = new Category();
        instance.setId(id);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Category instance = new Category();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Category instance = new Category();
        instance.setName(name);
    }
    
}

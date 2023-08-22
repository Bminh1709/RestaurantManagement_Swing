/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Core.DB;
import CustomEntity.DishDetail;
import Entity.Category;
import Helper.DBException;
import Model.MenuModel;
import View.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MINH
 */
public class MenuController extends DB{
    private MenuModel menuModel;
    private Menu menuView;

    public MenuController(MenuModel menuModel, Menu menuView) throws DBException {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public void loadDishes() throws DBException {
        try {
            // Call getListDish() method from MenuModel to get the list of dishes
            ArrayList<DishDetail> dishes = menuModel.getListDish();
            // Pass the list of dishes to view and display them
            menuView.displayDishes(dishes);
        } catch (DBException dbException) {
            menuView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void loadCategories() throws DBException {
        try {
            List<Category> categories = menuModel.getListCategory();
            menuView.displayCategories(categories);
        } catch (DBException dbException) {
            menuView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void searchDishes(String category, String filter) throws DBException {
        try {
            ArrayList<DishDetail> filterDishes = menuModel.getListFilterDish(category, filter);
            menuView.displayDishes(filterDishes);
        } catch (DBException dbException) {
            menuView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void deleteDish(int id) throws DBException {
        Boolean checkDeleteDish = menuModel.deleteDish(id);
        menuView.resultDeleteDish(checkDeleteDish);
    } 
    
    public boolean addDataToDB(int idCat, String name, double price) throws DBException {
        boolean checkDishExist = menuModel.checkDishExist(idCat, name);
        if (checkDishExist) {
            return false;
        }
        else
        {
            boolean checkAddDish = menuModel.addDish(idCat, name, price);
            return checkAddDish;
        }
    }
}

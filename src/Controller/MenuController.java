/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Core.DB;
import CustomEntity.DishDetail;
import Entity.Category;
import Model.MenuModel;
import View.Menu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINH
 */
public class MenuController extends DB{
    private MenuModel menuModel;
    private Menu menuView;

    public MenuController(MenuModel menuModel, Menu menuView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public void loadDishes() {
        // Call getListDish() method from MenuModel to get the list of dishes
        ArrayList<DishDetail> dishes = menuModel.getListDish();
        // Pass the list of dishes to view and display them
        menuView.displayDishes(dishes);
    }
    
    public void loadCategories() {
        List<Category> categories = menuModel.getListCategory();
        menuView.displayCategories(categories);
    }
    
    public void searchDishes(String category, String filter) {
        ArrayList<DishDetail> filterDishes = menuModel.getListFilterDish(category, filter);
        menuView.displayDishes(filterDishes);
    }
    
    public void deleteDish(int id) {
        Boolean checkDeleteDish = menuModel.deleteDish(id);
        menuView.resultDeleteDish(checkDeleteDish);
    } 
}

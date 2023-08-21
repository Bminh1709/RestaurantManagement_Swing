/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Category;
import Entity.Dish;
import Helper.DBException;
import Model.TableModel;
import View.AddDishOrderForm;
import java.util.List;

/**
 *
 * @author MINH
 */
public class AddDishOrderController {
    private TableModel tableModel;
    private AddDishOrderForm addDishOrderView;

    public AddDishOrderController(TableModel tableModel, AddDishOrderForm addDishView) {
        this.tableModel = tableModel;
        this.addDishOrderView = addDishView;
    }

    public void loadCategories() throws DBException {
        try {
            List<Category> categories = tableModel.getListCategory();
            addDishOrderView.displayCategories(categories);
        } catch (DBException dbException) {
            addDishOrderView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void loadDishes(int id) throws DBException {
        try {
            List<Dish> dishes = tableModel.getListDishes(id);
            addDishOrderView.displayDishes(dishes);
        } catch (DBException dbException) {
            addDishOrderView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void addDishForOrder(int dishID, int orderID, int quantity, double modifiedPrice) throws DBException {
        try {
            boolean checkAddDishForOrder = tableModel.addDishForOrder(dishID, orderID, quantity, modifiedPrice);
            addDishOrderView.resultAddDishForOrder(checkAddDishForOrder);
        } catch (DBException dbException) {
            addDishOrderView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
}

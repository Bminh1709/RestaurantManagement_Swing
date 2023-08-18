/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Category;
import Entity.Dish;
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

    public void loadCategories() {
        List<Category> categories = tableModel.getListCategory();
        addDishOrderView.displayCategories(categories);
    }
    
    public void loadDishes(int id) {
        List<Dish> dishes = tableModel.getListDishes(id);
        addDishOrderView.displayDishes(dishes);
    }
    
    public void addDishForOrder(int dishID, int orderID, int quantity, double modifiedPrice) {
        boolean checkAddDishForOrder = tableModel.addDishForOrder(dishID, orderID, quantity, modifiedPrice);
        addDishOrderView.resultAddDishForOrder(checkAddDishForOrder);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Category;
import Model.AddUpdateModel;
import View.AddUpdateForm;
import java.util.List;

/**
 *
 * @author MINH
 */
public class AddUpdateController {
    private AddUpdateModel addUpdateModel;
    private AddUpdateForm addUpdateView;

    public AddUpdateController(AddUpdateModel addUpdateModel, AddUpdateForm addUpdateForm) {
        this.addUpdateModel = addUpdateModel;
        this.addUpdateView = addUpdateForm;
    }
    
    public void loadCategories() {
        List<Category> categories = addUpdateModel.getListCategory();
        addUpdateView.displayCategories(categories);
    }
    
    public void addDish(int idCat, String name, double price) {
        boolean checkDishExist = addUpdateModel.checkDishExist(idCat, name);
        if (checkDishExist == true) // the Dish has been existed - cannot add new
        {
            // Return 0 if the dish exists
            addUpdateView.resultAddDish(0);
        }
        else // If Dish is new ==> create
        {
            boolean checkAddDish = addUpdateModel.addDish(idCat, name, price);
            if (checkAddDish) {
                // Return 1 if add success
                addUpdateView.resultAddDish(1);
            }
            else
                addUpdateView.resultAddDish(-1);
        }
    }
}

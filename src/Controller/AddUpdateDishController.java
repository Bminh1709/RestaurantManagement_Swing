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
public class AddUpdateDishController {
    private AddUpdateModel addUpdateModel;
    private AddUpdateForm addUpdateView;

    public AddUpdateDishController(AddUpdateModel addUpdateModel, AddUpdateForm addUpdateForm) {
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
            addUpdateView.resultAddUpdateDish(0);
        }
        else // If Dish is new ==> create
        {
            boolean checkAddDish = addUpdateModel.addDish(idCat, name, price);
            if (checkAddDish) {
                // Return 1 if add success
                addUpdateView.resultAddUpdateDish(1);
            }
            else
                addUpdateView.resultAddUpdateDish(-1);
        }
    }
    
      public void updateDish(int idDish, int idCat, String name, double price) {
        boolean checkUpdateDish = addUpdateModel.updateDish(idDish, idCat, name, price);
        if (checkUpdateDish) {
            // Return 1 if add success
            addUpdateView.resultAddUpdateDish(1);
        }
        else
            addUpdateView.resultAddUpdateDish(-1);
    }
}

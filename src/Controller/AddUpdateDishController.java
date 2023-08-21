/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Category;
import Helper.DBException;
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
    
    public void loadCategories() throws DBException {
        try {
            List<Category> categories = addUpdateModel.getListCategory();
            addUpdateView.displayCategories(categories);
        } catch (DBException dbException) {
            addUpdateView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void addDish(int idCat, String name, double price) throws DBException {
        try {
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
        } catch (DBException dbException) {
            addUpdateView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
      public void updateDish(int idDish, int idCat, String name, double price) throws DBException {
        try {
            boolean checkUpdateDish = addUpdateModel.updateDish(idDish, idCat, name, price);
            if (checkUpdateDish) {
                // Return 1 if add success
                addUpdateView.resultAddUpdateDish(1);
            }
            else
                addUpdateView.resultAddUpdateDish(-1);
        } catch (DBException dbException) {
            addUpdateView.Error("An error occurred: " + dbException.getMessage());
        }
    }
}

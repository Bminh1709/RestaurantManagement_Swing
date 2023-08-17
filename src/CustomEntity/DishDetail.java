/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomEntity;

/**
 *
 * @author MINH
 */
public class DishDetail {
    private int dishID;
    private String category;
    private String dish;
    private double price;

    public DishDetail() {
    }

    public DishDetail(int dishID, String category, String dish, double price) {
        this.dishID = dishID;
        this.category = category;
        this.dish = dish;
        this.price = price;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}

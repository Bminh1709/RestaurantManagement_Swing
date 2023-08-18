/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import Entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINH
 */
public class AddUpdateModel extends DB {
    
    public List<Category> getListCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // Data are stored in rs.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category model = new Category();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("nameCategory"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean checkDishExist(int idCat, String name) {
        String sql = "SELECT * FROM `dish` WHERE catogoryId = ? AND name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCat);
            ps.setString(2, name);

            ResultSet rs = ps.executeQuery();

            // Check if is there any rows (check if Dish already existed)
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addDish(int idCat, String name, double price) {
        String sql = "INSERT INTO `dish`(`id`, `catogoryId`, `name`, `price`) VALUES (NULL,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCat);
            ps.setString(2, name);
            ps.setDouble(3, price);

            // Execute the deletion query
            int rowsAffected = ps.executeUpdate();

            // Check if any rows were affected (deleted)
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public boolean updateDish(int idDish, int idCat, String name, double price) {
        String sql = "UPDATE `dish` SET `catogoryId`=?,`name`=?,`price`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCat);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, idDish);

            // Execute the deletion query
            int rowsAffected = ps.executeUpdate();

            // Check if any rows were affected (deleted)
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

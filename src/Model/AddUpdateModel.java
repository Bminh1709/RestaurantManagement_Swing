/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import Entity.Category;
import Helper.DBException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINH
 */
public class AddUpdateModel extends DB {
    
    public List<Category> getListCategory() throws DBException {
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
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
        return list;
    }
    
    public boolean checkDishExist(int idCat, String name) throws DBException {
        String sql = "SELECT * FROM `dish` WHERE catogoryId = ? AND name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCat);
            ps.setString(2, name);

            ResultSet rs = ps.executeQuery();

            // Check if is there any rows (check if Dish already existed)
            return rs.next();
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
    }
    
    public boolean addDish(int idCat, String name, double price) throws DBException {
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
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
    }
    
     public boolean updateDish(int idDish, int idCat, String name, double price) throws DBException {
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
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
    }
}

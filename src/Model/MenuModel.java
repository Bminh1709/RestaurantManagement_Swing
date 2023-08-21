/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import CustomEntity.DishDetail;
import Entity.Category;
import Helper.DBException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MINH
 */
public class MenuModel extends DB{

    public MenuModel() throws DBException{
    }
    
    public ArrayList<DishDetail> getListDish() throws DBException {
        // Create list DishDetail
        ArrayList<DishDetail> list = new ArrayList<>();
        String sql = "SELECT d.id, c.nameCategory, d.name, d.price FROM dish d LEFT JOIN category c on d.catogoryId = c.id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // Data are stored in rs.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DishDetail model = new DishDetail();
                model.setDishID(rs.getInt("id"));
                model.setCategory(rs.getString("nameCategory"));
                model.setDish(rs.getString("name"));
                model.setPrice(rs.getDouble("price"));
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
    
    public ArrayList<DishDetail> getListFilterDish(String category, String filter) throws DBException {
        ArrayList<DishDetail> list = new ArrayList<>();
        String sql;
        if (category.equals("All")) {
            sql = "SELECT d.id, c.nameCategory, d.name, d.price " +
                  "FROM dish d " +
                  "LEFT JOIN category c ON d.catogoryId = c.id " +
                  "WHERE d.name LIKE ?"; 
        } else {
            sql = "SELECT d.id, c.nameCategory, d.name, d.price " +
                  "FROM dish d " +
                  "LEFT JOIN category c ON d.catogoryId = c.id " +
                  "WHERE c.nameCategory LIKE ? AND d.name LIKE ?";
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (!category.equals("All")) {
                ps.setString(1, "%" + category + "%");
                ps.setString(2, "%" + filter + "%");
            } else {
                ps.setString(1, "%" + filter + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DishDetail model = new DishDetail();
                model.setDishID(rs.getInt("id"));
                model.setCategory(rs.getString("nameCategory"));
                model.setDish(rs.getString("name"));
                model.setPrice(rs.getDouble("price"));
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
    
    public boolean deleteDish(int id) throws DBException {
        String sql = "DELETE FROM dish WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

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

}

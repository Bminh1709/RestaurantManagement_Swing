/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import Entity.Category;
import Entity.Dish;
import Entity.Order;
import Helper.DBException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINH
 */
public class TableModel extends DB {

    public TableModel() throws DBException {
    }

    public ArrayList<Order> getListOrders() throws DBException {
        // Create list DishDetail
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // Data are stored in rs.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order model = new Order();
                model.setId(rs.getInt("id"));
                model.setCustomerName(rs.getString("customer"));
                model.setDateOrder(rs.getDate("dateOrder"));
                model.setTotalPrice(rs.getDouble("totalPrice"));
                model.setStatus(rs.getBoolean("status"));
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
    
    public void setTotalPriceForOrder(int id) throws DBException {
        String sql = "UPDATE `orders` SET `totalPrice`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, getTotalPrice(id));
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
    }
    
    public double getTotalPrice(int id) throws DBException {
        double totalPrice = 0.0; // default value
        String sql = "SELECT SUM(priceDish) FROM detail WHERE idOrder = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalPrice = rs.getDouble(1); // Get the value from the first column
            }
            return totalPrice;
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
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
    
    public List<Dish> getListDishes(int id) throws DBException {
        List<Dish> list = new ArrayList<>();
        String sql = "SELECT * FROM `dish` WHERE catogoryId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dish model = new Dish();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setPrice(rs.getDouble("price"));
                model.setCategoryId(rs.getInt("catogoryId"));
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
    
    public void addNewTable(String name) throws DBException {
        String sql = "INSERT INTO `orders`(`id`, `customer`, `status`, `dateOrder`, `totalPrice`) VALUES (NULL,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setBoolean(2, false);
            ps.setDate(3,Date.valueOf(LocalDate.now()));
            ps.setDouble(4, 0);
            
            ps.executeUpdate();
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
    }
    
    public boolean deleteEmptyOrder(int id) throws DBException {
        String sql = "DELETE FROM `orders` WHERE id = ? AND totalPrice <= 0";
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
    
    public boolean deleteOrder(int id) throws DBException {
        String sql = "DELETE FROM `orders` WHERE id = ? AND status = true";
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
    
    public boolean checkOrderStatus(int orderID) throws DBException {
        String sql = "SELECT * FROM `orders` WHERE id = ? AND status = true";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            
            ResultSet rs = ps.executeQuery();

            // if status = true => return yes
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
    
    public boolean addDishForOrder(int dishID, int orderID, int quantity, double modifiedPrice) throws DBException {
        String sql = "INSERT INTO `detail`(`id`, `idDish`, `idOrder`, `quantity`, `priceDish`) VALUES (NULL,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, dishID);
            ps.setInt(2, orderID);
            ps.setInt(3, quantity);
            ps.setDouble(4, modifiedPrice);
            
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

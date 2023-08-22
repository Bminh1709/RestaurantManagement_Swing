/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import CustomEntity.DishOrder;
import Entity.Order;
import Helper.DBException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MINH
 */
public class InvoiceModel extends DB {

    public InvoiceModel() throws DBException {
    }
    
    public ArrayList<DishOrder> getListOrderDishes(int id) throws DBException {
        // Create list DishDetail
        ArrayList<DishOrder> list = new ArrayList<>();
        String sql = "SELECT D.id, DI.name, D.quantity, D.priceDish FROM detail D "
                + "LEFT JOIN dish DI on D.idDish = DI.id "
                + "LEFT JOIN orders O on D.idOrder = O.id "
                + "WHERE O.id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // Data are stored in rs.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DishOrder model = new DishOrder();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setQuantity(rs.getInt("quantity"));
                model.setTotalPrice(rs.getDouble("priceDish"));
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
    
    public double getTotalMoney(int id) throws DBException {
        double totalPrice = 0.0; // default value
        String sql = "SELECT SUM(priceDish) FROM detail WHERE idOrder = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalPrice = rs.getDouble(1); // Get the value from the first column
            }
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
        return totalPrice;
    }
    
    public boolean checkBillStatus(int id) throws DBException {
        String sql = "SELECT * FROM `orders` WHERE id = ? AND status = false";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            // if status = false => return true
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
    
    public boolean setBillStatus(int id) throws DBException {
        String sql = "UPDATE `orders` SET`status`= true WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            
            int rowsAffected = ps.executeUpdate();

            // if status is set to true => return true
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
    
    public Order getInfoBill(int id) throws DBException {
        // Create list DishDetail
        Order model = new Order();
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // Data are stored in rs.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setCustomerName(rs.getString("customer"));
                model.setStatus(rs.getBoolean("status"));
                model.setDateOrder(rs.getDate("dateOrder"));
            }
        } catch (CommunicationsException em) {
            System.out.println(em.getMessage());
            throw new DBException("Cannot connect to the database, try again!");
        } catch (SQLException sqlException) {
            throw new DBException("There was an error with the database!");
        } catch (Exception e) {
            throw new DBException("There was a error, try again!");
        }
        return model;
    }
}

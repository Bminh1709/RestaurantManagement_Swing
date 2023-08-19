/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import CustomEntity.DishOrder;
import Entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MINH
 */
public class InvoiceModel extends DB {
    
    public ArrayList<DishOrder> getListOrderDishes(int id) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public double getTotalMoney(int id) {
        double totalPrice = 0.0; // default value
        String sql = "SELECT SUM(priceDish) FROM detail WHERE idOrder = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalPrice = rs.getDouble(1); // Get the value from the first column
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPrice;
    }
    
    public boolean checkBillStatus(int id) {
        String sql = "SELECT * FROM `orders` WHERE id = ? AND status = false";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            // if status = false => return true
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean setBillStatus(int id) {
        String sql = "UPDATE `orders` SET`status`= true WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            
            int rowsAffected = ps.executeUpdate();

            // if status is set to true => return true
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Order getInfoBill(int id) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}

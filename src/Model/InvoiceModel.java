/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import CustomEntity.DishOrder;
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Core.DB;
import Entity.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MINH
 */
public class AccessModel extends DB{

    public boolean authenticate(String username, String password) {
        String sql = "SELECT COUNT(*) FROM `admin` WHERE username = ? AND password = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0; // Return true if admin found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if any error
        }
    }
    
}

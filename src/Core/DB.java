/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import Helper.DBException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MINH
 */
public class DB {
        public Connection conn;
        protected String url = "jdbc:mysql://localhost:3306/restaurantmanagement";
        protected String user = "root";
        protected String password = "";

        public DB() throws DBException  {
            try {
                conn = DriverManager.getConnection(url, user, password);
            }
            catch (CommunicationsException em) {
                    throw new DBException("Cannot connect to the database, try again!");
                } catch (SQLException sqlException) {
                    throw new DBException("There was an error with the database!");
                } catch (Exception e) {
                    throw new DBException("There was a general error!");
                }
        }
}

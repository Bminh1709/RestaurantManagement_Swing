/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Order;
import Helper.DBException;
import Model.TableModel;
import View.TableManagement;
import java.util.ArrayList;

/**
 *
 * @author MINH
 */
public class TableController {
    private TableModel tableModel;
    private TableManagement tableView;

    public TableController(TableModel tableModel, TableManagement tableView) {
        this.tableModel = tableModel;
        this.tableView = tableView;
    }
    
    public void loadListOrders() throws DBException {
        try {
            ArrayList<Order> list = tableModel.getListOrders();
            tableView.displayListOrders(list);
        } catch (DBException dbException) {
            tableView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void addTable(String name) throws DBException {
        try {
            tableModel.addNewTable(name);
        } catch (DBException dbException) {
            tableView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void deleteEmptyOrder(int id) throws DBException {
        try {
            boolean checkDeleteEmptyOrder = tableModel.deleteEmptyOrder(id);
            tableView.resultDeleteOrder(checkDeleteEmptyOrder);
        } catch (DBException dbException) {
            tableView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void deleteOrder(int id) throws DBException {
        try {
            boolean checkDeleteOrder = tableModel.deleteOrder(id);
            tableView.resultDeleteOrder(checkDeleteOrder);
        } catch (DBException dbException) {
            tableView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void setTotalPrice(int id) throws DBException {
        try {
            tableModel.setTotalPriceForOrder(id);
        } catch (DBException dbException) {
            tableView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    
}

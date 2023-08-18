/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Order;
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
    
    public void loadListOrders() {
        ArrayList<Order> list = tableModel.getListOrders();
        tableView.displayListOrders(list);
    }
    
    public void addTable(String name) {
        tableModel.addNewTable(name);
    }
    
    public void deleteEmptyOrder(int id) {
        boolean checkDeleteEmptyOrder = tableModel.deleteEmptyOrder(id);
        tableView.resultDeleteOrder(checkDeleteEmptyOrder);
    }
    
    public void deleteOrder(int id) {
        boolean checkDeleteOrder = tableModel.deleteOrder(id);
        tableView.resultDeleteOrder(checkDeleteOrder);
    }
    
    public void setTotalPrice(int id) {
        tableModel.setTotalPriceForOrder(id);
    }
    
    
}

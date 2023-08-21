/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import CustomEntity.DishOrder;
import Entity.Order;
import Helper.DBException;
import Model.InvoiceModel;
import View.Invoice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINH
 */
public class InvoiceController {
    private InvoiceModel invoiceModel;
    private Invoice invoiceView;

    public InvoiceController(InvoiceModel invoiceModel, Invoice invoiceView) {
        this.invoiceModel = invoiceModel;
        this.invoiceView = invoiceView;
    }
    
    public void getListOrderDishes(int id) throws DBException {
        try {
            ArrayList<DishOrder> listOrderDishes = invoiceModel.getListOrderDishes(id);
            invoiceView.displayListOrderDishes(listOrderDishes);
        } catch (DBException dbException) {
            invoiceView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void getTotalMoney(int id) throws DBException {
        try {
            double money = invoiceModel.getTotalMoney(id);
            invoiceView.displayTotalMoney(money);
        } catch (DBException dbException) {
            invoiceView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void setBillStatus(int id) throws DBException {
        try {
            boolean checkBillStatus = invoiceModel.checkBillStatus(id);
            if (checkBillStatus) {
                boolean checkPayBill = invoiceModel.setBillStatus(id);
                if (checkPayBill)
                    invoiceView.resultPayBill(1);
                else
                    invoiceView.resultPayBill(-1);
            }
            else {
                invoiceView.resultPayBill(0);
            }
        } catch (DBException dbException) {
            invoiceView.Error("An error occurred: " + dbException.getMessage());
        }
    }
    
    public void getInfoBill(int id) throws DBException {
        try {
            Order currentOrder = invoiceModel.getInfoBill(id);
            invoiceView.returnInfoBill(currentOrder);
        } catch (DBException dbException) {
            invoiceView.Error("An error occurred: " + dbException.getMessage());
        }
    }
}

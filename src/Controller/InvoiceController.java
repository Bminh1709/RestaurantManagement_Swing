/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import CustomEntity.DishOrder;
import Entity.Order;
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
    
    public void getListOrderDishes(int id) {
        ArrayList<DishOrder> listOrderDishes = invoiceModel.getListOrderDishes(id);
        invoiceView.displayListOrderDishes(listOrderDishes);
    }
    
    public void getTotalMoney(int id) {
        double money = invoiceModel.getTotalMoney(id);
        invoiceView.displayTotalMoney(money);
    }
    
    public void setBillStatus(int id) {
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
    }
    
    public void getInfoBill(int id) {
        Order currentOrder = invoiceModel.getInfoBill(id);
        invoiceView.returnInfoBill(currentOrder);
    }
}

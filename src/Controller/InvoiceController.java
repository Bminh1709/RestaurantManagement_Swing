/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import CustomEntity.DishOrder;
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
}

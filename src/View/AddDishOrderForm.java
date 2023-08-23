/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AddDishOrderController;
import Entity.Category;
import Entity.Dish;
import Helper.DBException;
import Helper.FormatPrice;
import Model.TableModel;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author MINH
 */
public class AddDishOrderForm extends javax.swing.JFrame {

    // DECLARATION
    private AddDishOrderController addDishOrderController;
    private TableModel tableModel = new TableModel();
    private int tmpCategoryID;
    private List<Dish> listDishs;
    private double originalPrice;
    private int orderID = 0;
    private int dishID;
    private FormatPrice formatPrice;
    private TableManagement tableManagement;
    
    //public AddDishOrderForm() {}
        
    public AddDishOrderForm(TableManagement tableManagement, int id) throws DBException {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Center the views
        this.setLocationRelativeTo(null);
        // Set background color
        Color backgroundColor = new Color(170,244,231);
        getContentPane().setBackground(backgroundColor);
        // Set icon image and title
        ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/logo.png")); // Replace with the actual path
        setIconImage(icon.getImage());
        setTitle("BM Restaurant");
        formatPrice = new FormatPrice();
        // Set Jspinner cannot edit
        JFormattedTextField editor = ((JSpinner.DefaultEditor) spQuantity.getEditor()).getTextField();
        editor.setEditable(false);
        
        addDishOrderController = new AddDishOrderController(tableModel, this);
        addDishOrderController.loadCategories();
        
        orderID = id;
        this.tableManagement = tableManagement;
       
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbbName = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spQuantity = new javax.swing.JSpinner();
        txtPrice = new javax.swing.JTextField();
        cbbCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 134, 245));
        jLabel1.setText("ADD NEW DISH");

        btnAdd.setBackground(new java.awt.Color(66, 134, 245));
        btnAdd.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("Category");

        cbbName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNameItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        spQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spQuantity.setEditor(new javax.swing.JSpinner.NumberEditor(spQuantity, ""));
        spQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantityStateChanged(evt);
            }
        });

        txtPrice.setEditable(false);

        cbbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Category" }));
        cbbCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbCategoryItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // tmpCategoryID - categoryID
        // orderID
        int quantity = Integer.parseInt(String.valueOf(spQuantity.getValue())); // quantity
        Double modifiedPrice = originalPrice * quantity; // totalPrice
        try {
            addDishOrderController.addDishForOrder(dishID, orderID, quantity, modifiedPrice);
        } catch (DBException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbbCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCategoryItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && !cbbCategory.getSelectedItem().toString().equals("Choose Category")) {
            String[] parts = String.valueOf(cbbCategory.getSelectedItem()).split("-");
            String categoryId = parts[0].trim();
            tmpCategoryID = Integer.parseInt(categoryId);
            try {
                addDishOrderController.loadDishes(Integer.parseInt(categoryId));
            } catch (DBException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cbbCategoryItemStateChanged

    private void cbbNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNameItemStateChanged
        spQuantity.setValue(1); // Revert to first value when choose new dish
        // Set price for chose dish
        String selectedName = (String) cbbName.getSelectedItem();
           if (selectedName != null) {
               // Find the corresponding Dish object in the list
               for (Dish model : listDishs) {
                   if (model.getName().equals(selectedName) && model.getCategoryId() == tmpCategoryID) {
                       txtPrice.setText(formatPrice.formatWithCommas(model.getPrice()));
                       originalPrice = model.getPrice();
                       dishID = model.getId();
                       break;
                   }
               }
        }
    }//GEN-LAST:event_cbbNameItemStateChanged

    private void spQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantityStateChanged
        int quantity = Integer.parseInt(String.valueOf(spQuantity.getValue()));
        Double modifiedPrice = originalPrice * quantity;
        
        txtPrice.setText(formatPrice.formatWithCommas(modifiedPrice));
    }//GEN-LAST:event_spQuantityStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDishOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDishOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDishOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDishOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddDishOrderForm().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cbbCategory;
    private javax.swing.JComboBox<String> cbbName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    public void displayCategories(List<Category> categories) {
        for (Category model : categories) 
        {
            cbbCategory.addItem(model.getId() + " - " + model.getName());
        }
    }
    
    public void displayDishes(List<Dish> dishes) {
        cbbName.removeAllItems();
        listDishs = dishes;
        for (Dish model : dishes) 
        {
            cbbName.addItem(model.getName());
        }
    }
    
    public void resultAddDishForOrder(boolean result) throws DBException {
        if (result == true) {
            JOptionPane.showMessageDialog(this, "Add the dish successfully!");
            tableManagement.updateTotalPriceForOrder(orderID);
            tableManagement.reloadTable();
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Fail, try again!");
        }
    }
    
    public void resultCheckBillStatus(boolean result) throws DBException {
        if (result == true) {
            JOptionPane.showMessageDialog(this, "This order has been paid, please place a new order!");
        }
    }
    
    public void Error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Failed", JOptionPane.ERROR_MESSAGE);
    }
    
}

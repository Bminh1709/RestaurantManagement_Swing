/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AddUpdateDishController;
import Entity.Category;
import Helper.DBException;
import Helper.FormatPrice;
import Helper.NumberException;
import Model.AddUpdateModel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MINH
 */
public class AddUpdateForm extends javax.swing.JFrame {

    // DECLARATION
    private AddUpdateModel addUpdateModel = new AddUpdateModel();
    private AddUpdateDishController addUpdateController;
    private boolean updateRequest = false;
    private int dishId;
    private FormatPrice formatPrice;
    private String oldDishName;
    private Menu menu;
    
    public AddUpdateForm(Menu menu) throws DBException {
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
        
        addUpdateController = new AddUpdateDishController(addUpdateModel, this);
        addUpdateController.loadCategories();
        this.menu = menu;
    }
    
    public AddUpdateForm(Menu menu, int dishId, String cat, String name, double price) throws DBException {
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
        
        addUpdateController = new AddUpdateDishController(addUpdateModel, this);
        addUpdateController.loadCategories();
        
        // Set selected category in the combo box
        setCategoryComboBox(cat);
        txtName.setText(name);
        String formattedNumber = formatPrice.formatWithCommas(price);
        txtPrice.setText(String.valueOf(formattedNumber));
        
        // Set updateRequest = true ==> use the same form for both adđ and update
        updateRequest = true;
        this.dishId = dishId;
        
        oldDishName = name;
        this.menu = menu;
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
        txtName = new javax.swing.JTextField();
        btnUpsert = new javax.swing.JButton();
        cbbCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 134, 245));
        jLabel1.setText("FORM");

        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 14))); // NOI18N
        txtName.setMinimumSize(new java.awt.Dimension(70, 41));
        txtName.setPreferredSize(new java.awt.Dimension(70, 41));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnUpsert.setBackground(new java.awt.Color(66, 134, 245));
        btnUpsert.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnUpsert.setForeground(new java.awt.Color(255, 255, 255));
        btnUpsert.setText("Upsert");
        btnUpsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpsertActionPerformed(evt);
            }
        });

        cbbCategory.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("Category");

        txtPrice.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 14))); // NOI18N
        txtPrice.setMinimumSize(new java.awt.Dimension(70, 41));
        txtPrice.setPreferredSize(new java.awt.Dimension(70, 41));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnUpsert, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnUpsert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpsertActionPerformed
        String tmpCategory = String.valueOf(cbbCategory.getSelectedItem());
        String name = txtName.getText();
        String tmpPrice = txtPrice.getText();
        if ( !name.isBlank() || !tmpPrice.isBlank())
        {
            tmpPrice = tmpPrice.replace(",", ""); // Remove comma before parse
            
            try {
                double price = Double.parseDouble(tmpPrice);
                String[] parts = tmpCategory.split("-");
                String category = parts[0].trim();
                if (updateRequest == true)
                    addUpdateController.updateDish(dishId, Integer.parseInt(category), name, price, oldDishName);
                else
                    addUpdateController.addDish(Integer.parseInt(category), name, price);
            } catch (DBException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Please complete the form!");

    }//GEN-LAST:event_btnUpsertActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        String tmpPrice = txtPrice.getText();

        if (!Character.isDigit(c) && c != ',' && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // avoid typing more
        } else if (c == ',' && tmpPrice.contains(",")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            menu.reloadTableDishes();
        } catch (DBException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

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
            java.util.logging.Logger.getLogger(AddUpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new AddUpdateForm(Menu menu).setVisible(true);
//                } catch (DBException ex) {
//                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpsert;
    private javax.swing.JComboBox<String> cbbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    private void setCategoryComboBox(String selectedCategory) {
        for (int i = 0; i < cbbCategory.getItemCount(); i++) {
        String item = cbbCategory.getItemAt(i);
        
        String[] parts = item.split("-");
        String tmpCategory = parts[1].trim();
        
        if (tmpCategory.equals(selectedCategory)) {
            cbbCategory.setSelectedIndex(i);
            break;
            }
        }
    }
    
    public void resultAddUpdateDish(int result) {
    switch (result) {
        case 0 -> JOptionPane.showMessageDialog(this, "The Dish has already existed!");
        case 1 -> {
            JOptionPane.showMessageDialog(this, "New Dish has been upserted!");
            this.dispose(); // Close the form
        }
        case -1 -> JOptionPane.showMessageDialog(this, "Cannot add, try again!");
        default -> JOptionPane.showMessageDialog(this, "There was a sudden error, try again!");
    }
}
    
    public void displayCategories(List<Category> categories) {
        for (Category model : categories) 
        {
            cbbCategory.addItem(model.getId() + " - " + model.getName());
        }
    }
    
    public void Error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Sign In Failed", JOptionPane.ERROR_MESSAGE);
    }
}

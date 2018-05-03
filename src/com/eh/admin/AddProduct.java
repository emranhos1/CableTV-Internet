package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Emran Hossain
 */
public class AddProduct extends javax.swing.JInternalFrame {

    public AddProduct() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addProductLabel = new javax.swing.JLabel();
        productLabel = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        productBrandLabel = new javax.swing.JLabel();
        productBrandTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        productTypeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();

        setClosable(true);

        addProductLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        addProductLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductLabel.setText("Add Product");
        addProductLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        productLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productLabel.setText("Product Name :");

        productBrandLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productBrandLabel.setText("Product Brand :");

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveButton.setText("Add Product");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        productTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productTypeLabel.setText("Product Type :");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Pices", "Feet" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productBrandLabel)
                            .addComponent(productLabel)
                            .addComponent(productTypeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productBrandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(addProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(addProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productLabel)
                    .addComponent(productNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productBrandLabel)
                    .addComponent(productBrandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productTypeLabel)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(resetButton))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if (!productNameTextField.getText().equals("")) {
            if (!productBrandTextField.getText().equals("")) {
                if (typeComboBox.getSelectedIndex() > 0) {
                    try {
                        String productName = productNameTextField.getText();
                        String productBrand = productBrandTextField.getText();
                        String type = (String) typeComboBox.getSelectedItem();

                        String tableName = " product ";
                        String columnName = " product_name, product_brand, type ";
                        String values = "'" + productName + "', '" + productBrand + "', '"+type+"'";
                        boolean AddProduct = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);

                        if (!AddProduct) {
                            JOptionPane.showMessageDialog(null, "Product Not Inserted!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Product Inserted Successfully");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Select Product Type");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Product Brand");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Insert Product Name");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed

        productNameTextField.setText("");
        productBrandTextField.setText("");
        typeComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_resetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addProductLabel;
    private javax.swing.JLabel productBrandLabel;
    private javax.swing.JTextField productBrandTextField;
    private javax.swing.JLabel productLabel;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JLabel productTypeLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}

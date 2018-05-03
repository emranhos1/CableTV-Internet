package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dao.UpdateQueryDao;
import com.eh.dbconnection.conRs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Md. Emran Hossain
 */
public class Inventory extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private double stock;

    public Inventory() {
        initComponents();
        loadProductNameCombo();
        Update_table();
        loadEmployeeNameCombo();
    }

    public void loadProductNameCombo() {

        String columnName = " product_id ";
        String tableName = " product ORDER BY product_id ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithOutWhereClause(columnName, tableName);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String productId = rs.getString("product_id");
                productIdComboBox.addItem(productId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadEmployeeNameCombo() {

        String columnName = " first_name, last_name ";
        String tableName = " employee ";
        String whereCondition = " is_active = '1' ORDER BY employee_id ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                purchaseByComboBox.addItem(fName + " " + lName);
                sellByComboBox.addItem(fName + " " + lName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Update_table() {
        try {

            String columnName = " * ";
            String tableName = " product ORDER BY product_id ASC";

            conrs = SelectQueryDao.selectQueryWithOutWhereClause(columnName, tableName);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) productTable.getModel();
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String product_brand = rs.getString("product_brand");
                Double stock = rs.getDouble("stock");
                String type = rs.getString("type");

                model.addRow(new Object[]{product_id, product_name, product_brand, stock, type});
            }

        } catch (Exception e) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        purchaseselllabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        qtyLabel = new javax.swing.JLabel();
        purchaseqtyTextField = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        purchaseamountTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        purchaseByLabel = new javax.swing.JLabel();
        purchaseByComboBox = new javax.swing.JComboBox<>();
        purchaseDetailsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pDetailsTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        sellqtyLabel = new javax.swing.JLabel();
        sellqtyTextField = new javax.swing.JTextField();
        sellsaveButton = new javax.swing.JButton();
        sellByComboBox = new javax.swing.JComboBox<>();
        sellByLabel = new javax.swing.JLabel();
        sellDetailsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sDetailsTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        productIdLabel = new javax.swing.JLabel();
        productIdComboBox = new javax.swing.JComboBox<>();
        productNameLabel = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        storeLabel = new javax.swing.JLabel();
        instoreTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        productBrandLabel = new javax.swing.JLabel();
        productBrandTextField = new javax.swing.JTextField();

        setClosable(true);

        purchaseselllabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        purchaseselllabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purchaseselllabel.setText("Purchase / Sell");
        purchaseselllabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel1.setRequestFocusEnabled(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        qtyLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qtyLabel.setText("QTY :");

        purchaseqtyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseqtyTextFieldActionPerformed(evt);
            }
        });

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountLabel.setText("Amount :");

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveButton.setText("Buy Product");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        purchaseByLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        purchaseByLabel.setText("Purchase By :");

        purchaseByComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        purchaseByComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseByComboBoxActionPerformed(evt);
            }
        });

        purchaseDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        purchaseDetailsLabel.setText("Details :");

        pDetailsTextArea.setColumns(20);
        pDetailsTextArea.setRows(5);
        jScrollPane2.setViewportView(pDetailsTextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(qtyLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(amountLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(purchaseamountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purchaseqtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(purchaseDetailsLabel)
                            .addComponent(purchaseByLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(purchaseByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtyLabel)
                    .addComponent(purchaseqtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseamountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseByLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseDetailsLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel2.setRequestFocusEnabled(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sell", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        sellqtyLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sellqtyLabel.setText("QTY :");

        sellsaveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sellsaveButton.setText("Sell Product");
        sellsaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellsaveButtonActionPerformed(evt);
            }
        });

        sellByComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));

        sellByLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sellByLabel.setText("Sell By :");

        sellDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sellDetailsLabel.setText("Details :");

        sDetailsTextArea.setColumns(20);
        sDetailsTextArea.setRows(5);
        jScrollPane3.setViewportView(sDetailsTextArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sellqtyLabel)
                            .addComponent(sellByLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sellByComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                            .addComponent(sellqtyTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(sellDetailsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(sellsaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellqtyLabel)
                    .addComponent(sellqtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellByLabel)
                    .addComponent(sellByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sellDetailsLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(sellsaveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Brand", "Stock", "Type"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        productIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productIdLabel.setText("Product Id :");

        productIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        productIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdComboBoxActionPerformed(evt);
            }
        });

        productNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productNameLabel.setText("Name :");

        productNameTextField.setEditable(false);

        storeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storeLabel.setText("In Store :");

        instoreTextField.setEditable(false);

        typeTextField.setEditable(false);

        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        typeLabel.setText("Type :");

        productBrandLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productBrandLabel.setText("Brand :");

        productBrandTextField.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(typeLabel)
                    .addComponent(productIdLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productIdComboBox, 0, 135, Short.MAX_VALUE)
                    .addComponent(typeTextField))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productNameLabel)
                    .addComponent(storeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(instoreTextField))
                .addGap(18, 18, 18)
                .addComponent(productBrandLabel)
                .addGap(18, 18, 18)
                .addComponent(productBrandTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productIdLabel)
                    .addComponent(productNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productNameLabel)
                    .addComponent(productBrandLabel)
                    .addComponent(productBrandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storeLabel)
                    .addComponent(instoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(purchaseselllabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(purchaseselllabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseqtyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseqtyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseqtyTextFieldActionPerformed

    private void productIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdComboBoxActionPerformed

        String comboBox = productIdComboBox.getSelectedItem().toString();

        String columnName = " * ";
        String tableName = " product ";
        String whereCondition = " product_id = '" + comboBox + "'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String productName = rs.getString("product_name");
                String productBrand = rs.getString("product_brand");
                productNameTextField.setText(productName);
                productBrandTextField.setText(productBrand);
                Double stock = rs.getDouble("stock");
                instoreTextField.setText(stock.toString());
                typeTextField.setText(rs.getString("type"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_productIdComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if (productIdComboBox.getSelectedIndex() > 0) {
            if (!purchaseqtyTextField.getText().equals("")) {
                if (!purchaseamountTextField.getText().equals("")) {
                    if (purchaseByComboBox.getSelectedIndex() > 0) {
                        if (!pDetailsTextArea.getText().equals("")) {

                            try {
                                String productId = (String) productIdComboBox.getSelectedItem();
                                String qty = purchaseqtyTextField.getText();
                                String details = pDetailsTextArea.getText();
                                String employeeName = (String) purchaseByComboBox.getSelectedItem();
                                Double amount = Double.parseDouble(purchaseamountTextField.getText());

                                String tableName = " purchase ";
                                String columnName = " product_id, qty, details, employee_name, purchase_date, amount ";
                                String values = "'" + productId + "', '" + qty + "', '" + details + "', '" + employeeName + "', now(), '" + amount + "'";
                                boolean AddPurchase = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                                if (AddPurchase) {
                                    String column = " stock ";
                                    String table = " product ";
                                    String whereCondition = " product_id = '" + productId + "' ";

                                    conrs = SelectQueryDao.selectQueryWithWhereClause(column, table, whereCondition);

                                    con = conrs.getCon();
                                    pstm = conrs.getPstm();
                                    rs = conrs.getRs();

                                    while (rs.next()) {
                                        stock = rs.getDouble("stock");
                                    }

                                    double newStock = stock + Double.parseDouble(qty);

                                    String tableNameNew = " product ";
                                    String columnNameANDcolumnValue = " stock = '" + newStock + "' ";
                                    String whereConditionNew = " product_id = '" + productId + "'";

                                    boolean updateStock = UpdateQueryDao.updateQueryWithWhereClause(tableNameNew, columnNameANDcolumnValue, whereConditionNew);

                                    if (updateStock) {
                                        JOptionPane.showMessageDialog(null, "Stock Update Successfully");
                                        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
                                        model.setRowCount(0);
                                        Update_table();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Product Not Inserted!");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    con.close();
                                    pstm.close();
                                    rs.close();
                                } catch (SQLException ex) {
                                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Insert Details Field");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Select Purchase By Field");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Amount Field");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert QTY Field");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Product Id");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void sellsaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellsaveButtonActionPerformed

        if (productIdComboBox.getSelectedIndex() > 0) {
            if (!sellqtyTextField.getText().equals("")) {
                if (sellByComboBox.getSelectedIndex() > 0) {
                    if (!sDetailsTextArea.getText().equals("")) {

                        try {
                            String productId = (String) productIdComboBox.getSelectedItem();
                            String qty = sellqtyTextField.getText();
                            String details = sDetailsTextArea.getText();
                            String employeeName = (String) sellByComboBox.getSelectedItem();

                            String tableName = " sell ";
                            String columnName = " product_id, qty, datails, employee_name, sell_date ";
                            String values = "'" + productId + "', '" + qty + "', '" + details + "', '" + employeeName + "', now()";
                            boolean AddSell = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                            if (AddSell) {
                                String column = " stock ";
                                String table = " product ";
                                String whereCondition = " product_id = '" + productId + "' ";

                                conrs = SelectQueryDao.selectQueryWithWhereClause(column, table, whereCondition);

                                con = conrs.getCon();
                                pstm = conrs.getPstm();
                                rs = conrs.getRs();

                                while (rs.next()) {
                                    stock = rs.getDouble("stock");
                                }

                                double newStock = stock - Double.parseDouble(qty);

                                String tableNameNew = " product ";
                                String columnNameANDcolumnValue = " stock = '" + newStock + "' ";
                                String whereConditionNew = " product_id = '" + productId + "'";

                                boolean updateStock = UpdateQueryDao.updateQueryWithWhereClause(tableNameNew, columnNameANDcolumnValue, whereConditionNew);

                                if (updateStock) {
                                    JOptionPane.showMessageDialog(null, "Stock Update Successfully");
                                    DefaultTableModel model = (DefaultTableModel) productTable.getModel();
                                    model.setRowCount(0);
                                    Update_table();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Product Not Inserted!");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert Details Field");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Select Purchase By Field");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert QTY Field");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Product Id");
        }

    }//GEN-LAST:event_sellsaveButtonActionPerformed

    private void purchaseByComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseByComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseByComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField instoreTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea pDetailsTextArea;
    private javax.swing.JLabel productBrandLabel;
    private javax.swing.JTextField productBrandTextField;
    private javax.swing.JComboBox<String> productIdComboBox;
    private javax.swing.JLabel productIdLabel;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTable productTable;
    private javax.swing.JComboBox<String> purchaseByComboBox;
    private javax.swing.JLabel purchaseByLabel;
    private javax.swing.JLabel purchaseDetailsLabel;
    private javax.swing.JTextField purchaseamountTextField;
    private javax.swing.JTextField purchaseqtyTextField;
    private javax.swing.JLabel purchaseselllabel;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JTextArea sDetailsTextArea;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> sellByComboBox;
    private javax.swing.JLabel sellByLabel;
    private javax.swing.JLabel sellDetailsLabel;
    private javax.swing.JLabel sellqtyLabel;
    private javax.swing.JTextField sellqtyTextField;
    private javax.swing.JButton sellsaveButton;
    private javax.swing.JLabel storeLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
}

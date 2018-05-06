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
public class AllCloseConnection extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public AllCloseConnection() {
        initComponents();
        loadUserNumberCombo();
        loadUserIdCombo();
        UpdateInternetTable();
        UpdateCableTable();
    }

    public void clearAll() {
        userCardComboBox.setSelectedIndex(0);
        cableCustomerNameTextField.setText("");
        cablePhoneNoTextField.setText("");
        cableReconnectionFeeTextField.setText("");
    }

    public void loadUserNumberCombo() {

        String columnName = " concat(user_card_number,'~[',first_name,' ', last_name,']') as user_card_number ";
        String tableName = " customer_cable ";
        String whereCondition = " is_active = '0' ORDER BY user_card_number ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String userNumber = rs.getString("user_card_number");
                userCardComboBox.addItem(userNumber);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadUserIdCombo() {

        String columnName = " concat(user_id,'~[',first_name,' ', last_name,']') as user_id ";
        String tableName = " customer_internet ";
        String whereCondition = " is_active = '0' ORDER BY user_id ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String userid = rs.getString("user_id");
                userIdComboBox.addItem(userid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void UpdateCableTable() {
        try {

            String columnName = " * ";
            String tableName = " customer_cable ";
            String whereCondition = " is_active = '0' ORDER BY user_card_number ASC ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_card_number = rs.getString("user_card_number");
                String phone_no = rs.getString("phone_no");

                model.addRow(new Object[]{first_name + " " + last_name, user_card_number, phone_no});
            }

        } catch (Exception e) {
            Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void UpdateInternetTable() {
        try {

            String columnName = " * ";
            String tableName = " customer_internet ";
            String whereCondition = " is_active = '0' ORDER BY user_id ASC ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) internetTable.getModel();
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_id = rs.getString("user_id");
                String phone_no = rs.getString("phone_no");

                model.addRow(new Object[]{first_name + " " + last_name, user_id, phone_no,});
            }

        } catch (Exception e) {
            Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cableTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        internetTable = new javax.swing.JTable();
        userCardComboBox = new javax.swing.JComboBox<>();
        cableUserCardNoLabel = new javax.swing.JLabel();
        cableCusNameLabel = new javax.swing.JLabel();
        cableCustomerNameTextField = new javax.swing.JTextField();
        cablePhoneNoLabel = new javax.swing.JLabel();
        cablePhoneNoTextField = new javax.swing.JTextField();
        cableReconnectionButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        userIdComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        internetCustomerNameTextField = new javax.swing.JTextField();
        internetPhoneNoTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        internetReconnectionButton = new javax.swing.JButton();
        reconnectionFeeLabel = new javax.swing.JLabel();
        cableReconnectionFeeTextField = new javax.swing.JTextField();
        intReconFeeLabel = new javax.swing.JLabel();
        intreconnectionFeeTextField = new javax.swing.JTextField();

        setClosable(true);
        setTitle("All Close Connection");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Close Connection");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Close Cable Connection");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("All Close Internet Connection");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Customer Card No", "Phone No"
            }
        ));
        jScrollPane1.setViewportView(cableTable);

        internetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Customer Card No", "Phone No"
            }
        ));
        jScrollPane2.setViewportView(internetTable);

        userCardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        userCardComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCardComboBoxActionPerformed(evt);
            }
        });

        cableUserCardNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cableUserCardNoLabel.setText("User Card No :");

        cableCusNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cableCusNameLabel.setText("Customer Name :");

        cableCustomerNameTextField.setEditable(false);

        cablePhoneNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cablePhoneNoLabel.setText("Customer Phone :");

        cablePhoneNoTextField.setEditable(false);

        cableReconnectionButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cableReconnectionButton.setText("Reconnect");
        cableReconnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cableReconnectionButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("User Id :");

        userIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        userIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdComboBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Customer Name :");

        internetCustomerNameTextField.setEditable(false);
        internetCustomerNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internetCustomerNameTextFieldActionPerformed(evt);
            }
        });

        internetPhoneNoTextField.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Customer Phone :");

        internetReconnectionButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        internetReconnectionButton.setText("Reconnect");
        internetReconnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internetReconnectionButtonActionPerformed(evt);
            }
        });

        reconnectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reconnectionFeeLabel.setText("Re-Connection Fee :");

        intReconFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        intReconFeeLabel.setText("Re-Connection Fee :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(cableReconnectionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(internetReconnectionButton)
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reconnectionFeeLabel)
                            .addComponent(cableCusNameLabel)
                            .addComponent(cableUserCardNoLabel)
                            .addComponent(cablePhoneNoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cableReconnectionFeeTextField)
                            .addComponent(userCardComboBox, 0, 150, Short.MAX_VALUE)
                            .addComponent(cableCustomerNameTextField)
                            .addComponent(cablePhoneNoTextField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(intReconFeeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userIdComboBox, 0, 150, Short.MAX_VALUE)
                            .addComponent(internetCustomerNameTextField)
                            .addComponent(internetPhoneNoTextField)
                            .addComponent(intreconnectionFeeTextField)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cableUserCardNoLabel)
                    .addComponent(userCardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(userIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cableCusNameLabel)
                    .addComponent(cableCustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(internetCustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cablePhoneNoLabel)
                    .addComponent(cablePhoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(internetPhoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reconnectionFeeLabel)
                    .addComponent(cableReconnectionFeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intReconFeeLabel)
                    .addComponent(intreconnectionFeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cableReconnectionButton)
                    .addComponent(internetReconnectionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void internetCustomerNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internetCustomerNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_internetCustomerNameTextFieldActionPerformed

    private void userCardComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCardComboBoxActionPerformed

        String[] comboBox1 = userCardComboBox.getSelectedItem().toString().split("~");
	String comboBox  = comboBox1[0];

        String columnName = " * ";
        String tableName = " customer_cable ";
        String whereCondition = " user_card_number = '" + comboBox + "'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                cableCustomerNameTextField.setText(first_name + " " + last_name);
                String phone_no = rs.getString("phone_no");
                cablePhoneNoTextField.setText(phone_no);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_userCardComboBoxActionPerformed

    private void userIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdComboBoxActionPerformed

        String[] comboBox1 = userIdComboBox.getSelectedItem().toString().split("~");
	String comboBox  = comboBox1[0];

        String columnName = " * ";
        String tableName = " customer_internet ";
        String whereCondition = " user_id = '" + comboBox + "'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                internetCustomerNameTextField.setText(first_name + " " + last_name);
                String phone_no = rs.getString("phone_no");
                internetPhoneNoTextField.setText(phone_no);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_userIdComboBoxActionPerformed

    private void cableReconnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cableReconnectionButtonActionPerformed

        if (userCardComboBox.getSelectedIndex() > 0) {
            String reconnectionFee = cableReconnectionFeeTextField.getText();
            if (!reconnectionFee.equals("")) {
                try {
                    String[] comboBox1 = userCardComboBox.getSelectedItem().toString().split("~");
                    String comboBox = comboBox1[0];

                    String tableName = " customer_cable ";
                    String columnNameANDcolumnValue = " is_active = '1' ";
                    String whereCondition = " user_card_number = '" + comboBox + "'";

                    boolean reconnectCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

                    String tableN = " customer_cable_reconnection ";
                    String columnName = " reconnection_fee, user_card_no, reconnection_date ";
                    String values = "'" + reconnectionFee + "', '" + comboBox + "', now() ";
                    boolean addReConnection = InsertQueryDao.insertQueryWithOutWhereClause(tableN, columnName, values);

                    if (reconnectCableConnection) {
                        if (addReConnection) {
                            JOptionPane.showMessageDialog(null, "Connection ReConnected");
                            clearAll();
                            DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
                            model.setRowCount(0);
                            UpdateCableTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Re-Connected");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Re-Connected");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Re-Connection Fee");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select one Card Number to Re-Connect");
        }
    }//GEN-LAST:event_cableReconnectionButtonActionPerformed

    private void internetReconnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internetReconnectionButtonActionPerformed

        if (userIdComboBox.getSelectedIndex() > 0) {
            String reconnectionFee = intreconnectionFeeTextField.getText();
            if (!reconnectionFee.equals("")) {
                try {
                    String[] comboBox1 = userIdComboBox.getSelectedItem().toString().split("~");
                    String comboBox = comboBox1[0];

                    String tableName = " customer_internet ";

                    String columnNameANDcolumnValue = " is_active = '1' ";
                    String whereCondition = " user_id = '" + comboBox + "'";

                    boolean reconnectInternetConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

                    String tableN = " customer_internet_reconnection ";
                    String columnName = " reconnection_fee, user_id, reconnection_date ";
                    String values = "'" + reconnectionFee + "', '" + comboBox + "', now() ";
                    boolean addReConnection = InsertQueryDao.insertQueryWithOutWhereClause(tableN, columnName, values);

                    if (reconnectInternetConnection) {
                        if (addReConnection) {
                            JOptionPane.showMessageDialog(null, "Connection Reconnected");
                            clearAll();
                            DefaultTableModel model = (DefaultTableModel) internetTable.getModel();
                            model.setRowCount(0);
                            UpdateInternetTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Re-Connected");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Re-Connected");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AllCloseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Re-Connection Fee");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Id for Re-Connect");
        }
    }//GEN-LAST:event_internetReconnectionButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cableCusNameLabel;
    private javax.swing.JTextField cableCustomerNameTextField;
    private javax.swing.JLabel cablePhoneNoLabel;
    private javax.swing.JTextField cablePhoneNoTextField;
    private javax.swing.JButton cableReconnectionButton;
    private javax.swing.JTextField cableReconnectionFeeTextField;
    private javax.swing.JTable cableTable;
    private javax.swing.JLabel cableUserCardNoLabel;
    private javax.swing.JLabel intReconFeeLabel;
    private javax.swing.JTextField internetCustomerNameTextField;
    private javax.swing.JTextField internetPhoneNoTextField;
    private javax.swing.JButton internetReconnectionButton;
    private javax.swing.JTable internetTable;
    private javax.swing.JTextField intreconnectionFeeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel reconnectionFeeLabel;
    private javax.swing.JComboBox<String> userCardComboBox;
    private javax.swing.JComboBox<String> userIdComboBox;
    // End of variables declaration//GEN-END:variables
}

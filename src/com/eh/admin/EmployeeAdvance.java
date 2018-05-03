package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Md. Emran Hossain
 */
public class EmployeeAdvance extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public EmployeeAdvance() {
        initComponents();
        loadPhoneNoCombo();
    }

    public void loadPhoneNoCombo() {

        String columnName = " * ";
        String tableName = " employee ";
        String whereCondition = " is_active = '1' ORDER BY phone_no ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String phoneNo = rs.getString("phone_no");
                employeePhoneComboBox.addItem(phoneNo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        advanceLabel = new javax.swing.JLabel();
        employeePhoneLabel = new javax.swing.JLabel();
        employeePhoneComboBox = new javax.swing.JComboBox<>();
        employeenameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        advanceMoneyLabel = new javax.swing.JLabel();
        advanceTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        parpusLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purposeTextArea = new javax.swing.JTextArea();
        employeeidLabel = new javax.swing.JLabel();
        employeeIdTextField = new javax.swing.JTextField();

        setClosable(true);

        advanceLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        advanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        advanceLabel.setText("Advance");
        advanceLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        employeePhoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeePhoneLabel.setText("Employee Phone No :");

        employeePhoneComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        employeePhoneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeePhoneComboBoxActionPerformed(evt);
            }
        });

        employeenameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeenameLabel.setText("Employee Name :");

        nameTextField.setEditable(false);

        advanceMoneyLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        advanceMoneyLabel.setText("Advance :");

        submitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        parpusLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        parpusLabel.setText("Purpose :");

        purposeTextArea.setColumns(20);
        purposeTextArea.setRows(5);
        jScrollPane1.setViewportView(purposeTextArea);

        employeeidLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeeidLabel.setText("Employee ID :");

        employeeIdTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(advanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(employeenameLabel)
                            .addComponent(employeePhoneLabel)
                            .addComponent(advanceMoneyLabel)
                            .addComponent(parpusLabel)
                            .addComponent(employeeidLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeeIdTextField)
                            .addComponent(employeePhoneComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField)
                            .addComponent(advanceTextField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(submitButton)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(advanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeePhoneLabel)
                    .addComponent(employeePhoneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeidLabel)
                    .addComponent(employeeIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeenameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advanceMoneyLabel)
                    .addComponent(advanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parpusLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeePhoneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeePhoneComboBoxActionPerformed

        String comboBox = employeePhoneComboBox.getSelectedItem().toString();

        String columnName = " * ";
        String tableName = " employee ";
        String whereCondition = " phone_no = '" + comboBox + "'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                employeeIdTextField.setText(employee_id);
                nameTextField.setText(first_name + " " + last_name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_employeePhoneComboBoxActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        String employeeId = employeeIdTextField.getText();
        String advance = advanceTextField.getText();
        String purpose = purposeTextArea.getText();

        if (employeePhoneComboBox.getSelectedIndex() > 0) {
            if (!advance.equals("")) {
                if (!purpose.equals("")) {
                    try {
                        String tableName = " employee_advance ";
                        String columnName = " advance, employee_id, advance_date, purpose ";
                        String values = "'" + advance + "', '" + employeeId + "', now(), '" + purpose + "'";
                        boolean addAdvance = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                        if (addAdvance) {
                            JOptionPane.showMessageDialog(null, "Advance Insert Successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Advance not Insert");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeAdvance.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Purpose");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Advance");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Employee Phone No");
        }
        advanceTextField.setText("");
        purposeTextArea.setText("");
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advanceLabel;
    private javax.swing.JLabel advanceMoneyLabel;
    private javax.swing.JTextField advanceTextField;
    private javax.swing.JTextField employeeIdTextField;
    private javax.swing.JComboBox<String> employeePhoneComboBox;
    private javax.swing.JLabel employeePhoneLabel;
    private javax.swing.JLabel employeeidLabel;
    private javax.swing.JLabel employeenameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel parpusLabel;
    private javax.swing.JTextArea purposeTextArea;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox<String> useridComboBox;
    // End of variables declaration//GEN-END:variables
}

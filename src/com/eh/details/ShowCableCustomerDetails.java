package com.eh.details;

import com.eh.admin.AllCableConnection;
import com.eh.admin.AllEmployee;
import com.eh.dao.UpdateQueryDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Md. Emran Hossain
 */
public class ShowCableCustomerDetails extends javax.swing.JFrame {

    private ImageIcon icon = new ImageIcon("image/SKF1.jpg");
    public ShowCableCustomerDetails() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("SKF");
        setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cableDetailsLabel = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        arealLabel = new javax.swing.JLabel();
        areaText = new javax.swing.JTextField();
        connectionFeeLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        connectionFeeText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        customerIdlabel = new javax.swing.JLabel();
        conDateLabel = new javax.swing.JLabel();
        connectionDateText = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        customerIdText = new javax.swing.JTextField();
        usercardnumberLabel = new javax.swing.JLabel();
        cardnoText = new javax.swing.JTextField();
        monthlyPayLabel = new javax.swing.JLabel();
        monthlypayText = new javax.swing.JTextField();
        commentLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentsArea = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        closeConnectionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cableDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cableDetailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cableDetailsLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email :");

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });

        arealLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        arealLabel.setText("Area :");

        connectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionFeeLabel.setText("Connection Fee :");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressLabel.setText("Address :");

        connectionFeeText.setEditable(false);
        connectionFeeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionFeeTextActionPerformed(evt);
            }
        });

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        customerIdlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerIdlabel.setText("Customer Id:");

        conDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        conDateLabel.setText("Connection Date :");

        connectionDateText.setEditable(false);
        connectionDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionDateTextActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        firstNameLabel.setText("First Name :");

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lastNameLabel.setText("Last Name :");

        phoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneLabel.setText("Phone No :");

        customerIdText.setEditable(false);

        usercardnumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usercardnumberLabel.setText("User Card Number :");

        cardnoText.setEditable(false);

        monthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyPayLabel.setText("Monthly Pay :");

        monthlypayText.setEditable(false);
        monthlypayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlypayTextActionPerformed(evt);
            }
        });

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentLabel.setText("Comments :");

        commentsArea.setColumns(20);
        commentsArea.setRows(5);
        jScrollPane2.setViewportView(commentsArea);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        closeConnectionButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closeConnectionButton.setText("Close Connection");
        closeConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(customerIdlabel)
                                .addComponent(firstNameLabel)
                                .addComponent(lastNameLabel)
                                .addComponent(usercardnumberLabel)
                                .addComponent(phoneLabel)
                                .addComponent(emailLabel)
                                .addComponent(arealLabel)
                                .addComponent(connectionFeeLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lastNameText)
                                    .addComponent(firstNameText)
                                    .addComponent(customerIdText)
                                    .addComponent(cardnoText)
                                    .addComponent(phoneText)
                                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(monthlyPayLabel)
                                .addComponent(conDateLabel)
                                .addComponent(commentLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(connectionDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthlypayText, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(458, 458, 458)
                            .addComponent(addressLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeConnectionButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(cableDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cableDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(customerIdlabel)
                            .addComponent(customerIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usercardnumberLabel)
                            .addComponent(cardnoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(arealLabel)
                            .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionFeeLabel))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateButton)
                            .addComponent(closeConnectionButton))
                        .addGap(139, 139, 139))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conDateLabel)
                            .addComponent(connectionDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthlyPayLabel)
                            .addComponent(monthlypayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commentLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectionFeeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionFeeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionFeeTextActionPerformed

    private void connectionDateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionDateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionDateTextActionPerformed

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed

    private void monthlypayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlypayTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthlypayTextActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        try {
            String customerId = customerIdText.getText();
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String cardno = cardnoText.getText();
            String phoneNo = phoneText.getText();
            String email = emailText.getText();
            String area = areaText.getText();
            String address = addressArea.getText();
            String comment = commentsArea.getText();

            String tableName = " customer_cable ";

            String columnNameANDcolumnValue = " first_name = '" + firstName + "', last_name='" + lastName + "', user_card_number = '" + cardno + "', phone_no = '" + phoneNo + "', email= '" + email + "', area= '" + area + "', address= '" + address + "', comments='" + comment + "' ";
            String whereCondition = " user_card_number = '" + cardno + "'";

            boolean updateCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

            if (updateCableConnection) {
                JOptionPane.showMessageDialog(null, "Update Successfully");
//                Update_table();
            } else {
                JOptionPane.showMessageDialog(null, "Not Update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void closeConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectionButtonActionPerformed

        try {
            String cardno = cardnoText.getText();

//            if (userCardComboBox.getSelectedIndex() == -1) {
//                
//                JOptionPane.showMessageDialog(null, "Select one Card Number to Close Connection");
//            } else{
            String tableName = " customer_cable ";

            String columnNameANDcolumnValue = " is_active = '0' ";
            String whereCondition = " user_card_number = '" + cardno + "'";

            boolean closeCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

            if (closeCableConnection) {
                JOptionPane.showMessageDialog(null, "Connection Closed");
            } else {
                JOptionPane.showMessageDialog(null, "Not Closed");
            }
//            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeConnectionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ShowCableCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowCableCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowCableCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowCableCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowCableCustomerDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    public javax.swing.JTextField areaText;
    private javax.swing.JLabel arealLabel;
    public javax.swing.JLabel cableDetailsLabel;
    public javax.swing.JTextField cardnoText;
    private javax.swing.JButton closeConnectionButton;
    private javax.swing.JLabel commentLabel;
    public javax.swing.JTextArea commentsArea;
    private javax.swing.JLabel conDateLabel;
    public javax.swing.JTextField connectionDateText;
    private javax.swing.JLabel connectionFeeLabel;
    public javax.swing.JTextField connectionFeeText;
    public javax.swing.JTextField customerIdText;
    private javax.swing.JLabel customerIdlabel;
    private javax.swing.JLabel emailLabel;
    public javax.swing.JTextField emailText;
    private javax.swing.JLabel firstNameLabel;
    public javax.swing.JTextField firstNameText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastNameLabel;
    public javax.swing.JTextField lastNameText;
    private javax.swing.JLabel monthlyPayLabel;
    public javax.swing.JTextField monthlypayText;
    private javax.swing.JLabel phoneLabel;
    public javax.swing.JTextField phoneText;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel usercardnumberLabel;
    // End of variables declaration//GEN-END:variables
}

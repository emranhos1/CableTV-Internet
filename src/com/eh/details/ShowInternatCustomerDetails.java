package com.eh.details;

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
public class ShowInternatCustomerDetails extends javax.swing.JFrame {

    private ImageIcon icon = new ImageIcon("image/SKF1.jpg");

    public ShowInternatCustomerDetails() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("SKF");
        setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerIdlabel = new javax.swing.JLabel();
        conDateLabel = new javax.swing.JLabel();
        connectionDateText = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        customerIdText = new javax.swing.JTextField();
        userIdLabel = new javax.swing.JLabel();
        userIdText = new javax.swing.JTextField();
        internetDetailsLabel = new javax.swing.JLabel();
        monthlyPayLabel = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        monthlypayText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentsArea = new javax.swing.JTextArea();
        arealLabel = new javax.swing.JLabel();
        areaText = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        connectionFeeLabel = new javax.swing.JLabel();
        closeConnectionButton = new javax.swing.JButton();
        addressLabel = new javax.swing.JLabel();
        connectionFeeText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        macLabel = new javax.swing.JLabel();
        macAddressText = new javax.swing.JTextField();
        ipLabel = new javax.swing.JLabel();
        IPAddressText = new javax.swing.JTextField();
        genarateBillButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerIdlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerIdlabel.setText("Internet Customer Id:");

        conDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        conDateLabel.setText("Connection Date :");

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

        userIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userIdLabel.setText("User Id :");

        userIdText.setEditable(false);

        internetDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        internetDetailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        internetDetailsLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        monthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyPayLabel.setText("Monthly Pay :");

        phoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneTextKeyTyped(evt);
            }
        });

        monthlypayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlypayTextActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email :");

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentLabel.setText("Comments :");

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });

        commentsArea.setColumns(20);
        commentsArea.setRows(5);
        jScrollPane2.setViewportView(commentsArea);

        arealLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        arealLabel.setText("Area :");

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.setToolTipText("");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        connectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionFeeLabel.setText("Connection Fee :");

        closeConnectionButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closeConnectionButton.setText("Close Connection");
        closeConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectionButtonActionPerformed(evt);
            }
        });

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressLabel.setText("Address :");

        connectionFeeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionFeeTextActionPerformed(evt);
            }
        });

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        macLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        macLabel.setText("MAC Address :");

        macAddressText.setEditable(false);

        ipLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipLabel.setText("IP Address :");

        IPAddressText.setEditable(false);

        genarateBillButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        genarateBillButton.setText("Genarate Bill");
        genarateBillButton.setToolTipText("");
        genarateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genarateBillButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(customerIdlabel)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(userIdLabel)
                            .addComponent(macLabel)
                            .addComponent(ipLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lastNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(firstNameText)
                                .addComponent(customerIdText)
                                .addComponent(userIdText)
                                .addComponent(macAddressText))
                            .addComponent(IPAddressText)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phoneLabel)
                            .addComponent(emailLabel)
                            .addComponent(arealLabel)
                            .addComponent(connectionFeeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(phoneText)
                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(monthlyPayLabel)
                    .addComponent(conDateLabel)
                    .addComponent(commentLabel)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectionDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthlypayText, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(internetDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(genarateBillButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeConnectionButton)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(internetDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conDateLabel)
                            .addComponent(connectionDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthlyPayLabel)
                            .addComponent(monthlypayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
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
                            .addComponent(userIdLabel)
                            .addComponent(userIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(macLabel)
                            .addComponent(macAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipLabel)
                            .addComponent(IPAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionFeeLabel)))
                    .addComponent(commentLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(closeConnectionButton)
                    .addComponent(genarateBillButton))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectionDateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionDateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionDateTextActionPerformed

    private void monthlypayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlypayTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthlypayTextActionPerformed

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        try {
            String customerId = customerIdText.getText();
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String userId = userIdText.getText();
            String phoneNo = phoneText.getText();
            String email = emailText.getText();
            String area = areaText.getText();
            String connectionFee = connectionFeeText.getText();
            String connectionDate = connectionDateText.getText();
            String monthlypay = monthlypayText.getText();
            String address = addressArea.getText();
            String comment = commentsArea.getText();

            String tableName = " customer_internet ";

            String columnNameANDcolumnValue = " first_name = '" + firstName + "', last_name='" + lastName + "', phone_no = '" + phoneNo + "', email= '" + email + "', area= '" + area + "', address= '" + address + "', comments='" + comment + "', connection_date = '"+connectionDate+"', connection_fee = '"+connectionFee+"', monthly_pay = '"+monthlypay+"' ";
            String whereCondition = " user_id = '" + userId + "'";

            boolean updateCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

            if (updateCableConnection) {
                JOptionPane.showMessageDialog(null, "Update Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Not Update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowInternatCustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void closeConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectionButtonActionPerformed

        try {
            String userId = userIdText.getText();
            String tableName = " customer_internet ";

            String columnNameANDcolumnValue = " is_active = '0' ";
            String whereCondition = " user_id = '" + userId + "'";

            boolean closeCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

            if (closeCableConnection) {
                JOptionPane.showMessageDialog(null, "Connection Closed");
            } else {
                JOptionPane.showMessageDialog(null, "Not Closed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowInternatCustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeConnectionButtonActionPerformed

    private void connectionFeeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionFeeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionFeeTextActionPerformed

    private void phoneTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_phoneTextKeyTyped

    private void genarateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genarateBillButtonActionPerformed
        
        BillGenerateInternet bgi = new BillGenerateInternet();
        bgi.setVisible(true);
    }//GEN-LAST:event_genarateBillButtonActionPerformed
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

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
            java.util.logging.Logger.getLogger(ShowInternatCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowInternatCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowInternatCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowInternatCustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowInternatCustomerDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField IPAddressText;
    public javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    public javax.swing.JTextField areaText;
    private javax.swing.JLabel arealLabel;
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
    private javax.swing.JButton genarateBillButton;
    public javax.swing.JLabel internetDetailsLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastNameLabel;
    public javax.swing.JTextField lastNameText;
    public javax.swing.JTextField macAddressText;
    private javax.swing.JLabel macLabel;
    private javax.swing.JLabel monthlyPayLabel;
    public javax.swing.JTextField monthlypayText;
    private javax.swing.JLabel phoneLabel;
    public javax.swing.JTextField phoneText;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel userIdLabel;
    public javax.swing.JTextField userIdText;
    // End of variables declaration//GEN-END:variables
}

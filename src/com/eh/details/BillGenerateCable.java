package com.eh.details;

import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Md. Emran Hossain
 */
public class BillGenerateCable extends javax.swing.JFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String userNumber;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String area;
    private String address;
    private String connectionDate;
    private String monthlyPay;

    private ImageIcon icon = new ImageIcon("image/SKF1.jpg");
    public BillGenerateCable() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("SKF");
        setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generateBillLabel = new javax.swing.JLabel();
        PhoneNolabel = new javax.swing.JLabel();
        monthlabel = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTextArea = new javax.swing.JTextArea();
        printButton = new javax.swing.JButton();
        phoneNoTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cable Bill");

        generateBillLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        generateBillLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generateBillLabel.setText("Generate Bill For Cable");
        generateBillLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        PhoneNolabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PhoneNolabel.setText("Phone No :");

        monthlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        monthlabel.setText("Month :");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        billTextArea.setColumns(20);
        billTextArea.setRows(5);
        jScrollPane1.setViewportView(billTextArea);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(PhoneNolabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(phoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(printButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(generateBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(generateBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneNolabel)
                    .addComponent(monthlabel)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed

        if (!phoneNoTextField.getText().equals("")) {

            String phone_no = phoneNoTextField.getText();
            String month = monthComboBox.getSelectedItem().toString();

            String columnName = " * ";
            String tableName = " customer_cable ";
            String whereCondition = " phone_no = '" + phone_no + "'";

            try {
                conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

                con = conrs.getCon();
                pstm = conrs.getPstm();
                rs = conrs.getRs();

                while (rs.next()) {
                    userNumber = rs.getString("user_card_number");
                    firstName = rs.getString("first_name");
                    lastName = rs.getString("last_name");
                    phoneNo = rs.getString("phone_no");
                    email = rs.getString("email");
                    area = rs.getString("area");
                    address = rs.getString("address");
                    connectionDate = rs.getString("connection_date");
                    monthlyPay = rs.getString("monthly_pay");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BillGenerateCable.class.getName()).log(Level.SEVERE, null, ex);
            }

            billTextArea.setText(null);
            billTextArea.append("\t\t BILL \n\n"
                    + "Customer Name :\t\t" + firstName +" "+ lastName + "\n"
                    + "User Number :\t\t\t" + userNumber + "\n"
                    + "\n===================================================\n"
                    + "Phone No :\t\t\t" + phoneNo + "\n\n"
                    + "Email :\t\t\t" + email + "\n\n"
                    + "Area :\t\t\t" + area + "\n\n"
                    + "Address :\t\t\t" + address + "\n\n"
                    + "Connection Date :\t\t" + connectionDate + "\n\n"
                    + "Monthly Pay :\t\t\t" + monthlyPay + "\n\n"
                    + "Month :\t\t\t" + month + "\n\n"
                    + "\n====================================================\n"
                    + "Total :\t\t\t" + monthlyPay + "\n\n");
        } else {
            JOptionPane.showMessageDialog(null, "Give Phone No");
            monthComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        
        try {
            billTextArea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(BillGenerateCable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BillGenerateCable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillGenerateCable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillGenerateCable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillGenerateCable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillGenerateCable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PhoneNolabel;
    private javax.swing.JTextArea billTextArea;
    private javax.swing.JLabel generateBillLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel monthlabel;
    private javax.swing.JTextField phoneNoTextField;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
}

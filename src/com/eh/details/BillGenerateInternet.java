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
public class BillGenerateInternet extends javax.swing.JFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String userIdNo;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String area;
    private String address;
    private String connectionDate;
    private String monthlyPay;
    private String macAddress;
    private String ipAddress;
    private ImageIcon icon = new ImageIcon("image/SKF1.jpg");
    public BillGenerateInternet() {
        initComponents();
        loadUserIdCombo();
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("SKF");
        setIconImage(icon.getImage());
    }

    public void loadUserIdCombo() {

        String columnName = " user_id ";
        String tableName = " customer_internet ";
        String whereCondition = " is_active = '1' ORDER BY user_id ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String userNumber = rs.getString("user_id");
                userIdComboBox.addItem(userNumber);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillGenerateInternet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BillGenerateInternet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generateBillLabel = new javax.swing.JLabel();
        userIdlabel = new javax.swing.JLabel();
        userIdComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        monthlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTextArea = new javax.swing.JTextArea();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        generateBillLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        generateBillLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generateBillLabel.setText("Generate Bill For Internet");
        generateBillLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        userIdlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userIdlabel.setText("User Id :");

        userIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        monthlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        monthlabel.setText("Month :");

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(printButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(generateBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(userIdlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(monthlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(generateBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdlabel)
                    .addComponent(userIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthlabel)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(printButton)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed

        if (userIdComboBox.getSelectedIndex() > 0) {

            String userId = userIdComboBox.getSelectedItem().toString();
            String month = monthComboBox.getSelectedItem().toString();

            String columnName = " ci.user_id, ci.first_name, ci.last_name, ci.phone_no, ci.email, ci.area, ci.address, ci.connection_date, ci.monthly_pay, ci.connection_fee, ci.billing_type_id, ma.address macaddress, ia.address ipaddress ";
            String tableName = " customer_internet ci left join mac_address ma ";
            String onCondition = " (ci.mac_address_id = ma.mac_address_id) left join ip_address ia on (ci.ip_address_id = ia.ip_address_id) ";
            String whereCondition = " user_id = '" + userId + "'";

            try {
                conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCondition, whereCondition);

                con = conrs.getCon();
                pstm = conrs.getPstm();
                rs = conrs.getRs();

                while (rs.next()) {
                    userIdNo = rs.getString("user_Id");
                    firstName = rs.getString("first_name");
                    lastName = rs.getString("last_name");
                    macAddress = rs.getString("macaddress");
                    ipAddress = rs.getString("ipaddress");
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
                    + "Customer Name :\t\t" + firstName + " " + lastName + "\n"
                    + "User Number :\t\t\t" + userIdNo + "\n"
                    + "\n===================================================\n"
                    + "MAC Address :\t\t\t" + macAddress + "\n\n"
                    + "IP Address :\t\t\t" + ipAddress + "\n\n"
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
            JOptionPane.showMessageDialog(null, "Select User Card Id");
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
            java.util.logging.Logger.getLogger(BillGenerateInternet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillGenerateInternet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillGenerateInternet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillGenerateInternet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillGenerateInternet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea billTextArea;
    private javax.swing.JLabel generateBillLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel monthlabel;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox<String> userIdComboBox;
    private javax.swing.JLabel userIdlabel;
    // End of variables declaration//GEN-END:variables
}

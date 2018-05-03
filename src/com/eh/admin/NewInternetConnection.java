package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Md. Emran Hossain
 */
public class NewInternetConnection extends javax.swing.JInternalFrame {

    private int active;
    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String firstName;
    private String lastName;
    private String userId;
    private String macComboBoxType;
    private String ipComboBoxType;
    private String phoneNo;
    private String email;
    private String area;
    private String address;
    private Date date;
    private String monthlyPay;
    private String connectionFee;
    private String billingType;
    private String billTypeId;
    private String comments;
    private String tableName;
    private String columnName;
    private String values;
    private boolean addInternetConnection;
    private SimpleDateFormat dateFormat;
    private String connectionDate;

    public NewInternetConnection() {
        initComponents();
        loadIPCombo();
        loadMACCombo();
        loadBillingCombo();
    }

    public void loadIPCombo() {

        String columnName = " ip_address_id, address ";
        String tableName = " ip_address ";
        String whereCondition = " ip_address_id not in (SELECT ip_address_id FROM customer_internet) ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String ipName = rs.getString("address");
                ipComboBox.addItem(ipName);
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

    public void loadMACCombo() {

        String columnName = " mac_address_id, address ";
        String tableName = " mac_address ";
        String whereCondition = " mac_address_id not in (SELECT mac_address_id FROM customer_internet) ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String MACName = rs.getString("address");
                macComboBox.addItem(MACName);
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

    public void loadBillingCombo() {

        String columnName = " bill_type_id, bill_type_name ";
        String tableName = " bill_type ";
        try {
            conrs = SelectQueryDao.selectQueryWithOutWhereClause(columnName, tableName);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String billTypeName = rs.getString("bill_type_name");
                billingTypeComboBox.addItem(billTypeName);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        userIDText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        macAddressLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressText = new javax.swing.JTextArea();
        macComboBox = new javax.swing.JComboBox<>();
        ipAddressLabel = new javax.swing.JLabel();
        connectionDateChooser = new com.toedter.calendar.JDateChooser();
        ipComboBox = new javax.swing.JComboBox<>();
        connectionDateLabel = new javax.swing.JLabel();
        monthlyPayLabel = new javax.swing.JLabel();
        monthlyPayText = new javax.swing.JTextField();
        connectionFeeLabel = new javax.swing.JLabel();
        connectionFeeText = new javax.swing.JTextField();
        billingTypeLabel = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsText = new javax.swing.JTextArea();
        CusFirstNameLabel = new javax.swing.JLabel();
        CustomerFirstNameText = new javax.swing.JTextField();
        activeLabel = new javax.swing.JLabel();
        CustomerLastNameText = new javax.swing.JTextField();
        yesRadioButton = new javax.swing.JRadioButton();
        CusLastNameLabel = new javax.swing.JLabel();
        noRadioButton = new javax.swing.JRadioButton();
        phoneNoLabel = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        emailText = new javax.swing.JTextField();
        billingTypeComboBox = new javax.swing.JComboBox<>();
        areaText = new javax.swing.JTextField();
        areaLabel = new javax.swing.JLabel();
        phoneNoText = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Internet Connection");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        userIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userIdLabel.setText("User Id :");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressLabel.setText("Address :");

        macAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        macAddressLabel.setText("MAC Address :");

        addressText.setColumns(20);
        addressText.setRows(5);
        jScrollPane2.setViewportView(addressText);

        macComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));

        ipAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipAddressLabel.setText("IP Address :");

        ipComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));

        connectionDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionDateLabel.setText("Connection Date :");

        monthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyPayLabel.setText("Monthly Pay :");

        connectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionFeeLabel.setText("Connection Fee :");

        billingTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billingTypeLabel.setText("Billing Type :");

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentLabel.setText("Comments :");

        commentsText.setColumns(20);
        commentsText.setRows(5);
        jScrollPane1.setViewportView(commentsText);

        CusFirstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CusFirstNameLabel.setText("Customer First Name :");

        activeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        activeLabel.setText("Active :");

        buttonGroup1.add(yesRadioButton);
        yesRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yesRadioButton.setText("Yes");
        yesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesRadioButtonActionPerformed(evt);
            }
        });

        CusLastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CusLastNameLabel.setText("Customer Last Name :");

        buttonGroup1.add(noRadioButton);
        noRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noRadioButton.setText("No");
        noRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noRadioButtonActionPerformed(evt);
            }
        });

        phoneNoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneNoLabel.setText("Phone No :");

        save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save.setText("Add New Internat Connection");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email :");

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        billingTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        areaLabel.setText("Area :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(phoneNoLabel)
                                                    .addComponent(CusLastNameLabel)
                                                    .addComponent(userIdLabel)
                                                    .addComponent(macAddressLabel)
                                                    .addComponent(ipAddressLabel))
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(macComboBox, 0, 182, Short.MAX_VALUE)
                                                    .addComponent(userIDText)
                                                    .addComponent(ipComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(phoneNoText)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(109, 109, 109)
                                                        .addComponent(emailLabel)
                                                        .addGap(18, 18, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(addressLabel)
                                                        .addGap(21, 21, 21)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                                    .addComponent(emailText))))
                                        .addGap(22, 22, 22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CustomerLastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(CusFirstNameLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(CustomerFirstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(11, 11, 11)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(monthlyPayLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(connectionFeeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(billingTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(commentLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addComponent(connectionDateLabel)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(73, 73, 73)
                                            .addComponent(activeLabel)))
                                    .addComponent(areaLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(connectionFeeText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monthlyPayText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(connectionDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(yesRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(noRadioButton))
                                    .addComponent(billingTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 181, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(areaText, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(save)
                                .addGap(18, 18, 18)
                                .addComponent(reset)))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(areaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(connectionDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthlyPayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthlyPayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectionFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billingTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(billingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yesRadioButton)
                            .addComponent(noRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusFirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustomerFirstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusLastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustomerLastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(macComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(macAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(reset))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesRadioButtonActionPerformed
        active = 1;
    }//GEN-LAST:event_yesRadioButtonActionPerformed

    private void noRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noRadioButtonActionPerformed
        active = 0;
    }//GEN-LAST:event_noRadioButtonActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        firstName = CustomerFirstNameText.getText();
        lastName = CustomerLastNameText.getText();
        userId = userIDText.getText();
        macComboBoxType = (String) macComboBox.getSelectedItem();
        ipComboBoxType = (String) ipComboBox.getSelectedItem();
        phoneNo = phoneNoText.getText();
        email = emailText.getText();
        area = areaText.getText();
        address = addressText.getText();
        date = connectionDateChooser.getDate();

        monthlyPay = monthlyPayText.getText();
        connectionFee = connectionFeeText.getText();
        billingType = (String) billingTypeComboBox.getSelectedItem();
        if (billingType.equals("Cash")) {
            billTypeId = "1";
        } else if (billingType.equals("Bkash")) {
            billTypeId = "2";
        }
        comments = commentsText.getText();

        if (!firstName.equals("")) {
            if (!lastName.equals("")) {
                if (!userId.equals("")) {
                    if (macComboBox.getSelectedIndex() > 0) {
                        if (ipComboBox.getSelectedIndex() > 0) {
                            if (!phoneNo.equals("")) {
                                if (!email.equals("")) {
                                    if (!area.equals("")) {
                                        if (!address.equals("")) {
                                            if (date != null) {
                                                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                                                connectionDate = dateFormat.format(date);
                                                if (!monthlyPay.equals("")) {
                                                    if (!connectionFee.equals("")) {
                                                        if (billingTypeComboBox.getSelectedIndex() > 0) {
                                                            if (yesRadioButton.isSelected() || noRadioButton.isSelected()) {
                                                                if (!comments.equals("")) {

                                                                    try {
                                                                        tableName = " customer_internet ";
                                                                        columnName = " first_name, last_name, user_id, mac_address_id, ip_address_id, phone_no, email, area, address, connection_date, monthly_pay, connection_fee, billing_type_id, comments, is_active ";
                                                                        values = "'" + firstName + "', '" + lastName + "', '" + userId + "', (SELECT mac_address_id FROM mac_address where address = '" + macComboBoxType + "'), (SELECT ip_address_id FROM ip_address where address = '" + ipComboBoxType + "'), '" + phoneNo + "', '" + email + "', '" + area + "', '" + address + "', '" + connectionDate + "', '" + monthlyPay + "', '" + connectionFee + "', '" + billTypeId + "', '" + comments + "', '" + active + "'";
                                                                        addInternetConnection = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                                                                    } catch (SQLException ex) {
                                                                        Logger.getLogger(NewInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
                                                                    }

                                                                    if (addInternetConnection) {
                                                                        JOptionPane.showMessageDialog(null, "New Internat Connection created");
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "No Connection created");
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Insert Comment");
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Insert Active or not");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Insert Billing Type");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Insert Connection Fee");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Insert Monthly Pay");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Insert a Date");
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Insert Address");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Insert Area");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Insert Email");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Insert Phone No");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Select IP");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Select MAC ID");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert User Id");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Last Name");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert First Name");
        }

        System.out.println(macComboBoxType);
        System.out.println(ipComboBoxType);
        System.out.println(connectionDate);
    }//GEN-LAST:event_saveActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        CustomerFirstNameText.setText("");
        CustomerLastNameText.setText("");
        userIDText.setText("");
        macComboBox.setSelectedIndex(0);
        ipComboBox.setSelectedIndex(0);
        phoneNoText.setText("");
        emailText.setText("");
        areaText.setText("");
        addressText.setText("");
        monthlyPayText.setText("");
        connectionFeeText.setText("");
        billingTypeComboBox.setSelectedIndex(0);
        commentsText.setText("");
    }//GEN-LAST:event_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CusFirstNameLabel;
    private javax.swing.JLabel CusLastNameLabel;
    private javax.swing.JTextField CustomerFirstNameText;
    private javax.swing.JTextField CustomerLastNameText;
    private javax.swing.JLabel activeLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextArea addressText;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JTextField areaText;
    private javax.swing.JComboBox<String> billingTypeComboBox;
    private javax.swing.JLabel billingTypeLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JTextArea commentsText;
    private com.toedter.calendar.JDateChooser connectionDateChooser;
    private javax.swing.JLabel connectionDateLabel;
    private javax.swing.JLabel connectionFeeLabel;
    private javax.swing.JTextField connectionFeeText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel ipAddressLabel;
    private javax.swing.JComboBox<String> ipComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel macAddressLabel;
    private javax.swing.JComboBox<String> macComboBox;
    private javax.swing.JLabel monthlyPayLabel;
    private javax.swing.JTextField monthlyPayText;
    private javax.swing.JRadioButton noRadioButton;
    private javax.swing.JLabel phoneNoLabel;
    private javax.swing.JTextField phoneNoText;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTextField userIDText;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JRadioButton yesRadioButton;
    // End of variables declaration//GEN-END:variables
}

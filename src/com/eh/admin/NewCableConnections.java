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
public class NewCableConnections extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private int active;
    private String firstName;
    private String lastName;
    private String cardNo;
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
    private SimpleDateFormat dateFormat;
    private String inputDate;
    private String tableName;
    private String columnName;
    private String values;
    private boolean addCableConnection;

    /**
     * Creates new form Connections
     */
    public NewCableConnections() {
        initComponents();
        loadBillingTypeCombo();
    }

    public void clearAll() {
        CustomerFirstNameText.setText("");
        CustomerLastNameText.setText("");
        cardNoText.setText("");
        phoneNoText.setText("");
        emailText.setText("");
        areaText.setText("");
        addressText.setText("");
        monthlyPayText.setText("");
        connectionFeeText.setText("");
        billingTypeComboBox.setSelectedIndex(0);
        commentsText.setText("");
    }

    public void loadBillingTypeCombo() {

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
        connectionFeeLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        connectionFeeText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressText = new javax.swing.JTextArea();
        billingTypeLabel = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsText = new javax.swing.JTextArea();
        connectionDateLabel = new javax.swing.JLabel();
        billingTypeComboBox = new javax.swing.JComboBox<>();
        activeLabel = new javax.swing.JLabel();
        CusFirstNameLabel = new javax.swing.JLabel();
        CustomerFirstNameText = new javax.swing.JTextField();
        CustomerLastNameText = new javax.swing.JTextField();
        CusLastNameLabel = new javax.swing.JLabel();
        phoneNoLabel = new javax.swing.JLabel();
        yesRadioButton = new javax.swing.JRadioButton();
        noRadioButton = new javax.swing.JRadioButton();
        phoneNoText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        areaText = new javax.swing.JTextField();
        monthlyPayLabel = new javax.swing.JLabel();
        monthlyPayText = new javax.swing.JTextField();
        areaLabel = new javax.swing.JLabel();
        cardNoLabel = new javax.swing.JLabel();
        cardNoText = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setClosable(true);
        setTitle("New Cable Connection");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Cable Connection");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        connectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionFeeLabel.setText("Connecton Fee :");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressLabel.setText("Address :");

        connectionFeeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                connectionFeeTextKeyTyped(evt);
            }
        });

        addressText.setColumns(20);
        addressText.setRows(5);
        jScrollPane2.setViewportView(addressText);

        billingTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billingTypeLabel.setText("Billing Type :");

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentLabel.setText("Comments :");

        commentsText.setColumns(20);
        commentsText.setRows(5);
        jScrollPane1.setViewportView(commentsText);

        connectionDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionDateLabel.setText("Connection Date :");

        billingTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));

        activeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        activeLabel.setText("Active :");

        CusFirstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CusFirstNameLabel.setText("Customer First Name :");

        CusLastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CusLastNameLabel.setText("Customer Last Name :");

        phoneNoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneNoLabel.setText("Phone No :");

        buttonGroup1.add(yesRadioButton);
        yesRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yesRadioButton.setText("Yes");
        yesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(noRadioButton);
        noRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noRadioButton.setText("No");
        noRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noRadioButtonActionPerformed(evt);
            }
        });

        phoneNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNoTextKeyTyped(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email :");

        monthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyPayLabel.setText("Monthly Pay :");

        monthlyPayText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monthlyPayTextKeyTyped(evt);
            }
        });

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        areaLabel.setText("Area :");

        cardNoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cardNoLabel.setText("Card Number :");

        save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save.setText("Add New Cable Connection");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CusFirstNameLabel)
                            .addGap(18, 18, 18)
                            .addComponent(CustomerFirstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CusLastNameLabel)
                            .addGap(18, 18, 18)
                            .addComponent(CustomerLastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phoneNoLabel)
                            .addComponent(emailLabel)
                            .addComponent(areaLabel)
                            .addComponent(addressLabel)
                            .addComponent(cardNoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(areaText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNoText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(cardNoText, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(monthlyPayLabel)
                    .addComponent(connectionDateLabel)
                    .addComponent(connectionFeeLabel)
                    .addComponent(billingTypeLabel)
                    .addComponent(activeLabel)
                    .addComponent(commentLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monthlyPayText)
                    .addComponent(connectionFeeText)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(yesRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(noRadioButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(billingTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(save)
                        .addGap(18, 18, 18)
                        .addComponent(reset)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(connectionDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthlyPayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthlyPayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectionFeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusFirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustomerFirstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusLastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustomerLastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billingTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(billingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yesRadioButton)
                            .addComponent(noRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(areaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(reset))
                .addGap(131, 131, 131))
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
        cardNo = cardNoText.getText();
        phoneNo = phoneNoText.getText();
        email = emailText.getText();
        area = areaText.getText();
        address = addressText.getText();
        date = jDateChooser.getDate();
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
                if (!cardNo.equals("")) {
                    if (!phoneNo.equals("")) {
                        if (!email.equals("")) {
                            if (!area.equals("")) {
                                if (!address.equals("")) {
                                    if (date != null) {
                                        if (!monthlyPay.equals("")) {
                                            if (!connectionFee.equals("")) {
                                                if (billingTypeComboBox.getSelectedIndex() > 0) {
                                                    if (yesRadioButton.isSelected() || noRadioButton.isSelected()) {
                                                        if (!comments.equals("")) {
                                                            try {
                                                                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                                                                inputDate = dateFormat.format(date);

                                                                tableName = " customer_cable ";
                                                                columnName = " first_name, last_name, user_card_number, phone_no, email, area, address, connection_date, monthly_pay, connection_fee, billing_type_id, comments, is_active ";
                                                                values = "'" + firstName + "', '" + lastName + "', '" + cardNo + "', '" + phoneNo + "', '" + email + "', '" + area + "', '" + address + "', '" + inputDate + "', '" + monthlyPay + "', '" + connectionFee + "', '" + billTypeId + "', '" + comments + "', '" + active + "'";
                                                                addCableConnection = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                                                            } catch (SQLException ex) {
                                                                Logger.getLogger(NewCableConnections.class.getName()).log(Level.SEVERE, null, ex);
                                                            }
                                                            if (addCableConnection) {
                                                                JOptionPane.showMessageDialog(null, "New Connection created Successfully");
                                                                clearAll();
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "New Connection Not created");
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
                                        JOptionPane.showMessageDialog(null, "Choose Date");
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
                    JOptionPane.showMessageDialog(null, "Insert Card Number");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Last Name");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert First Name");
        }
    }//GEN-LAST:event_saveActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        clearAll();
    }//GEN-LAST:event_resetActionPerformed

    private void phoneNoTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNoTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_phoneNoTextKeyTyped

    private void monthlyPayTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthlyPayTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_monthlyPayTextKeyTyped

    private void connectionFeeTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_connectionFeeTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_connectionFeeTextKeyTyped
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }


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
    private javax.swing.JLabel cardNoLabel;
    private javax.swing.JTextField cardNoText;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JTextArea commentsText;
    private javax.swing.JLabel connectionDateLabel;
    private javax.swing.JLabel connectionFeeLabel;
    private javax.swing.JTextField connectionFeeText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel monthlyPayLabel;
    private javax.swing.JTextField monthlyPayText;
    private javax.swing.JRadioButton noRadioButton;
    private javax.swing.JLabel phoneNoLabel;
    private javax.swing.JTextField phoneNoText;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JRadioButton yesRadioButton;
    // End of variables declaration//GEN-END:variables
}

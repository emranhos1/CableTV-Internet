package com.eh.admin;

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
import static com.eh.admin.AdminDashboard.DesktopPanel;
import com.eh.details.ShowCableCustomerDetails;
import javax.swing.JFrame;
import javax.swing.table.TableModel;

/**
 *
 * @author Md. Emran Hossain
 */
public class AllCableConnection extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String billingType;

    public AllCableConnection() {
        initComponents();
        Update_table();
        loadUserNumberCombo();
    }

    public void clearAll() {
        userCardComboBox.setSelectedIndex(0);
        firstNameText.setText("");
        lastNameText.setText("");
        phoneText.setText("");
        emailText.setText("");
        areaText.setText("");
        connectionFeeText.setText("");
        addressArea.setText("");
        connectionDateText.setText("");
        monthlyPayText.setText("");
        billingTypeText.setText("");
        commentArea.setText("");
    }
    ShowCableCustomerDetails sccd = new ShowCableCustomerDetails();

    public void loadUserNumberCombo() {

        String columnName = " concat(user_card_number,'~[',first_name, ' ', last_name, ']') as user_card_number ";
        String tableName = " customer_cable ";
        String whereCondition = " is_active = '1' ORDER BY user_card_number ASC ";
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
            Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Update_table() {
        try {

            String columnName = " * ";
            String tableName = " customer_cable ";
            String whereCondition = " is_active = '1' ORDER BY user_card_number ASC ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
            while (rs.next()) {
                String customer_id = rs.getString("customer_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_card_number = rs.getString("user_card_number");
                String phone_no = rs.getString("phone_no");
                String email = rs.getString("email");
                String area = rs.getString("area");
                String address = rs.getString("address");
                String connection_date = rs.getString("connection_date");
                String monthly_pay = rs.getString("monthly_pay");
                String connection_fee = rs.getString("connection_fee");
                String billing_type_id = rs.getString("billing_type_id");
                String comments = rs.getString("comments");
                if (billing_type_id.equals("1")) {
                    billingType = "Cash";
                } else if (billing_type_id.equals("1")) {
                    billingType = "Bkash";
                }

                model.addRow(new Object[]{first_name + " " + last_name, phone_no, user_card_number, email, area, address, connection_date, monthly_pay, connection_fee, billingType, comments});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        cableTable = new javax.swing.JTable();
        allCableConnection = new javax.swing.JLabel();
        monthlyPayText = new javax.swing.JTextField();
        connectionFeeLabel = new javax.swing.JLabel();
        connectionFeeText = new javax.swing.JTextField();
        commentLabel = new javax.swing.JLabel();
        usercardnumberlabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentArea = new javax.swing.JTextArea();
        userCardComboBox = new javax.swing.JComboBox<>();
        firstNameLabel = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        firstNameText = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        lastNameLabel = new javax.swing.JLabel();
        addCableConnection = new javax.swing.JButton();
        lastNameText = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        billingTypeLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        billingTypeText = new javax.swing.JTextField();
        arealLabel = new javax.swing.JLabel();
        areaText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        conDateLabel = new javax.swing.JLabel();
        connectionDateText = new javax.swing.JTextField();
        monthlyPayLabel = new javax.swing.JLabel();
        closeConnection = new javax.swing.JButton();
        searchPhoneTextField = new javax.swing.JTextField();
        searchwithPhoneLabel = new javax.swing.JLabel();

        setClosable(true);
        setTitle("All Cable Connection");
        setToolTipText("");

        cableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone No", "User Number", "Email", "Area", "Address", "Connection Date", "Monthly Pay", "Connection Fee", "Billing Type", "Comment"
            }
        ));
        cableTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cableTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cableTable);

        allCableConnection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        allCableConnection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allCableConnection.setText("All Cable Connection");
        allCableConnection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        monthlyPayText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monthlyPayTextKeyTyped(evt);
            }
        });

        connectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionFeeLabel.setText("Connection Fee :");

        connectionFeeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionFeeTextActionPerformed(evt);
            }
        });
        connectionFeeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                connectionFeeTextKeyTyped(evt);
            }
        });

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentLabel.setText("Comment :");

        usercardnumberlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usercardnumberlabel.setText("User Card Number :");

        commentArea.setColumns(20);
        commentArea.setRows(5);
        jScrollPane2.setViewportView(commentArea);

        userCardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        userCardComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCardComboBoxActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        firstNameLabel.setText("First Name :");

        Update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lastNameLabel.setText("Last Name :");

        addCableConnection.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addCableConnection.setText("New Connection");
        addCableConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCableConnectionActionPerformed(evt);
            }
        });

        phoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneLabel.setText("Phone No :");

        phoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneTextKeyTyped(evt);
            }
        });

        billingTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billingTypeLabel.setText("Billing Type :");

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email :");

        billingTypeText.setEditable(false);
        billingTypeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billingTypeTextActionPerformed(evt);
            }
        });

        arealLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        arealLabel.setText("Area :");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressLabel.setText("Address :");

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        conDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        conDateLabel.setText("Connection Date :");

        connectionDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionDateTextActionPerformed(evt);
            }
        });

        monthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyPayLabel.setText("Monthly Pay :");

        closeConnection.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closeConnection.setText("Close Connection");
        closeConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectionActionPerformed(evt);
            }
        });

        searchPhoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchPhoneTextFieldKeyReleased(evt);
            }
        });

        searchwithPhoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchwithPhoneLabel.setText("Search Phone :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(usercardnumberlabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(arealLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(connectionFeeLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameText)
                            .addComponent(emailText)
                            .addComponent(areaText)
                            .addComponent(userCardComboBox, 0, 190, Short.MAX_VALUE)
                            .addComponent(phoneText)
                            .addComponent(lastNameText)
                            .addComponent(connectionFeeText)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(closeConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addCableConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 17, Short.MAX_VALUE)
                                .addComponent(conDateLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(billingTypeLabel)
                                    .addComponent(monthlyPayLabel)
                                    .addComponent(commentLabel)
                                    .addComponent(searchwithPhoneLabel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(connectionDateText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(monthlyPayText)
                            .addComponent(billingTypeText)
                            .addComponent(searchPhoneTextField))))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(allCableConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(allCableConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userCardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel)
                            .addComponent(usercardnumberlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLabel)
                            .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conDateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(monthlyPayLabel)
                                .addComponent(monthlyPayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(arealLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billingTypeLabel)
                            .addComponent(billingTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(connectionFeeLabel)
                                .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(commentLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Update)
                            .addComponent(closeConnection))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addCableConnection)
                            .addComponent(reset)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchwithPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userCardComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCardComboBoxActionPerformed

        String[] comboBox1 = userCardComboBox.getSelectedItem().toString().split("~");
        String comboBox = comboBox1[0];
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
                firstNameText.setText(first_name);
                String last_name = rs.getString("last_name");
                lastNameText.setText(last_name);
                String phone_no = rs.getString("phone_no");
                phoneText.setText(phone_no);
                String email = rs.getString("email");
                emailText.setText(email);
                String area = rs.getString("area");
                areaText.setText(area);
                String connectionFee = rs.getString("connection_fee");
                connectionFeeText.setText(connectionFee);
                String address = rs.getString("address");
                addressArea.setText(address);
                String connection_date = rs.getString("connection_date");
                connectionDateText.setText(connection_date);
                String monthly_pay = rs.getString("monthly_pay");
                monthlyPayText.setText(monthly_pay);
                String billing_type_id = rs.getString("billing_type_id");
                if (billing_type_id.equals("1")) {
                    billingType = "Cash";
                } else if (billing_type_id.equals("1")) {
                    billingType = "Bkash";
                }
                billingTypeText.setText(billingType);
                String comments = rs.getString("comments");
                commentArea.setText(comments);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_userCardComboBoxActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed

        if (userCardComboBox.getSelectedIndex() > 0) {

            try {
                String[] comboBox1 = userCardComboBox.getSelectedItem().toString().split("~");
                String comboBox = comboBox1[0];
                String firstName = firstNameText.getText();
                String lastName = lastNameText.getText();
                String phoneNo = phoneText.getText();
                String email = emailText.getText();
                String area = areaText.getText();
                String connectionFee = connectionFeeText.getText();
                String address = addressArea.getText();
                String connectionDate = connectionDateText.getText();
                String monthlyPay = monthlyPayText.getText();
                String comment = commentArea.getText();

                String tableName = " customer_cable ";
                String columnNameANDcolumnValue = " first_name = '" + firstName + "', last_name='" + lastName + "', phone_no = '" + phoneNo + "', email= '" + email + "', area= '" + area + "', address= '" + address + "', connection_date = '" + connectionDate + "', monthly_pay = '" + monthlyPay + "', connection_fee = '" + connectionFee + "', comments='" + comment + "' ";
                String whereCondition = " user_card_number = '" + comboBox + "'";

                boolean updateCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

                if (updateCableConnection) {
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    clearAll();
                    DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
                    model.setRowCount(0);
                    Update_table();

                } else {
                    JOptionPane.showMessageDialog(null, "Not Update");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select one Card Number to Close Connection");
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        clearAll();
    }//GEN-LAST:event_resetActionPerformed

    private void addCableConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCableConnectionActionPerformed
        NewCableConnections ncc = new NewCableConnections();
        DesktopPanel.add(ncc);
        ncc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addCableConnectionActionPerformed

    private void closeConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectionActionPerformed
        if (userCardComboBox.getSelectedIndex() > 0) {
            try {
                String[] comboBox1 = userCardComboBox.getSelectedItem().toString().split("~");
                String comboBox = comboBox1[0];

                String tableName = " customer_cable ";
                String columnNameANDcolumnValue = " is_active = '0' ";
                String whereCondition = " user_card_number = '" + comboBox + "'";

                boolean closeCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

                if (closeCableConnection) {
                    JOptionPane.showMessageDialog(null, "Connection Closed");
                    clearAll();
                    DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
                    model.setRowCount(0);
                    Update_table();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Closed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select one Card Number to Close Connection");
        }

    }//GEN-LAST:event_closeConnectionActionPerformed

    private void connectionDateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionDateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionDateTextActionPerformed

    private void connectionFeeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionFeeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionFeeTextActionPerformed

    private void cableTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cableTableMouseClicked
        try {
            int index = cableTable.getSelectedRow();
            TableModel model = cableTable.getModel();

            String userCardNo = model.getValueAt(index, 2).toString();

            String columnName = " * ";
            String tableName = " customer_cable ";
            String whereCondition = " user_card_number = '" + userCardNo + "' ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            sccd.setVisible(true);
            sccd.pack();
            sccd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            while (rs.next()) {
                sccd.customerIdText.setText(rs.getString("customer_id"));
                sccd.firstNameText.setText(rs.getString("first_name"));
                sccd.lastNameText.setText(rs.getString("last_name"));
                sccd.cardnoText.setText(rs.getString("user_card_number"));
                sccd.phoneText.setText(rs.getString("phone_no"));
                sccd.emailText.setText(rs.getString("email"));
                sccd.areaText.setText(rs.getString("area"));
                sccd.connectionFeeText.setText(rs.getString("connection_fee"));
                sccd.addressArea.setText(rs.getString("address"));
                sccd.connectionDateText.setText(rs.getString("connection_date"));
                sccd.monthlypayText.setText(rs.getString("monthly_pay"));
                sccd.commentsArea.setText(rs.getString("comments"));
                sccd.cableDetailsLabel.setText("Details of : " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cableTableMouseClicked

    private void phoneTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_phoneTextKeyTyped

    private void connectionFeeTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_connectionFeeTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_connectionFeeTextKeyTyped

    private void monthlyPayTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthlyPayTextKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_monthlyPayTextKeyTyped

    private void billingTypeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billingTypeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billingTypeTextActionPerformed

    private void searchPhoneTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchPhoneTextFieldKeyReleased

        String phoneNo = searchPhoneTextField.getText();

        String columnName = " * ";
        String tableName = " customer_cable ";
        String whereCondition = " phone_no = '" + phoneNo + "' and is_active = '1'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String userCardNumber = rs.getString("user_card_number");
                String email = rs.getString("email");
                String area = rs.getString("area");
                String address = rs.getString("address");
                String connectionDate = rs.getString("connection_date");
                String monthlyPay = rs.getString("monthly_pay");
                String connectionFee = rs.getString("connection_fee");
                String billingTypeId = rs.getString("billing_type_id");
                String comments = rs.getString("comments");
                if (billingTypeId.equals("1")) {
                    billingType = "Cash";
                } else if (billingTypeId.equals("2")) {
                    billingType = "Bkash";
                }
                model.addRow(new Object[]{firstName + " " + lastName, phoneNo, userCardNumber, email, area, address, connectionDate, monthlyPay, connectionFee, billingType, comments});
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllCableConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchPhoneTextFieldKeyReleased

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton addCableConnection;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel allCableConnection;
    private javax.swing.JTextField areaText;
    private javax.swing.JLabel arealLabel;
    private javax.swing.JLabel billingTypeLabel;
    private javax.swing.JTextField billingTypeText;
    private javax.swing.JTable cableTable;
    private javax.swing.JButton closeConnection;
    private javax.swing.JTextArea commentArea;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JLabel conDateLabel;
    private javax.swing.JTextField connectionDateText;
    private javax.swing.JLabel connectionFeeLabel;
    private javax.swing.JTextField connectionFeeText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JLabel monthlyPayLabel;
    private javax.swing.JTextField monthlyPayText;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneText;
    private javax.swing.JButton reset;
    private javax.swing.JTextField searchPhoneTextField;
    private javax.swing.JLabel searchwithPhoneLabel;
    private javax.swing.JComboBox<String> userCardComboBox;
    private javax.swing.JLabel usercardnumberlabel;
    // End of variables declaration//GEN-END:variables
}

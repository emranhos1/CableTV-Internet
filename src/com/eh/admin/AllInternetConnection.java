package com.eh.admin;

import static com.eh.admin.AdminDashboard.DesktopPanel;
import com.eh.dao.SelectQueryDao;
import com.eh.dao.UpdateQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.ShowInternatCustomerDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Md. Emran Hossain
 */
public class AllInternetConnection extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String billingType;

    public AllInternetConnection() {
        initComponents();
        loadUserNIdCombo();
        Update_table();
    }

    public void clearAll() {
        useridComboBox.setSelectedIndex(0);
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
    ShowInternatCustomerDetails sicd = new ShowInternatCustomerDetails();

    public void loadUserNIdCombo() {

        String columnName = " concat(user_id,'~[',first_name,' ', last_name,']') as user_id ";
        String tableName = " customer_internet ";
        String whereCondition = " is_active = '1' ORDER BY user_id ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String userid = rs.getString("user_id");
                useridComboBox.addItem(userid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Update_table() {
        try {

            String columnName = " * ";
            String tableName = " customer_internet ";
            String whereCondition = " is_active = '1' ORDER BY user_id ASC ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) internetTable.getModel();
            while (rs.next()) {
                String customer_id = rs.getString("cus_internet_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_id = rs.getString("user_id");
                String mac_address_id = rs.getString("mac_address_id");
                String ip_address_id = rs.getString("ip_address_id");
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

                model.addRow(new Object[]{first_name + " " + last_name, phone_no, user_id, mac_address_id, ip_address_id, email, area, address, connection_date, monthly_pay, connection_fee, billingType, comments});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
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

        allInternateConnection = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        billingTypeLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        billingTypeText = new javax.swing.JTextField();
        arealLabel = new javax.swing.JLabel();
        monthlyPayText = new javax.swing.JTextField();
        areaText = new javax.swing.JTextField();
        connectionFeeLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        connectionFeeText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        commentLabel = new javax.swing.JLabel();
        usercardnumberlabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentArea = new javax.swing.JTextArea();
        conDateLabel = new javax.swing.JLabel();
        connectionDateText = new javax.swing.JTextField();
        monthlyPayLabel = new javax.swing.JLabel();
        useridComboBox = new javax.swing.JComboBox<>();
        closeConnection = new javax.swing.JButton();
        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        lastNameLabel = new javax.swing.JLabel();
        addCableConnection = new javax.swing.JButton();
        lastNameText = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        internetTable = new javax.swing.JTable();
        update = new javax.swing.JButton();

        setClosable(true);
        setTitle("All Internet Connection");

        allInternateConnection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        allInternateConnection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allInternateConnection.setText("All Internet Connection");
        allInternateConnection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        arealLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        arealLabel.setText("Area :");

        monthlyPayText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monthlyPayTextKeyTyped(evt);
            }
        });

        connectionFeeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectionFeeLabel.setText("Connection Fee :");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressLabel.setText("Address :");

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

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        commentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        commentLabel.setText("Comment :");

        usercardnumberlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usercardnumberlabel.setText("User Id :");

        commentArea.setColumns(20);
        commentArea.setRows(5);
        jScrollPane2.setViewportView(commentArea);

        conDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        conDateLabel.setText("Connection Date :");

        connectionDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionDateTextActionPerformed(evt);
            }
        });

        monthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        monthlyPayLabel.setText("Monthly Pay :");

        useridComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        useridComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridComboBoxActionPerformed(evt);
            }
        });

        closeConnection.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closeConnection.setText("Close Connection");
        closeConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectionActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        firstNameLabel.setText("First Name :");

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

        internetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone No", "User Id", "MAC", "IP", "Email", "Area", "Address", "Connection Date", "Monthly Pay", "Connection Fee", "Billing Type", "Comment"
            }
        ));
        internetTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                internetTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(internetTable);

        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(allInternateConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(usercardnumberlabel)
                                        .addComponent(firstNameLabel)
                                        .addComponent(lastNameLabel)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(connectionFeeLabel)
                                                .addComponent(arealLabel))
                                            .addGap(4, 4, 4)))
                                    .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailText)
                                    .addComponent(areaText)
                                    .addComponent(connectionFeeText, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(useridComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstNameText)
                                    .addComponent(lastNameText)
                                    .addComponent(phoneText))
                                .addGap(73, 73, 73)
                                .addComponent(addressLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(130, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(monthlyPayLabel)
                                    .addComponent(conDateLabel)
                                    .addComponent(billingTypeLabel)
                                    .addComponent(commentLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(addCableConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(closeConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(118, 118, 118)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(connectionDateText)
                                    .addComponent(monthlyPayText)
                                    .addComponent(billingTypeText)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(allInternateConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(useridComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel)
                            .addComponent(usercardnumberlabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLabel)
                            .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conDateLabel)
                            .addComponent(connectionDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthlyPayLabel)
                    .addComponent(monthlyPayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arealLabel)
                    .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billingTypeLabel)
                    .addComponent(billingTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(connectionFeeLabel)
                                    .addComponent(connectionFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(commentLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closeConnection)
                            .addComponent(update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset)
                            .addComponent(addCableConnection))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectionFeeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionFeeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionFeeTextActionPerformed

    private void connectionDateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionDateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionDateTextActionPerformed

    private void useridComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridComboBoxActionPerformed

        String[] comboBox1 = useridComboBox.getSelectedItem().toString().split("~");
        String comboBox = comboBox1[0];

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
            Logger.getLogger(AllInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_useridComboBoxActionPerformed

    private void closeConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectionActionPerformed

        if (useridComboBox.getSelectedIndex() > 0) {
            try {
                String[] comboBox1 = useridComboBox.getSelectedItem().toString().split("~");
                String comboBox = comboBox1[0];

                String tableName = " customer_internet ";
                String columnNameANDcolumnValue = " is_active = '0' ";
                String whereCondition = " user_id = '" + comboBox + "'";

                boolean closeCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

                if (closeCableConnection) {
                    JOptionPane.showMessageDialog(null, "Connection Closed");
                    clearAll();
                    DefaultTableModel model = (DefaultTableModel) internetTable.getModel();
                    model.setRowCount(0);
                    Update_table();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Closed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AllInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Id for Connection Close");
        }
    }//GEN-LAST:event_closeConnectionActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        clearAll();
    }//GEN-LAST:event_resetActionPerformed

    private void addCableConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCableConnectionActionPerformed
        NewInternetConnection nic = new NewInternetConnection();
        DesktopPanel.add(nic);
        nic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addCableConnectionActionPerformed

    private void internetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_internetTableMouseClicked
        try {
            int index = internetTable.getSelectedRow();
            TableModel model = internetTable.getModel();

            String userId = model.getValueAt(index, 2).toString();

            String columnName = " ci.cus_internet_id, ci.first_name, ci.last_name, ci.user_id, ci.phone_no, ci.email, ci.area, ci.address, ci.connection_date, ci.monthly_pay, ci.connection_fee, ci.comments, ma.address macaddress, ia.address ipaddress ";
            String tableName = " customer_internet ci left join mac_address ma ";
            String onCondition = " (ci.mac_address_id = ma.mac_address_id) left join ip_address ia on (ci.ip_address_id = ia.ip_address_id) ";
            String whereCondition = " user_id = '" + userId + "' ";

            conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCondition, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            sicd.setVisible(true);
            sicd.pack();
            sicd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            while (rs.next()) {
                sicd.customerIdText.setText(rs.getString("cus_internet_id"));
                sicd.firstNameText.setText(rs.getString("first_name"));
                sicd.lastNameText.setText(rs.getString("last_name"));
                sicd.userIdText.setText(rs.getString("user_id"));
                sicd.macAddressText.setText(rs.getString("macaddress"));
                sicd.IPAddressText.setText(rs.getString("ipaddress"));
                sicd.phoneText.setText(rs.getString("phone_no"));
                sicd.emailText.setText(rs.getString("email"));
                sicd.areaText.setText(rs.getString("area"));
                sicd.connectionFeeText.setText(rs.getString("connection_fee"));
                sicd.addressArea.setText(rs.getString("address"));
                sicd.connectionDateText.setText(rs.getString("connection_date"));
                sicd.monthlypayText.setText(rs.getString("monthly_pay"));
                sicd.internetDetailsLabel.setText("Details of : " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_internetTableMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        if (useridComboBox.getSelectedIndex() > 0) {
            try {
                String[] comboBox1 = useridComboBox.getSelectedItem().toString().split("~");
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

                String tableName = " customer_internet ";
                String columnNameANDcolumnValue = " first_name = '" + firstName + "', last_name='" + lastName + "', phone_no = '" + phoneNo + "', email= '" + email + "', area= '" + area + "', address= '" + address + "', connection_date = '" + connectionDate + "', monthly_pay = '" + monthlyPay + "', connection_fee = '" + connectionFee + "', comments='" + comment + "' ";
                String whereCondition = " user_id = '" + comboBox + "'";

                boolean updateCableConnection = UpdateQueryDao.updateQueryWithWhereClause(tableName, columnNameANDcolumnValue, whereCondition);

                if (updateCableConnection) {
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    clearAll();
                    DefaultTableModel model = (DefaultTableModel) internetTable.getModel();
                    model.setRowCount(0);
                    Update_table();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Update");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AllInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Id for Update");
        }
    }//GEN-LAST:event_updateActionPerformed

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
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCableConnection;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel allInternateConnection;
    private javax.swing.JTextField areaText;
    private javax.swing.JLabel arealLabel;
    private javax.swing.JLabel billingTypeLabel;
    private javax.swing.JTextField billingTypeText;
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
    private javax.swing.JTable internetTable;
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
    private javax.swing.JButton update;
    private javax.swing.JLabel usercardnumberlabel;
    private javax.swing.JComboBox<String> useridComboBox;
    // End of variables declaration//GEN-END:variables
}

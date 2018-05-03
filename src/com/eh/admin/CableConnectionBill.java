package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.BillGenerateCable;
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
public class CableConnectionBill extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public CableConnectionBill() {
        initComponents();
        LoadUserCardNoComboBox();
    }

    public void LoadUserCardNoComboBox() {

        String columnName = " user_card_number ";
        String tableName = " customer_cable ";
        String whereCondition = " is_active = '1' ORDER BY user_card_number ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String userNumber = rs.getString("user_card_number");
                UserCardNoComboBox.addItem(userNumber);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailsLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        userInfoPanel = new javax.swing.JPanel();
        UserCardNoLabel = new javax.swing.JLabel();
        UserCardNoComboBox = new javax.swing.JComboBox<>();
        CustomerNameLabel = new javax.swing.JLabel();
        CustomerNameTextField = new javax.swing.JTextField();
        MonthlyPayLabel = new javax.swing.JLabel();
        MonthlyPayTextField = new javax.swing.JTextField();
        duePreviousLabel = new javax.swing.JLabel();
        duePreviousTextField = new javax.swing.JTextField();
        areaLabel = new javax.swing.JLabel();
        areaTextField = new javax.swing.JTextField();
        ConnectionDateLabel = new javax.swing.JLabel();
        ConnectionDateTextField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        fullPayPanel = new javax.swing.JPanel();
        fullPaySaveButton = new javax.swing.JButton();
        fullClearButton = new javax.swing.JButton();
        fullPayPaymentTextField = new javax.swing.JTextField();
        fullPayPaymentLabel = new javax.swing.JLabel();
        fullPayMonthLabel = new javax.swing.JLabel();
        fullPayMonthComboBox = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        DuePanel = new javax.swing.JPanel();
        duePaymentLabel = new javax.swing.JLabel();
        duePaymentTextField = new javax.swing.JTextField();
        totalDueLabel = new javax.swing.JLabel();
        totalDueTextField = new javax.swing.JTextField();
        PayButton = new javax.swing.JButton();
        dueClearButton = new javax.swing.JButton();
        dueMonthLabel = new javax.swing.JLabel();
        dueMonthComboBox = new javax.swing.JComboBox<>();
        midPanel = new javax.swing.JPanel();
        generateBillButton = new javax.swing.JButton();

        setClosable(true);

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        detailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailsLabel.setText("Cable Connection Bill");
        detailsLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        userInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        UserCardNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserCardNoLabel.setText("User Card No :");

        UserCardNoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        UserCardNoComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                UserCardNoComboBoxAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        UserCardNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserCardNoComboBoxActionPerformed(evt);
            }
        });

        CustomerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CustomerNameLabel.setText("Customer Name :");

        CustomerNameTextField.setEditable(false);

        MonthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MonthlyPayLabel.setText("Monthly Pay :");

        MonthlyPayTextField.setEditable(false);

        duePreviousLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        duePreviousLabel.setText("Previous Due :");

        duePreviousTextField.setEditable(false);

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        areaLabel.setText("Area :");

        areaTextField.setEditable(false);

        ConnectionDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ConnectionDateLabel.setText("Connection :");

        ConnectionDateTextField.setEditable(false);

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserCardNoLabel)
                    .addComponent(MonthlyPayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MonthlyPayTextField)
                    .addComponent(UserCardNoComboBox, 0, 150, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CustomerNameLabel)
                    .addComponent(duePreviousLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(duePreviousTextField)
                    .addComponent(CustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addComponent(areaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(areaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addComponent(ConnectionDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConnectionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserCardNoLabel)
                    .addComponent(UserCardNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerNameLabel)
                    .addComponent(CustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaLabel)
                    .addComponent(areaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ConnectionDateLabel)
                        .addComponent(ConnectionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MonthlyPayLabel)
                        .addComponent(MonthlyPayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(duePreviousLabel)
                        .addComponent(duePreviousTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fullPayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Full Pay", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        fullPaySaveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullPaySaveButton.setText("Paid");
        fullPaySaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPaySaveButtonActionPerformed(evt);
            }
        });

        fullClearButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullClearButton.setText("Clear");
        fullClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullClearButtonActionPerformed(evt);
            }
        });

        fullPayPaymentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPayPaymentTextFieldActionPerformed(evt);
            }
        });

        fullPayPaymentLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullPayPaymentLabel.setText("Payment :");

        fullPayMonthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullPayMonthLabel.setText("Month :");

        fullPayMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        javax.swing.GroupLayout fullPayPanelLayout = new javax.swing.GroupLayout(fullPayPanel);
        fullPayPanel.setLayout(fullPayPanelLayout);
        fullPayPanelLayout.setHorizontalGroup(
            fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPayPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fullPayPanelLayout.createSequentialGroup()
                        .addComponent(fullPaySaveButton)
                        .addGap(18, 18, 18)
                        .addComponent(fullClearButton)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fullPayPanelLayout.createSequentialGroup()
                        .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fullPayMonthLabel)
                            .addComponent(fullPayPaymentLabel))
                        .addGap(18, 18, 18)
                        .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fullPayMonthComboBox, 0, 140, Short.MAX_VALUE)
                            .addComponent(fullPayPaymentTextField))
                        .addGap(27, 27, 27))))
        );
        fullPayPanelLayout.setVerticalGroup(
            fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPayPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullPayMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullPayMonthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullPayPaymentLabel)
                    .addComponent(fullPayPaymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullPaySaveButton)
                    .addComponent(fullClearButton))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(fullPayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DuePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Due", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        duePaymentLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        duePaymentLabel.setText("Payment :");

        duePaymentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duePaymentTextFieldActionPerformed(evt);
            }
        });
        duePaymentTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duePaymentTextFieldKeyReleased(evt);
            }
        });

        totalDueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalDueLabel.setText("Total Due :");

        totalDueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDueTextFieldActionPerformed(evt);
            }
        });

        PayButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PayButton.setText("Pay");
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        dueClearButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dueClearButton.setText("Clear");
        dueClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueClearButtonActionPerformed(evt);
            }
        });

        dueMonthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dueMonthLabel.setText("Month :");

        dueMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        javax.swing.GroupLayout DuePanelLayout = new javax.swing.GroupLayout(DuePanel);
        DuePanel.setLayout(DuePanelLayout);
        DuePanelLayout.setHorizontalGroup(
            DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DuePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(PayButton)
                .addGap(18, 18, 18)
                .addComponent(dueClearButton)
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DuePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dueMonthLabel)
                    .addComponent(duePaymentLabel)
                    .addComponent(totalDueLabel))
                .addGap(23, 23, 23)
                .addGroup(DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalDueTextField)
                    .addComponent(dueMonthComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 162, Short.MAX_VALUE)
                    .addComponent(duePaymentTextField, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(19, 19, 19))
        );
        DuePanelLayout.setVerticalGroup(
            DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DuePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dueMonthLabel)
                    .addComponent(dueMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duePaymentLabel)
                    .addComponent(duePaymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalDueLabel)
                    .addComponent(totalDueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PayButton)
                    .addComponent(dueClearButton))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DuePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DuePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        midPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout midPanelLayout = new javax.swing.GroupLayout(midPanel);
        midPanel.setLayout(midPanelLayout);
        midPanelLayout.setHorizontalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        generateBillButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generateBillButton.setText("Generate Bill");
        generateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(midPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(generateBillButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(midPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addComponent(generateBillButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserCardNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserCardNoComboBoxActionPerformed

        String comboBox = UserCardNoComboBox.getSelectedItem().toString();

        String columnName = " final.user_card_number, final.first_name, final.last_name, final.area, final.connection_date, final.monthly_pay, IFNULL(sum(final.due),0) as total_due ";
        String tableName = " (SELECT cc.user_card_number, cc.first_name, cc.last_name, cc.area, cc.connection_date, cc.monthly_pay , (cc.monthly_pay-bill.total_pay) AS due\n"
                + "		, bill.month\n"
                + "	FROM(\n"
                + "		SELECT\n"
                + "			user_card_number\n"
                + "			, first_name\n"
                + "			, last_name\n"
                + "			, area\n"
                + "			, connection_date\n"
                + "			, monthly_pay\n"
                + "		FROM customer_cable\n"
                + "		-- WHERE user_card_number = 'B-124'\n"
                + "	) cc\n"
                + "	LEFT JOIN (\n"
                + "		SELECT\n"
                + "			ccd.user_card_number, SUM(ccd.pay) AS total_pay, ccd.month\n"
                + "		FROM cable_customer_due ccd\n"
                + "		GROUP BY ccd.user_card_number,ccd.month\n"
                + "	) bill ON (cc.user_card_number = bill.user_card_number)\n"
                + " ) final ";
        String whereCondition = " final.user_card_number = '" + comboBox + "'\n"
                + " GROUP BY final.user_card_number, final.first_name, final.last_name, final.area, final.connection_date, final.monthly_pay ";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            //Select * from customer_cable where user_card_number = '" + comboBox + "'
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                CustomerNameTextField.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                MonthlyPayTextField.setText(rs.getString("monthly_pay"));
                areaTextField.setText(rs.getString("area"));
                ConnectionDateTextField.setText(rs.getString("connection_date"));
                duePreviousTextField.setText(rs.getString("total_due"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_UserCardNoComboBoxActionPerformed

    private void fullPaySaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPaySaveButtonActionPerformed

        if (UserCardNoComboBox.getSelectedIndex() > 0) {
            if (fullPayMonthComboBox.getSelectedIndex() > 0) {
                if (!fullPayPaymentTextField.getText().equals("")) {
                    String userCardNo = UserCardNoComboBox.getSelectedItem().toString();
                    String month = fullPayMonthComboBox.getSelectedItem().toString();
                    Integer MonthlyPay = Integer.parseInt(MonthlyPayTextField.getText());
                    int payment = 0;
                    payment = Integer.parseInt(fullPayPaymentTextField.getText());
                    if (MonthlyPay.equals(payment)) {

                        String tableName = " cable_customer_due ";
                        String columnName = " user_card_number, pay, due, month, paid_or_not, entry_date ";
                        String values = "'" + userCardNo + "', '" + payment + "', 0, '" + month + "', 1, now() ";

                        try {
                            boolean AddPayment = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);

                            if (AddPayment) {
                                JOptionPane.showMessageDialog(null, "Payment Done");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error to Stroed");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Payment Must be same of Manthly Pay\n OR\n Go for Due");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Payment");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Month");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Card Id");
        }
    }//GEN-LAST:event_fullPaySaveButtonActionPerformed

    private void fullClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullClearButtonActionPerformed

        fullPayPaymentTextField.setText("");

    }//GEN-LAST:event_fullClearButtonActionPerformed

    private void UserCardNoComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_UserCardNoComboBoxAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_UserCardNoComboBoxAncestorAdded

    private void duePaymentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duePaymentTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duePaymentTextFieldActionPerformed

    private void fullPayPaymentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPayPaymentTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullPayPaymentTextFieldActionPerformed

    private void totalDueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalDueTextFieldActionPerformed

    private void dueClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueClearButtonActionPerformed
        duePaymentTextField.setText("");
        totalDueTextField.setText("");
    }//GEN-LAST:event_dueClearButtonActionPerformed

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed

        if (UserCardNoComboBox.getSelectedIndex() > 0) {
            if (dueMonthComboBox.getSelectedIndex() > 0) {
                if (!duePaymentTextField.getText().equals("")) {
                    String userCardNo = UserCardNoComboBox.getSelectedItem().toString();
                    String month = dueMonthComboBox.getSelectedItem().toString();
                    Integer MonthlyPay = Integer.parseInt(MonthlyPayTextField.getText());
                    int payment = 0;
                    int due = 0;
                    payment = Integer.parseInt(duePaymentTextField.getText());
                    due = Integer.parseInt(totalDueTextField.getText());
                    if (!MonthlyPay.equals(payment)) {

                        String tableName = " cable_customer_due ";
                        String columnName = " user_card_number, pay, due, month, paid_or_not, entry_date ";
                        String values = "'" + userCardNo + "', '" + payment + "', '"+due+"', '" + month + "', 0, now() ";
                        try {
                            boolean AddPayment = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                            if (AddPayment) {
                                JOptionPane.showMessageDialog(null, "Payment Done");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error to Stroed");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment Must be Less then Manthly Pay\n OR\n Go for Full Pay");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Payment");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Month");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Card Id");
        }


    }//GEN-LAST:event_PayButtonActionPerformed

    private void generateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillButtonActionPerformed

        BillGenerateCable bg = new BillGenerateCable();
        bg.setVisible(true);

    }//GEN-LAST:event_generateBillButtonActionPerformed

    private void duePaymentTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duePaymentTextFieldKeyReleased
        
        Integer monthlyPay = Integer.parseInt(MonthlyPayTextField.getText());
        Integer payment = Integer.parseInt(duePaymentTextField.getText());
        
        Integer due = monthlyPay - payment;
        totalDueTextField.setText(due.toString());
    }//GEN-LAST:event_duePaymentTextFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConnectionDateLabel;
    private javax.swing.JTextField ConnectionDateTextField;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JTextField CustomerNameTextField;
    private javax.swing.JPanel DuePanel;
    private javax.swing.JLabel MonthlyPayLabel;
    private javax.swing.JTextField MonthlyPayTextField;
    private javax.swing.JButton PayButton;
    private javax.swing.JComboBox<String> UserCardNoComboBox;
    private javax.swing.JLabel UserCardNoLabel;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JTextField areaTextField;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JButton dueClearButton;
    private javax.swing.JComboBox<String> dueMonthComboBox;
    private javax.swing.JLabel dueMonthLabel;
    private javax.swing.JLabel duePaymentLabel;
    private javax.swing.JTextField duePaymentTextField;
    private javax.swing.JLabel duePreviousLabel;
    private javax.swing.JTextField duePreviousTextField;
    private javax.swing.JButton fullClearButton;
    private javax.swing.JComboBox<String> fullPayMonthComboBox;
    private javax.swing.JLabel fullPayMonthLabel;
    private javax.swing.JPanel fullPayPanel;
    private javax.swing.JLabel fullPayPaymentLabel;
    private javax.swing.JTextField fullPayPaymentTextField;
    private javax.swing.JButton fullPaySaveButton;
    private javax.swing.JButton generateBillButton;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel midPanel;
    private javax.swing.JLabel totalDueLabel;
    private javax.swing.JTextField totalDueTextField;
    private javax.swing.JPanel userInfoPanel;
    // End of variables declaration//GEN-END:variables
}

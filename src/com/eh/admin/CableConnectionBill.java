package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dao.UpdateQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.BillGenerateCable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Emran Hossain
 */
public class CableConnectionBill extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean AddPayment;
    private boolean updateDue;

    public CableConnectionBill() {
        initComponents();
        LoadUserCardNoComboBox();
    }

    public void clearAll() {
        UserCardNoComboBox.setSelectedIndex(0);
        MonthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        CustomerNameTextField.setText("");
        areaTextField.setText("");
        MonthlyPayTextField.setText("");
        duePreviousTextField.setText("");
        ConnectionDateTextField.setText("");
        previousmonthlyDueTextField.setText("");
        PaymentTextField.setText("");
        dueTextField.setText("");
    }

    public void LoadUserCardNoComboBox() {

        String columnName = " concat(user_card_number,'~[',first_name, ' ', last_name,']') as user_card_number ";
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

    public void UpdateIndivisulDueTable(String userCardId) {
        try {
            DefaultTableModel model = (DefaultTableModel) indivisuldueTable.getModel();
            model.setRowCount(0);

            String columnName = " * ";
            String tableName = " (\n"
                    + "SELECT\n"
                    + "	d.user_card_number\n"
                    + "	,date(connection_date) as connection_date\n"
                    + "	,d.month\n"
                    + "  ,c.monthly_pay - sum(d.pay) as monthly_due\n"
                    + "	,c.monthly_pay\n"
                    + "	,sum(d.pay)\n"
                    + "	,sum(d.due) as total_due\n"
                    + "FROM cable_customer_due d\n"
                    + "left join customer_cable c on (d.user_card_number = c.user_card_number)\n"
                    + "group by user_card_number,  month\n"
                    + ") as temp ";
            String whereCondition = " monthly_due >0 and  user_card_number = '" + userCardId + "' ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            while (rs.next()) {
                String month = rs.getString("month");
                String monthly_due = rs.getString("monthly_due");
                model.addRow(new Object[]{month, monthly_due});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllDue.class.getName()).log(Level.SEVERE, null, ex);
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
        previousmonthlyDueTextField = new javax.swing.JTextField();
        previousmonthlyDueLabel = new javax.swing.JLabel();
        fullPayMonthLabel = new javax.swing.JLabel();
        MonthComboBox = new javax.swing.JComboBox<>();
        PaymentLabel = new javax.swing.JLabel();
        PaymentTextField = new javax.swing.JTextField();
        dueLabel = new javax.swing.JLabel();
        dueTextField = new javax.swing.JTextField();
        yearComboBox = new javax.swing.JComboBox<>();
        midPanel = new javax.swing.JPanel();
        generateBillButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        indivisuldueTable = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cable Bill");

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        detailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eh/admin/image/Cable-Bill.png"))); // NOI18N
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
        duePreviousLabel.setText("Total Due :");

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
            .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fullPayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Full Pay", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        fullPaySaveButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullPaySaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eh/admin/image/Save.png"))); // NOI18N
        fullPaySaveButton.setText("Paid");
        fullPaySaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPaySaveButtonActionPerformed(evt);
            }
        });

        fullClearButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eh/admin/image/Reset.png"))); // NOI18N
        fullClearButton.setText("Clear");
        fullClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullClearButtonActionPerformed(evt);
            }
        });

        previousmonthlyDueTextField.setEditable(false);

        previousmonthlyDueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        previousmonthlyDueLabel.setText("Previous Due :");

        fullPayMonthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullPayMonthLabel.setText("Month :");

        MonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        PaymentLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PaymentLabel.setText("Payment :");

        PaymentTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PaymentTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PaymentTextFieldKeyTyped(evt);
            }
        });

        dueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dueLabel.setText("Due :");

        dueTextField.setEditable(false);

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2016", "2017", "2018", "2019", "2020" }));
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fullPayPanelLayout = new javax.swing.GroupLayout(fullPayPanel);
        fullPayPanel.setLayout(fullPayPanelLayout);
        fullPayPanelLayout.setHorizontalGroup(
            fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fullPayPanelLayout.createSequentialGroup()
                        .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fullPayMonthLabel)
                            .addComponent(previousmonthlyDueLabel)
                            .addComponent(PaymentLabel)
                            .addComponent(dueLabel))
                        .addGap(18, 18, 18)
                        .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(previousmonthlyDueTextField)
                                .addComponent(PaymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fullPayPanelLayout.createSequentialGroup()
                                .addComponent(MonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(fullPayPanelLayout.createSequentialGroup()
                        .addComponent(fullPaySaveButton)
                        .addGap(18, 18, 18)
                        .addComponent(fullClearButton)
                        .addGap(26, 26, 26)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        fullPayPanelLayout.setVerticalGroup(
            fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullPayMonthLabel)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousmonthlyDueLabel)
                    .addComponent(previousmonthlyDueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentLabel)
                    .addComponent(PaymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dueLabel)
                    .addComponent(dueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullPaySaveButton)
                    .addComponent(fullClearButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        midPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout midPanelLayout = new javax.swing.GroupLayout(midPanel);
        midPanel.setLayout(midPanelLayout);
        midPanelLayout.setHorizontalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        generateBillButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generateBillButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eh/admin/image/Generate-bill.png"))); // NOI18N
        generateBillButton.setText("Generate Bill");
        generateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillButtonActionPerformed(evt);
            }
        });

        indivisuldueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Month", "Due"
            }
        ));
        jScrollPane1.setViewportView(indivisuldueTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateBillButton)
                .addGap(335, 335, 335))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(midPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(midPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(generateBillButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserCardNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserCardNoComboBoxActionPerformed
        System.out.println("user card combo");
        String[] comboBox1 = UserCardNoComboBox.getSelectedItem().toString().split("~");
        String comboBox = comboBox1[0];
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
            UpdateIndivisulDueTable(comboBox);
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
        System.out.println("pay button");
        if (UserCardNoComboBox.getSelectedIndex() > 0) {
            if (MonthComboBox.getSelectedIndex() > 0) {
                if (yearComboBox.getSelectedIndex() > 0) {
                    Integer payment = Integer.parseInt(PaymentTextField.getText());
                    Integer due = 0;
                    if (payment > 0) {
                        String[] comboBox1 = UserCardNoComboBox.getSelectedItem().toString().split("~");
                        String comboBox = comboBox1[0];
                        String month = MonthComboBox.getSelectedItem().toString();
                        String Year = yearComboBox.getSelectedItem().toString();
                        String date = month + "-" + Year;
                        due = Integer.parseInt(dueTextField.getText());
                        int paidornot;
                        if (due > 0) {
                            paidornot = 0;

                        } else {
                            paidornot = 1;

                        }
                        String tableName = " cable_customer_due ";
                        String columnName = " user_card_number, pay, due, month, paid_or_not, entry_date ";
                        String values = "'" + comboBox + "', '" + payment + "', '" + due + "', '" + date + "', '" + paidornot + "', now() ";
                        try {
                            AddPayment = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                        } catch (SQLException ex) {
                            Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (paidornot == 1) {
                            String tableN = " cable_customer_due ";
                            String columnNameANDcolumnValue = " paid_or_not = 1 ";
                            String whereCondition = "month = '" + date + "'";
                            try {
                                updateDue = UpdateQueryDao.updateQueryWithWhereClause(tableN, columnNameANDcolumnValue, whereCondition);
                            } catch (SQLException ex) {
                                Logger.getLogger(CableConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (AddPayment) {
                                if (updateDue) {
                                    JOptionPane.showMessageDialog(null, "Payment Done");
                                    UpdateIndivisulDueTable(comboBox);
                                    MonthComboBox.setSelectedIndex(0);
                                    yearComboBox.setSelectedIndex(0);
                                    previousmonthlyDueTextField.setText("");
                                    PaymentTextField.setText("");
                                    dueTextField.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error to Stroed");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Error to Stroed");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Payment Done");
                            UpdateIndivisulDueTable(comboBox);
                            MonthComboBox.setSelectedIndex(0);
                            yearComboBox.setSelectedIndex(0);
                            previousmonthlyDueTextField.setText("");
                            PaymentTextField.setText("");
                            dueTextField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Give Paid Amount");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Select Year");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Select Month");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Card Id");
        }
    }//GEN-LAST:event_fullPaySaveButtonActionPerformed

    private void fullClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullClearButtonActionPerformed
        System.out.println("clear");
        clearAll();
    }//GEN-LAST:event_fullClearButtonActionPerformed

    private void UserCardNoComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_UserCardNoComboBoxAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_UserCardNoComboBoxAncestorAdded

    private void generateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillButtonActionPerformed

        BillGenerateCable bg = new BillGenerateCable();
        bg.setVisible(true);

    }//GEN-LAST:event_generateBillButtonActionPerformed

    private void PaymentTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaymentTextFieldKeyReleased
        System.out.println("payment key released");
        if (!(MonthComboBox.getSelectedIndex() > 0 && yearComboBox.getSelectedIndex() > 0)) {
            JOptionPane.showMessageDialog(null, "Select Month or Year");
            PaymentTextField.setText("");
            return;
        }
        Integer MonthlyPay = Integer.parseInt(MonthlyPayTextField.getText());
        Integer previousMonthlyDue = Integer.parseInt(previousmonthlyDueTextField.getText());
        Integer due;//= Integer.parseInt(dueTextField.getText());
        Integer payment = Integer.parseInt(PaymentTextField.getText());;
        if (previousMonthlyDue > 0) {

            if (previousMonthlyDue >= payment) {
                due = previousMonthlyDue - payment;
                dueTextField.setText(due.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Give Value Correctly!");
                PaymentTextField.setText("");
                dueTextField.setText("");
            }
        } else {
            if (MonthlyPay >= payment) {
                due = MonthlyPay - payment;
                dueTextField.setText(due.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Give Value Correctly!");
                PaymentTextField.setText("");
                dueTextField.setText("");
            }
        }
    }//GEN-LAST:event_PaymentTextFieldKeyReleased

    private void PaymentTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaymentTextFieldKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_PaymentTextFieldKeyTyped

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        System.out.println("year combo =============");
        if (UserCardNoComboBox.getSelectedIndex() > 0) {
            if (MonthComboBox.getSelectedIndex() > 0) {
                String[] comboBox1 = UserCardNoComboBox.getSelectedItem().toString().split("~");
                String comboBox = comboBox1[0];
                String month = MonthComboBox.getSelectedItem().toString();
                String year = yearComboBox.getSelectedItem().toString();
                String date = month + "-" + year;

                String columnName = " d.user_card_number\n"
                        + "	,date(connection_date) as connection_date\n"
                        + "	,d.month\n"
                        + "	,d.paid_or_not\n"
                        + "  ,c.monthly_pay - sum(d.pay) as monthly_due\n"
                        + "	,c.monthly_pay\n"
                        + "	,sum(d.pay)\n"
                        + "	,sum(d.due) as total_due ";
                String tableName = " cable_customer_due d\n"
                        + "left join customer_cable c ";
                String onCondition = " (d.user_card_number = c.user_card_number) ";
                String whereCondition = "d.month = '" + date + "' and d.user_card_number = '" + comboBox + "' group by user_card_number,  month";
                String monthly_due = "0";
                int paidornot = 0;
                try {
                    conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCondition, whereCondition);
                    con = conrs.getCon();
                    pstm = conrs.getPstm();
                    rs = conrs.getRs();

                    while (rs.next()) {
                        monthly_due = rs.getString("monthly_due");
                        paidornot = rs.getInt("paid_or_not");
                    }
                    if (paidornot > 0) {
                        JOptionPane.showMessageDialog(null, "This month was paid already");
                        MonthComboBox.setSelectedIndex(0);
                        yearComboBox.setSelectedIndex(0);
                    } else if (paidornot < 0) {
                        JOptionPane.showMessageDialog(null, "This month was paid already");
                        MonthComboBox.setSelectedIndex(0);
                        yearComboBox.setSelectedIndex(0);
                    } else if (paidornot == 0) {
                        previousmonthlyDueTextField.setText(monthly_due);
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
            } else {
                JOptionPane.showMessageDialog(null, "Select Month!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User Card No!");
        }
    }//GEN-LAST:event_yearComboBoxActionPerformed
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConnectionDateLabel;
    private javax.swing.JTextField ConnectionDateTextField;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JTextField CustomerNameTextField;
    private javax.swing.JComboBox<String> MonthComboBox;
    private javax.swing.JLabel MonthlyPayLabel;
    private javax.swing.JTextField MonthlyPayTextField;
    private javax.swing.JLabel PaymentLabel;
    private javax.swing.JTextField PaymentTextField;
    private javax.swing.JComboBox<String> UserCardNoComboBox;
    private javax.swing.JLabel UserCardNoLabel;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JTextField areaTextField;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JLabel dueLabel;
    private javax.swing.JLabel duePreviousLabel;
    private javax.swing.JTextField duePreviousTextField;
    private javax.swing.JTextField dueTextField;
    private javax.swing.JButton fullClearButton;
    private javax.swing.JLabel fullPayMonthLabel;
    private javax.swing.JPanel fullPayPanel;
    private javax.swing.JButton fullPaySaveButton;
    private javax.swing.JButton generateBillButton;
    private javax.swing.JTable indivisuldueTable;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel midPanel;
    private javax.swing.JLabel previousmonthlyDueLabel;
    private javax.swing.JTextField previousmonthlyDueTextField;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}

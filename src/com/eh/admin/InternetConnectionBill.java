package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dao.UpdateQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.BillGenerateInternet;
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
public class InternetConnectionBill extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean AddPayment;
    private boolean updateDue;

    public InternetConnectionBill() {
        initComponents();
        LoadUserIdComboBox();
    }

    public void clearAll() {
        userIdComboBox.setSelectedIndex(0);
        CustomerNameTextField.setText("");
        areaTextField.setText("");
        MonthlyPayTextField.setText("");
        duePreviousTextField.setText("");
        ConnectionDateTextField.setText("");
        macAddressTextField.setText("");
        ipAddressTextField.setText("");
        MonthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        previousmonthlyDueTextField.setText("");
        PaymentTextField.setText("");
        dueTextField.setText("");
    }

    public void LoadUserIdComboBox() {

        String columnName = " concat(user_id,'~[',first_name,' ', last_name,']') as user_id ";
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
            Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void UpdateIndivisulDueTable(String userId) {
        try {
            DefaultTableModel model = (DefaultTableModel) indivisuldueTable.getModel();
            model.setRowCount(0);

            String columnName = " * ";
            String tableName = " (\n"
                    + "SELECT\n"
                    + "	d.user_id\n"
                    + "	,date(connection_date) as connection_date\n"
                    + "	,d.month\n"
                    + "  ,c.monthly_pay - sum(d.pay) as monthly_due\n"
                    + "	,c.monthly_pay\n"
                    + "	,sum(d.pay)\n"
                    + "	,sum(d.due) as total_due\n"
                    + "FROM internet_customer_due d\n"
                    + "left join customer_internet c on (d.user_id = c.user_id)\n"
                    + "group by user_id,  month\n"
                    + ") as temp ";
            String whereCondition = " monthly_due >0 and  user_id = '" + userId + "' ";

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
                System.out.println(ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailsLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        UserIdLabel = new javax.swing.JLabel();
        userIdComboBox = new javax.swing.JComboBox<>();
        CustomerNameLabel = new javax.swing.JLabel();
        CustomerNameTextField = new javax.swing.JTextField();
        areaTextField = new javax.swing.JTextField();
        areaLabel = new javax.swing.JLabel();
        MonthlyPayLabel = new javax.swing.JLabel();
        MonthlyPayTextField = new javax.swing.JTextField();
        duePreviousTextField = new javax.swing.JTextField();
        duePreviousLabel = new javax.swing.JLabel();
        ConnectionDateLabel = new javax.swing.JLabel();
        ConnectionDateTextField = new javax.swing.JTextField();
        macAddressLabel = new javax.swing.JLabel();
        macAddressTextField = new javax.swing.JTextField();
        ipAddressLabel = new javax.swing.JLabel();
        ipAddressTextField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        fullPayPanel = new javax.swing.JPanel();
        fullPaySaveButton = new javax.swing.JButton();
        fullClearButton = new javax.swing.JButton();
        dueTextField = new javax.swing.JTextField();
        PaymentTextField = new javax.swing.JTextField();
        dueLabel = new javax.swing.JLabel();
        PaymentLabel = new javax.swing.JLabel();
        previousmonthlyDueLabel = new javax.swing.JLabel();
        fullPayMonthLabel = new javax.swing.JLabel();
        MonthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        previousmonthlyDueTextField = new javax.swing.JTextField();
        midPanel = new javax.swing.JPanel();
        generateBillButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        indivisuldueTable = new javax.swing.JTable();

        setClosable(true);

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        detailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailsLabel.setText("Internet Connection Bill");
        detailsLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        UserIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserIdLabel.setText("User Id :");

        userIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        userIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdComboBoxActionPerformed(evt);
            }
        });

        CustomerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CustomerNameLabel.setText("Customer Name :");

        CustomerNameTextField.setEditable(false);

        areaTextField.setEditable(false);

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        areaLabel.setText("Area :");

        MonthlyPayLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MonthlyPayLabel.setText("Monthly Pay :");

        MonthlyPayTextField.setEditable(false);

        duePreviousTextField.setEditable(false);

        duePreviousLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        duePreviousLabel.setText("Total Due :");

        ConnectionDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ConnectionDateLabel.setText("Connection :");

        ConnectionDateTextField.setEditable(false);

        macAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        macAddressLabel.setText("MAC Address :");

        macAddressTextField.setEditable(false);

        ipAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ipAddressLabel.setText("IP Address :");

        ipAddressTextField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(macAddressLabel)
                    .addComponent(MonthlyPayLabel)
                    .addComponent(UserIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MonthlyPayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CustomerNameLabel)
                            .addComponent(duePreviousLabel)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(macAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipAddressLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(duePreviousTextField)
                    .addComponent(CustomerNameTextField)
                    .addComponent(ipAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(ConnectionDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConnectionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(areaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UserIdLabel)
                        .addComponent(userIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CustomerNameLabel)
                        .addComponent(CustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MonthlyPayLabel)
                    .addComponent(MonthlyPayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duePreviousLabel)
                    .addComponent(duePreviousTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConnectionDateLabel)
                    .addComponent(ConnectionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(macAddressLabel)
                    .addComponent(macAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipAddressLabel)
                    .addComponent(ipAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        dueTextField.setEditable(false);

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

        PaymentLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PaymentLabel.setText("Payment :");

        previousmonthlyDueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        previousmonthlyDueLabel.setText("Previous Due :");

        fullPayMonthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fullPayMonthLabel.setText("Month :");

        MonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2016", "2017", "2018", "2019", "2020" }));
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        previousmonthlyDueTextField.setEditable(false);
        previousmonthlyDueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousmonthlyDueTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fullPayPanelLayout = new javax.swing.GroupLayout(fullPayPanel);
        fullPayPanel.setLayout(fullPayPanelLayout);
        fullPayPanelLayout.setHorizontalGroup(
            fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPayPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
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
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fullPayPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fullPaySaveButton)
                .addGap(18, 18, 18)
                .addComponent(fullClearButton)
                .addGap(59, 59, 59))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fullPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullPaySaveButton)
                    .addComponent(fullClearButton))
                .addContainerGap(34, Short.MAX_VALUE))
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
            .addGap(0, 113, Short.MAX_VALUE)
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        generateBillButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(midPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(generateBillButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(midPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(generateBillButton)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdComboBoxActionPerformed

        String[] comboBox1 = userIdComboBox.getSelectedItem().toString().split("~");
        String comboBox = comboBox1[0];

        String columnName = " final.user_id, final.first_name, final.last_name, final.mac_address_id, final.ip_address_id, final.area, final.connection_date, final.monthly_pay, IFNULL(sum(final.due),0) as total_due ";
        String tableName = " (SELECT cc.user_id, cc.first_name, cc.last_name, cc.area, cc.mac_address_id, cc.ip_address_id, cc.connection_date, cc.monthly_pay , (cc.monthly_pay-bill.total_pay) AS due\n"
                + "		, bill.month\n"
                + "	FROM(	\n"
                + "		SELECT \n"
                + "			user_id\n"
                + "			, first_name\n"
                + "			, last_name\n"
                + "			, mac_address_id\n"
                + "			, ip_address_id\n"
                + "			, area\n"
                + "			, connection_date\n"
                + "			, monthly_pay\n"
                + "		FROM customer_internet\n"
                + "		-- WHERE user_card_number = '121eq'\n"
                + "	) cc\n"
                + "	LEFT JOIN (\n"
                + "		SELECT\n"
                + "		  ccd.user_id, SUM(ccd.pay) AS total_pay, ccd.month\n"
                + "		FROM internet_customer_due ccd\n"
                + "		GROUP BY ccd.user_id,ccd.month\n"
                + "	) bill ON (cc.user_id = bill.user_id)\n"
                + ") final ";
        String whereCondition = " final.user_id = '" + comboBox + "'\n"
                + "GROUP BY final.user_id, final.first_name, final.last_name, final.mac_address_id, final.ip_address_id, final.area, final.connection_date, final.monthly_pay ";

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
                macAddressTextField.setText(rs.getString("mac_address_id"));
                ipAddressTextField.setText(rs.getString("ip_address_id"));
            }
            UpdateIndivisulDueTable(comboBox);
        } catch (SQLException ex) {
            Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_userIdComboBoxActionPerformed

    private void generateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillButtonActionPerformed

        BillGenerateInternet bgi = new BillGenerateInternet();
        bgi.setVisible(true);
    }//GEN-LAST:event_generateBillButtonActionPerformed

    private void fullPaySaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPaySaveButtonActionPerformed

        if (userIdComboBox.getSelectedIndex() > 0) {
            if (MonthComboBox.getSelectedIndex() > 0) {
                if (yearComboBox.getSelectedIndex() > 0) {
                    Integer payment = Integer.parseInt(PaymentTextField.getText());
                    Integer due = 0;
                    if (payment > 0) {
                        String[] comboBox1 = userIdComboBox.getSelectedItem().toString().split("~");
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
                        String tableName = " internet_customer_due ";
                        String columnName = " user_id, pay, due, month, paid_or_not, entry_date ";
                        String values = "'" + comboBox + "', '" + payment + "', '" + due + "', '" + date + "', '" + paidornot + "', now() ";
                        try {
                            AddPayment = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                        } catch (SQLException ex) {
                            Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (paidornot == 1) {
                            String tableN = " internet_customer_due ";
                            String columnNameANDcolumnValue = " paid_or_not = 1 ";
                            String whereCondition = "month = '" + date + "'";
                            try {
                                updateDue = UpdateQueryDao.updateQueryWithWhereClause(tableN, columnNameANDcolumnValue, whereCondition);
                            } catch (SQLException ex) {
                                Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (!AddPayment) {
                                if (!updateDue) {
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
        clearAll();
    }//GEN-LAST:event_fullClearButtonActionPerformed

    private void PaymentTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaymentTextFieldKeyReleased
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
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        System.out.println("hello =============");
        if (userIdComboBox.getSelectedIndex() > 0) {
            if (MonthComboBox.getSelectedIndex() > 0) {
                String[] comboBox1 = userIdComboBox.getSelectedItem().toString().split("~");
                String userId = comboBox1[0];
                String month = MonthComboBox.getSelectedItem().toString();
                String year = yearComboBox.getSelectedItem().toString();
                String columnName = " d.user_id\n"
                        + "	,date(connection_date) as connection_date\n"
                        + "	,d.month\n"
                        + "	,d.paid_or_not\n"
                        + "  ,c.monthly_pay - sum(d.pay) as monthly_due\n"
                        + "	,c.monthly_pay\n"
                        + "	,sum(d.pay)\n"
                        + "	,sum(d.due) as total_due ";
                String tableName = " internet_customer_due d\n"
                        + "left join customer_internet c ";
                String onCondition = " (d.user_id = c.user_id) ";
                String whereCondition = "d.month = '" + month + "-" + year + "' and d.user_id = '" + userId + "' group by user_id,  month";
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
                    Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        con.close();
                        pstm.close();
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(InternetConnectionBill.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Month!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "User Card No!");
        }
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void previousmonthlyDueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousmonthlyDueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_previousmonthlyDueTextFieldActionPerformed


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
    private javax.swing.JLabel UserIdLabel;
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
    private javax.swing.JLabel ipAddressLabel;
    private javax.swing.JTextField ipAddressTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel macAddressLabel;
    private javax.swing.JTextField macAddressTextField;
    private javax.swing.JPanel midPanel;
    private javax.swing.JLabel previousmonthlyDueLabel;
    private javax.swing.JTextField previousmonthlyDueTextField;
    private javax.swing.JComboBox<String> userIdComboBox;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}

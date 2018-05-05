package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.awt.print.PrinterException;
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
public class EmployeeSalary extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private conRs conrs1;
    private Connection con1;
    private PreparedStatement pstm1;
    private ResultSet rs1;

    public EmployeeSalary() {
        initComponents();
        loadEmpIdCombo();
    }

    public void clearAll() {
        employeeIdComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        employeeNameTextField.setText("");
        phoneNoTextField.setText("");
        emailTextField.setText("");
        joinDateTextField.setText("");
        salaryTextField.setText("");
        bonusTextField.setText("");
        extraTextField.setText("");
        advanceTextField.setText("");
        totalTextField.setText("");
        formatedTextArea.setText("");
    }

    public void loadEmpIdCombo() {

        String columnName = " concat(employee_id,'~[',first_name,' ', last_name,']') as employee_id ";
        String tableName = " employee ";
        String whereCondition = " is_active = '1' ORDER BY employee_id ASC ";
        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String EmployeeId = rs.getString("employee_id");
                employeeIdComboBox.addItem(EmployeeId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        printButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        employeeIdComboBox = new javax.swing.JComboBox<>();
        totalTextField = new javax.swing.JTextField();
        EmployeeNameLabel = new javax.swing.JLabel();
        totalButton = new javax.swing.JButton();
        employeeNameTextField = new javax.swing.JTextField();
        advanceLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        advanceTextField = new javax.swing.JTextField();
        phoneNoTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        JoinDateLabel = new javax.swing.JLabel();
        joinDateTextField = new javax.swing.JTextField();
        startingSalaryLabel = new javax.swing.JLabel();
        salaryTextField = new javax.swing.JTextField();
        monthLabel = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        bonusLabel = new javax.swing.JLabel();
        bonusTextField = new javax.swing.JTextField();
        extraLabel = new javax.swing.JLabel();
        extraTextField = new javax.swing.JTextField();
        EmployeeIdLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        formatedTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        yearComboBox = new javax.swing.JComboBox<>();

        setClosable(true);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setText("Total :");

        employeeIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        employeeIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdComboBoxActionPerformed(evt);
            }
        });

        totalTextField.setEditable(false);
        totalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTextFieldActionPerformed(evt);
            }
        });

        EmployeeNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EmployeeNameLabel.setText("Employee Name :");

        totalButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalButton.setText("Total");
        totalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalButtonActionPerformed(evt);
            }
        });

        employeeNameTextField.setEditable(false);

        advanceLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        advanceLabel.setText("Advance :");

        phoneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phoneLabel.setText("Phone No :");

        advanceTextField.setEditable(false);

        phoneNoTextField.setEditable(false);
        phoneNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoTextFieldActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setText("Email :");

        emailTextField.setEditable(false);

        JoinDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JoinDateLabel.setText("Join Date :");

        joinDateTextField.setEditable(false);

        startingSalaryLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        startingSalaryLabel.setText("Starting Salary :");

        salaryTextField.setEditable(false);
        salaryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTextFieldActionPerformed(evt);
            }
        });

        monthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        monthLabel.setText("Month :");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        bonusLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bonusLabel.setText("Bonus :");

        extraLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        extraLabel.setText("Extra :");

        EmployeeIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EmployeeIdLabel.setText("Employee Id :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee Salary");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        formatedTextArea.setEditable(false);
        formatedTextArea.setColumns(20);
        formatedTextArea.setRows(5);
        jScrollPane1.setViewportView(formatedTextArea);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("Add Record");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setText("Save Data");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2016", "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmployeeNameLabel)
                            .addComponent(EmployeeIdLabel)
                            .addComponent(phoneLabel)
                            .addComponent(emailLabel)
                            .addComponent(JoinDateLabel)
                            .addComponent(bonusLabel)
                            .addComponent(extraLabel)
                            .addComponent(monthLabel)
                            .addComponent(advanceLabel)
                            .addComponent(startingSalaryLabel)
                            .addComponent(totalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(joinDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(emailTextField)
                            .addComponent(phoneNoTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeIdComboBox, 0, 182, Short.MAX_VALUE)
                            .addComponent(salaryTextField)
                            .addComponent(bonusTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(extraTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advanceTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(totalButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearButton))
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployeeIdLabel)
                            .addComponent(employeeIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployeeNameLabel)
                            .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JoinDateLabel)
                            .addComponent(joinDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startingSalaryLabel)
                            .addComponent(salaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bonusLabel)
                            .addComponent(bonusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(extraLabel)
                            .addComponent(extraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthLabel)
                            .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(advanceLabel)
                            .addComponent(advanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabel))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalButton)
                            .addComponent(clearButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(printButton)
                            .addComponent(saveButton))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdComboBoxActionPerformed
        String[] comboBox1 = employeeIdComboBox.getSelectedItem().toString().split("~");
        String comboBox = comboBox1[0];

        String columnName = " * ";
        String tableName = " employee ";
        String whereCondition = " employee_id = '" + comboBox + "'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                employeeNameTextField.setText(first_name + last_name);
                String phone_no = rs.getString("phone_no");
                phoneNoTextField.setText(phone_no);
                String email = rs.getString("email");
                emailTextField.setText(email);
                String joinDate = rs.getString("join_date");
                joinDateTextField.setText(joinDate);
                String salary = rs.getString("starting_salary");
                salaryTextField.setText(salary);
            }

            columnName = " SUM(advance) AS total ";
            tableName = " employee_advance ";
            whereCondition = " employee_id = '" + comboBox + "'";

            conrs1 = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);
            con1 = conrs1.getCon();
            pstm1 = conrs1.getPstm();
            rs1 = conrs1.getRs();

            while (rs1.next()) {
                String advance = rs1.getString("total");
                advanceTextField.setText(advance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
                con1.close();
                pstm1.close();
                rs1.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_employeeIdComboBoxActionPerformed

    private void totalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTextFieldActionPerformed

    }//GEN-LAST:event_totalTextFieldActionPerformed

    private void totalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalButtonActionPerformed

        Integer salary = Integer.parseInt(salaryTextField.getText());
        Integer bonus = 0;
        Integer extra = 0;
        Integer advance = 0;
        Integer total = 0;

        if (bonusTextField.getText().equals("")) {
            bonus = 0;
        } else {
            bonus = Integer.parseInt(bonusTextField.getText());
        }
        if (extraTextField.getText().equals("")) {
            extra = 0;
        } else {
            extra = Integer.parseInt(extraTextField.getText());
        }
        if (advanceTextField.getText().equals("")) {
            advance = 0;
        } else {
            advance = Integer.parseInt(advanceTextField.getText());
        }
        total = salary + bonus + extra - advance;

        totalTextField.setText(total.toString());

        System.out.println(bonus);
        System.out.println(extra);
        System.out.println(advance);
    }//GEN-LAST:event_totalButtonActionPerformed

    private void salaryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTextFieldActionPerformed

    private void phoneNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearAll();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        try {
            formatedTextArea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_printButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (employeeIdComboBox.getSelectedIndex() > 0) {
            if (monthComboBox.getSelectedIndex() > 0) {
            if (yearComboBox.getSelectedIndex() > 0) {
                if (!totalTextField.equals("")) {
                    formatedTextArea.setText(null);
                    formatedTextArea.append("\t\t Employee Payment \n\n"
                            + "Employee Name :\t\t" + employeeNameTextField.getText()
                            + "\n===================================================\n"
                            + "Phone No :\t\t\t" + phoneNoTextField.getText() + "\n\n"
                            + "Email :\t\t\t" + emailTextField.getText() + "\n\n"
                            + "Join Date :\t\t\t" + joinDateTextField.getText() + "\n\n"
                            + "Salary :\t\t\t" + salaryTextField.getText() + "\n\n"
                            + "Bonus :\t\t\t" + bonusTextField.getText() + "\n\n"
                            + "Extra :\t\t\t" + extraTextField.getText() + "\n\n"
                            + "Month :\t\t\t" + monthComboBox.getSelectedItem().toString()+"-"+yearComboBox.getSelectedItem().toString() + "\n\n"
                            + "Advance :\t\t\t" + advanceTextField.getText() + "\n\n"
                            + "\n====================================================\n"
                            + "Total :\t\t\t" + totalTextField.getText() + "\n\n"
                    );
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate Total");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Year");
            }
                
            } else {
                JOptionPane.showMessageDialog(null, "Select Month");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Employee Id");
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String[] comboBox1 = employeeIdComboBox.getSelectedItem().toString().split("~");
	String empId  = comboBox1[0];
        String month = monthComboBox.getSelectedItem().toString();
        String year = yearComboBox.getSelectedItem().toString();
        String salary = salaryTextField.getText();
        String bonus = bonusTextField.getText();
        String extra = extraTextField.getText();
        String advance = advanceTextField.getText();

        if (employeeIdComboBox.getSelectedIndex() > 0) {
            if (monthComboBox.getSelectedIndex() > 0) {
                if (yearComboBox.getSelectedIndex() > 0) {
                    String tableName = " employee_salary ";
                    String columnName = " employee_id, salary_month, current_salary, bonus, extra, advance, salary_payment_date ";
                    String values = "'" + empId + "', '" + month+"-"+year + "', '" + salary + "', '" + bonus + "', '" + extra + "', '" + advance + "', now() ";
                    boolean addEmployeeSalary = false;
                    try {
                        addEmployeeSalary = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    tableName = " employee_salary_month ";
                    columnName = " month_name, entry_time, employee_id ";
                    values = "'" + month+"-"+year + "', now(), '" + empId + "' ";

                    boolean addEmployeeSalaryMonth = false;
                    try {
                        addEmployeeSalaryMonth = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeSalary.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (addEmployeeSalary) {
                        if (addEmployeeSalaryMonth) {
                            JOptionPane.showMessageDialog(null, "Data Stored");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error to handle data");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error to handle data");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Select Year");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Month");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Employee Id");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmployeeIdLabel;
    private javax.swing.JLabel EmployeeNameLabel;
    private javax.swing.JLabel JoinDateLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel advanceLabel;
    private javax.swing.JTextField advanceTextField;
    private javax.swing.JLabel bonusLabel;
    private javax.swing.JTextField bonusTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> employeeIdComboBox;
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JLabel extraLabel;
    private javax.swing.JTextField extraTextField;
    private javax.swing.JTextArea formatedTextArea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField joinDateTextField;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneNoTextField;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel startingSalaryLabel;
    private javax.swing.JButton totalButton;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}

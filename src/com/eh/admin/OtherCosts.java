package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OtherCosts extends javax.swing.JInternalFrame {

    public OtherCosts() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        expenseNameLabel = new javax.swing.JLabel();
        expenseNameTextField = new javax.swing.JTextField();
        expenseAmountLabel = new javax.swing.JLabel();
        expenseAmountTextField = new javax.swing.JTextField();
        detailsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Other Costs");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        expenseNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        expenseNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expenseNameLabel.setText("Expense Name :");

        expenseAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        expenseAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expenseAmountLabel.setText("Expense Amount :");

        expenseAmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expenseAmountTextFieldKeyTyped(evt);
            }
        });

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailsLabel.setText("Details :");

        detailsTextArea.setColumns(20);
        detailsTextArea.setRows(5);
        jScrollPane1.setViewportView(detailsTextArea);

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(expenseAmountLabel)
                            .addComponent(expenseNameLabel)
                            .addComponent(detailsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(expenseNameTextField)
                            .addComponent(expenseAmountTextField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expenseNameLabel)
                    .addComponent(expenseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expenseAmountLabel)
                    .addComponent(expenseAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(resetButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        expenseNameTextField.setText("");
        expenseAmountTextField.setText("");
        detailsTextArea.setText("");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if (!expenseNameTextField.equals("")) {
            if (!expenseAmountTextField.equals("")) {
                String expenseName = expenseNameTextField.getText();
                String expenseAmount = expenseAmountTextField.getText();
                String details = detailsTextArea.getText();

                String tableName = " income_cost ";
                String columnName = " type, name, amount, details, input_date ";
                String values = "'OtherExpense', '" + expenseName + "', '" + expenseAmount + "', '" + details + "', now() ";
                try {
                    boolean AddIncomeCost = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                    if (!AddIncomeCost) {
                        JOptionPane.showMessageDialog(null, "Cost Not Added");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cost Added");
                        expenseNameTextField.setText("");
                        expenseAmountTextField.setText("");
                        detailsTextArea.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(OtherCosts.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Give Amount");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Give Name");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void expenseAmountTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expenseAmountTextFieldKeyTyped
        char ch = evt.getKeyChar();
        if (!isNumber(ch) && ch != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_expenseAmountTextFieldKeyTyped
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JTextArea detailsTextArea;
    private javax.swing.JLabel expenseAmountLabel;
    private javax.swing.JTextField expenseAmountTextField;
    private javax.swing.JLabel expenseNameLabel;
    private javax.swing.JTextField expenseNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}

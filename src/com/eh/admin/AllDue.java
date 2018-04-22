package com.eh.admin;

import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AllDue extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public AllDue() {
        initComponents();
        UpdateCableDueTable();
        UpdateInternetDueTable();
    }

    public void UpdateCableDueTable() {
        try {

            String columnName = " ccd.user_card_number, ccd.pay, ccd.due, ccd.entry_date, cc.first_name, cc.last_name ";
            String tableName = " cable_customer_due ccd left join customer_cable cc ";
            String onCondition = "(ccd.user_card_number =cc.user_card_number)";

            conrs = SelectQueryDao.selectQueryWithJoinClause(columnName, tableName, onCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) cableDueTable.getModel();
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_card_number = rs.getString("user_card_number");
                Integer pay = Integer.parseInt(rs.getString("pay"));
                Integer due = Integer.parseInt(rs.getString("due"));
                String entryDate = rs.getString("entry_date");
                model.addRow(new Object[]{user_card_number, first_name + " " + last_name, pay, due, entryDate});
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
    
    public void UpdateInternetDueTable() {
        try {

            String columnName = " icd.user_id, icd.pay, icd.due, icd.entry_date, ci.first_name, ci.last_name ";
            String tableName = " internet_customer_due icd left join customer_internet ci ";
            String onCondition = " (icd.user_id =ci.user_id) ";

            conrs = SelectQueryDao.selectQueryWithJoinClause(columnName, tableName, onCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) InternetDueTable.getModel();
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_id = rs.getString("user_id");
                Integer pay = Integer.parseInt(rs.getString("pay"));
                Integer due = Integer.parseInt(rs.getString("due"));
                String entryDate = rs.getString("entry_date");
                model.addRow(new Object[]{user_id, first_name + " " + last_name, pay, due, entryDate});
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

        cabledueLabel = new javax.swing.JLabel();
        internetdueLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cableDueTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InternetDueTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cpButton = new javax.swing.JButton();

        setClosable(true);

        cabledueLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        cabledueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabledueLabel.setText("Cable Due List");
        cabledueLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        internetdueLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        internetdueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        internetdueLabel.setText("Internet Due List");
        internetdueLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cableDueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Card Number", "Customer Name", "Pay", "Due", "Pay Date"
            }
        ));
        jScrollPane1.setViewportView(cableDueTable);

        InternetDueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "CustomerName", "Pay", "Due", "Pay Date"
            }
        ));
        jScrollPane2.setViewportView(InternetDueTable);

        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cpButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cpButton.setText("Print");
        cpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(cpButton)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(cabledueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(internetdueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cabledueLabel)
                    .addComponent(internetdueLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cpButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpButtonActionPerformed
       
    }//GEN-LAST:event_cpButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InternetDueTable;
    private javax.swing.JTable cableDueTable;
    private javax.swing.JLabel cabledueLabel;
    private javax.swing.JButton cpButton;
    private javax.swing.JLabel internetdueLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

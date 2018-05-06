package com.eh.admin;

import com.eh.dbconnection.DBConnection;
import java.awt.print.PrinterException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Emran Hossain
 */
public class Account extends javax.swing.JInternalFrame {

    private Date sdate;
    private Date edate;
    private SimpleDateFormat dateFormat;
    private String startDate;
    private String endDate;
    static DBConnection db = new DBConnection();
    static Connection con;
    static ResultSet rs;
    static CallableStatement cs = null;

    public Account() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateLabel = new javax.swing.JLabel();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        searchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Accounting");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        startDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        startDateLabel.setText("Start Date :");

        endDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        endDateLabel.setText("End Date :");

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TYPE", "USER_CARD_NUMBER", "NAME", "ADJUSTED_ADVANCED", "AMOUNT", "INCOME/EXPANCE"
            }
        ));
        jScrollPane2.setViewportView(reportTable);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(startDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(endDateLabel)
                                .addGap(18, 18, 18)
                                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startDateLabel)
                    .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel)
                    .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        sdate = startDateChooser.getDate();
        edate = endDateChooser.getDate();
        if (sdate != null) {
            if (edate != null) {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                startDate = dateFormat.format(sdate);
                endDate = dateFormat.format(edate);
                //                System.out.println("Start Date :" + startDate + "\n End Date :" + endDate);
                String sType = "";
                String sIorLoss = "";
                int iMarker = 0;
                double dSub_total = 0;
                double dsIorLoss = 0;
                try {
                    con = db.myConn();
                    cs = con.prepareCall("{CALL full_blance('" + startDate + "', '" + endDate + "')}");
                    rs = cs.executeQuery();

                    DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        String TYPE = rs.getString("TYPE");
                        String USER_CARD_NUMBER = rs.getString("USER_CARD_NUMBER");
                        String NAME = rs.getString("NAME");
                        double ADJUSTED_ADVANCED = rs.getDouble("ADJUSTED_ADVANCED");
                        double AMOUNT = rs.getDouble("AMOUNT");
                        String I = rs.getString("i");

                        if (!TYPE.equalsIgnoreCase(sType) && iMarker == 0) {
                            sType = TYPE;
                            model.addRow(new Object[]{"Details for " + TYPE, null, null, null, null});
                            iMarker = 1;
                        } else if (!TYPE.equalsIgnoreCase(sType) && iMarker == 1) {
                            dsIorLoss += dSub_total;
                            model.addRow(new Object[]{"Sub-Total for " + sType, null, null, null, dSub_total});
                            if (!rs.getString("i").equals(sIorLoss)) {
                                model.addRow(new Object[]{"Total " + sIorLoss.replaceAll("^[\\s\\.\\d]+", ""), null, null, null, dsIorLoss});
                                model.addRow(new Object[]{null, null, null, null, null});
                                model.addRow(new Object[]{null, null, null, null, null});
                                dsIorLoss = 0;
                            }
                            model.addRow(new Object[]{"Details for " + TYPE, null, null, null, null});
                            //                            sType = "";
                            //                            iMarker = 0;
                            dSub_total = 0;
                        }
                        sType = TYPE;
                        sIorLoss = I;
                        dSub_total += rs.getDouble("AMOUNT");
                        model.addRow(new Object[]{USER_CARD_NUMBER, NAME, ADJUSTED_ADVANCED, AMOUNT, null});
                    }
                    model.addRow(new Object[]{"Sub-Total for " + sType, null, null, null, dSub_total});
                    model.addRow(new Object[]{"Total " + sIorLoss.replaceAll("^[\\s\\.\\d]+", ""), null, null, null, dsIorLoss + dSub_total});
                } catch (SQLException ex) {
                    Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Select End Date");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Start Date");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            reportTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable reportTable;
    private javax.swing.JButton searchButton;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
}

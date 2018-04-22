package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.ShowAvailableIP;
import com.eh.details.ShowAvailableMAC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NewMACIP extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public NewMACIP() {
        initComponents();
        UpdateIPtable();
        UpdateMACtable();
    }
    
    public void UpdateIPtable() {
        try {

            String columnName = " ci.cus_internet_id, ci.user_id, ia.address ipaddress ";
            String tableName = " customer_internet ci left join ip_address ia ";
            String onCOndition = " (ci.ip_address_id = ia.ip_address_id) ";
            String whereCondition = " ci.is_active = '1' ";

            conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCOndition, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) ipTable.getModel();
            while (rs.next()) {
                String cus_internet_id = rs.getString("cus_internet_id");
                String user_id = rs.getString("user_id");
                String ipaddress = rs.getString("ipaddress");

                model.addRow(new Object[]{cus_internet_id, user_id, ipaddress});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewMACIP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void UpdateMACtable() {
        try {

            String columnName = " ci.cus_internet_id, ci.user_id, ma.address macaddress ";
            String tableName = " customer_internet ci left join mac_address ma ";
            String onCOndition = " (ci.mac_address_id = ma.mac_address_id) ";
            String whereCondition = " ci.is_active = '1' ";

            conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCOndition, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) macTable.getModel();
            while (rs.next()) {
                String cus_internet_id = rs.getString("cus_internet_id");
                String user_id = rs.getString("user_id");
                String macaddress = rs.getString("macaddress");

                model.addRow(new Object[]{cus_internet_id, user_id, macaddress});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewMACIP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MACAddress = new javax.swing.JLabel();
        macipLabel = new javax.swing.JLabel();
        macField = new javax.swing.JTextField();
        IPAddress = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        macButton = new javax.swing.JButton();
        ipButton = new javax.swing.JButton();
        availableMACButton = new javax.swing.JButton();
        availableIPButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        macTable = new javax.swing.JTable();
        row1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ipTable = new javax.swing.JTable();
        macLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();

        setClosable(true);

        MACAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MACAddress.setText("MAC Address :");

        macipLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        macipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        macipLabel.setText("Add MAC / IP Address");
        macipLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        IPAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IPAddress.setText("IP Address :");

        macButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        macButton.setText("Add MAC");
        macButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macButtonActionPerformed(evt);
            }
        });

        ipButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipButton.setText("Add IP");
        ipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipButtonActionPerformed(evt);
            }
        });

        availableMACButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        availableMACButton.setText("Available MAC");
        availableMACButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableMACButtonActionPerformed(evt);
            }
        });

        availableIPButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        availableIPButton1.setText("Available IP");
        availableIPButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableIPButton1ActionPerformed(evt);
            }
        });

        macTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer internet id", "User ID", "MAC Address"
            }
        ));
        jScrollPane1.setViewportView(macTable);

        row1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Internet Id", "User Id", "Address"
            }
        ));
        jScrollPane2.setViewportView(ipTable);

        macLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        macLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        macLabel.setText("Used MAC");
        macLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ipLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipLabel.setText("Used IP");
        ipLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(macButton)
                                .addGap(18, 18, 18)
                                .addComponent(availableMACButton))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(macLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(ipButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(availableIPButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(macipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(MACAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(macField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(IPAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(macipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IPAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MACAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(macField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(macButton)
                            .addComponent(ipButton)
                            .addComponent(availableMACButton)
                            .addComponent(availableIPButton1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(macLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(row1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void macButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macButtonActionPerformed

        String macAddress = macField.getText();

        if (!macAddress.equals("")) {

            try {
                String tableName = " mac_address ";
                String columnName = " address ";
                String values = "'" + macAddress + "'";
                boolean AddMAC = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                if (!AddMAC) {
                    JOptionPane.showMessageDialog(null, "MAC Not Inserted!");
                } else {
                    JOptionPane.showMessageDialog(null, "MAC Inserted Successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewMACIP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Insert MAC Address");
        }
    }//GEN-LAST:event_macButtonActionPerformed

    private void ipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipButtonActionPerformed
        
        String ipAddress = ipField.getText();

        if (!ipAddress.equals("")) {

            try {
                String tableName = " ip_address ";
                String columnName = " address ";
                String values = "'" + ipAddress + "'";
                boolean AddIP = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                if (!AddIP) {
                    JOptionPane.showMessageDialog(null, "IP Not Inserted!");
                } else {
                    JOptionPane.showMessageDialog(null, "IP Inserted Successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewMACIP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Insert IP Address");
        }
    }//GEN-LAST:event_ipButtonActionPerformed

    private void availableMACButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableMACButtonActionPerformed
        ShowAvailableMAC samac = new ShowAvailableMAC();
        samac.setVisible(true);
    }//GEN-LAST:event_availableMACButtonActionPerformed

    private void availableIPButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableIPButton1ActionPerformed
        ShowAvailableIP saip = new ShowAvailableIP();
        saip.setVisible(true);
    }//GEN-LAST:event_availableIPButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IPAddress;
    private javax.swing.JLabel MACAddress;
    private javax.swing.JButton availableIPButton1;
    private javax.swing.JButton availableMACButton;
    private javax.swing.JButton ipButton;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTable ipTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton macButton;
    private javax.swing.JTextField macField;
    private javax.swing.JLabel macLabel;
    private javax.swing.JTable macTable;
    private javax.swing.JLabel macipLabel;
    private javax.swing.JLabel row1;
    // End of variables declaration//GEN-END:variables
}

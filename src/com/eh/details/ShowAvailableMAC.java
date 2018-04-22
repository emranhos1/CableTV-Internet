package com.eh.details;

import com.eh.admin.NewMACIP;
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

public class ShowAvailableMAC extends javax.swing.JFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public ShowAvailableMAC() {
        initComponents();
        UpdateMACtable();
        setLocationRelativeTo(this);
        setResizable(false);
    }

    public void UpdateMACtable() {
        try {

            String columnName = " ma.mac_address_id, ma.address ";
            String tableName = " mac_address ma left Join customer_internet ci ";
            String onCondition = " (ma.mac_address_id = ci.mac_address_id) ";
            String whereCondition = " ma.mac_address_id not in (Select mac_address_id from customer_internet) ";

            conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCondition, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) macTable.getModel();
            while (rs.next()) {
                String mac_address_id = rs.getString("mac_address_id");
                String macAddress = rs.getString("address");

                model.addRow(new Object[]{mac_address_id, macAddress});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShowAvailableMAC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        macLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        macTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        macLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        macLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        macLabel.setText("Available MAC");
        macLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        macTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MAC address ID", "MAC Address"
            }
        ));
        jScrollPane1.setViewportView(macTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(macLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(macLabel)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowAvailableMAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowAvailableMAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowAvailableMAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowAvailableMAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowAvailableMAC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel macLabel;
    private javax.swing.JTable macTable;
    // End of variables declaration//GEN-END:variables
}

package com.eh.details;

import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Md. Emran Hossain
 */
public class DueInternetBill extends javax.swing.JFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ImageIcon icon = new ImageIcon("image/SKF1.jpg");
    public DueInternetBill() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        UpdateInternetDueTable();
        setTitle("SKF");
        setIconImage(icon.getImage());
    }

    public void UpdateInternetDueTable() {
        try {

            String columnName = " final.user_id, final.first_name, final.last_name, final.mac_address_id, final.ip_address_id, final.area, final.connection_date, final.monthly_pay, final.is_active, IFNULL(sum(final.due),0) as total_due ";
            String tableName = " (SELECT cc.user_id, cc.first_name, cc.last_name, cc.area, cc.mac_address_id, cc.ip_address_id, cc.connection_date, cc.monthly_pay , cc.is_active, (cc.monthly_pay-bill.total_pay) AS due\n" +
"		, bill.month\n" +
"	FROM(	\n" +
"		SELECT \n" +
"			user_id\n" +
"			, first_name\n" +
"			, last_name\n" +
"			, mac_address_id\n" +
"			, ip_address_id\n" +
"			, area\n" +
"			, connection_date\n" +
"			, monthly_pay\n" +
"			, is_active\n" +
"		FROM customer_internet\n" +
"		-- WHERE user_card_number = '121eq'\n" +
"	) cc\n" +
"	LEFT JOIN (\n" +
"		SELECT\n" +
"		  ccd.user_id, SUM(ccd.pay) AS total_pay, ccd.month\n" +
"		FROM internet_customer_due ccd\n" +
"		GROUP BY ccd.user_id,ccd.month\n" +
"	) bill ON (cc.user_id = bill.user_id)\n" +
") final WHERE final.is_active = '1' ";
            String groupBy = " final.user_id, final.first_name, final.last_name, final.mac_address_id, final.ip_address_id, final.area, final.connection_date, final.monthly_pay ORDER BY final.user_id ASC ";

            conrs = SelectQueryDao.selectQueryWithGroupBy(columnName, tableName, groupBy);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) InternetTable.getModel();
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_id = rs.getString("user_id");
                Integer monthlyPay = Integer.parseInt(rs.getString("monthly_pay"));
                Integer totalDue = Integer.parseInt(rs.getString("total_due"));
                String connectionDate = rs.getString("connection_date");
                model.addRow(new Object[]{user_id, first_name + " " + last_name, monthlyPay, totalDue, connectionDate});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DueInternetBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InternetTable = new javax.swing.JTable();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Internet Due Bill");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        InternetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "Customer Name", "Monthly Pay", "Total Due", "Connection Date"
            }
        ));
        jScrollPane1.setViewportView(InternetTable);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(printButton)
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        
        try {
            InternetTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(DueInternetBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DueInternetBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DueInternetBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DueInternetBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DueInternetBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DueInternetBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InternetTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
}

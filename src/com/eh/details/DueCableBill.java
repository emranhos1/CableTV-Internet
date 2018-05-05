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
public class DueCableBill extends javax.swing.JFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ImageIcon icon = new ImageIcon("image/SKF1.jpg");
    public DueCableBill() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        UpdateCableDueTable();
        setTitle("SKF");
        setIconImage(icon.getImage());
    }
    
    public void UpdateCableDueTable() {
        try {

            String columnName = " final.user_card_number, final.first_name, final.last_name, final.area, final.connection_date, final.monthly_pay, final.is_active, IFNULL(sum(final.due),0) as total_due ";
            String tableName = " (SELECT cc.user_card_number, cc.first_name, cc.last_name, cc.area, cc.connection_date, cc.monthly_pay ,cc.is_active, (cc.monthly_pay-bill.total_pay) AS due\n" +
"		, bill.month\n" +
"	FROM(\n" +
"		SELECT\n" +
"			user_card_number\n" +
"			, first_name\n" +
"			, last_name\n" +
"			, area\n" +
"			, connection_date\n" +
"			, monthly_pay\n" +
"			, is_active\n" +
"		FROM customer_cable\n" +
"		-- WHERE user_card_number = 'B-124'\n" +
"	) cc\n" +
"	LEFT JOIN (\n" +
"		SELECT\n" +
"			ccd.user_card_number, SUM(ccd.pay) AS total_pay, ccd.month\n" +
"		FROM cable_customer_due ccd\n" +
"		GROUP BY ccd.user_card_number,ccd.month\n" +
"	) bill ON (cc.user_card_number = bill.user_card_number)\n" +
" ) final WHERE final.is_active = '1' ";
            String groupBy = " final.user_card_number, final.first_name, final.last_name, final.area, final.connection_date, final.monthly_pay ORDER BY final.user_card_number ASC ";

            conrs = SelectQueryDao.selectQueryWithGroupBy(columnName, tableName, groupBy);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) cableTable.getModel();
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String user_card_number = rs.getString("user_card_number");
                Integer monthlyPay = Integer.parseInt(rs.getString("monthly_pay"));
                Integer totalDue = Integer.parseInt(rs.getString("total_due"));
                String connectionDate = rs.getString("connection_date");
                model.addRow(new Object[]{user_card_number, first_name + " " + last_name, monthlyPay, totalDue, connectionDate});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DueCableBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cableTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Card Number", "Customer Name", "Monthly Pay", "Total Due", "Connection Date"
            }
        ));
        jScrollPane1.setViewportView(cableTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eh/admin/image/Advance.png"))); // NOI18N
        jLabel1.setText("All Cable Due Bill");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        printButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eh/admin/image/Print.png"))); // NOI18N
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addComponent(printButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        
        try {
            cableTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(DueCableBill.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(DueCableBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DueCableBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DueCableBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DueCableBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DueCableBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cableTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
}

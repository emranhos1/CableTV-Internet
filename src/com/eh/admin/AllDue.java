package com.eh.admin;

import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.DueCableBill;
import com.eh.details.DueInternetBill;
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
            DefaultTableModel model = (DefaultTableModel) cableDueTable.getModel();
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
                Logger.getLogger(AllDue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            DefaultTableModel model = (DefaultTableModel) InternetDueTable.getModel();
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
        ipButton = new javax.swing.JButton();

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
                "User Card Number", "Customer Name", "Monthly Pay", "Total Due", "Connection  Date"
            }
        ));
        jScrollPane1.setViewportView(cableDueTable);

        InternetDueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "CustomerName", "Monthly Pay", "Total Due", "Connection Date"
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

        ipButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipButton.setText("Print");
        ipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ipButton)
                        .addGap(166, 166, 166))))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(ipButton)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpButtonActionPerformed
        
        DueCableBill dcb = new DueCableBill();
        dcb.setVisible(true);
    }//GEN-LAST:event_cpButtonActionPerformed

    private void ipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipButtonActionPerformed
        DueInternetBill dib = new DueInternetBill();
        dib.setVisible(true);
    }//GEN-LAST:event_ipButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InternetDueTable;
    private javax.swing.JTable cableDueTable;
    private javax.swing.JLabel cabledueLabel;
    private javax.swing.JButton cpButton;
    private javax.swing.JLabel internetdueLabel;
    private javax.swing.JButton ipButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

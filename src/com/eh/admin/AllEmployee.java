package com.eh.admin;

import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import com.eh.details.ShowEmployeeDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AllEmployee extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public AllEmployee() {
        initComponents();
        Update_table();
    }

    ShowEmployeeDetails sed = new ShowEmployeeDetails();

    public void Update_table() {
        try {

            String columnName = " e.employee_id, e.first_name, e.last_name, e.phone_no, e.email, e.area, e.address, e.join_date, e.starting_salary ";
            String tableName = " employee e left join admin a ";
            String onCOndition = " (e.employee_id = a.employee_id) left join role r on(a.role_id = r.role_id) ";
            String whereCondition = " e.employee_id > '1' ";

            conrs = SelectQueryDao.selectQueryWithJoinWhere(columnName, tableName, onCOndition, whereCondition);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();
            DefaultTableModel model = (DefaultTableModel) empTable.getModel();
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String phone_no = rs.getString("phone_no");
                String email = rs.getString("email");
                String area = rs.getString("area");
                String address = rs.getString("address");
                String join_date = rs.getString("join_date");
                String starting_salary = rs.getString("starting_salary");

                model.addRow(new Object[]{employee_id, first_name + " " + last_name, phone_no, email, address, area, join_date, starting_salary});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        allEmployeeLabel = new javax.swing.JLabel();

        setClosable(true);

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Id", "Employee Name", "Phone No", "Email", "Address", "Area", "Join Date", "Starting Salary"
            }
        ));
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(empTable);

        allEmployeeLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        allEmployeeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allEmployeeLabel.setText("All Employee");
        allEmployeeLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(allEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(allEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked

        try {
            int index = empTable.getSelectedRow();
            TableModel model = empTable.getModel();

            String empId = model.getValueAt(index, 0).toString();

            String columnName = " * ";
            String tableName = " employee ";
            String whereCondition = " employee_id = '" + empId + "' ";

            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            sed.setVisible(true);
            sed.pack();
            sed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            while (rs.next()) {
                sed.idTextField.setText(rs.getString("employee_id"));
                sed.fnameTextField.setText(rs.getString("first_name"));
                sed.lnameTextField.setText(rs.getString("last_name"));
                sed.phoneNoTextField.setText(rs.getString("phone_no"));
                sed.emailTextField.setText(rs.getString("email"));
                sed.areaTextField.setText(rs.getString("area"));
                sed.nidTextField.setText(rs.getString("nid_no"));
                sed.addressTextArea.setText(rs.getString("address"));
                sed.joindateTextField.setText(rs.getString("join_date"));
                sed.startingsalaryTextField.setText(rs.getString("starting_salary"));
                sed.detailsLabel.setText("Details of : "+rs.getString("first_name")+" "+rs.getString("last_name"));
                String fileName = rs.getString("scan_photo");
                System.out.println(fileName);
                
                
////                File file = new File(getClass().getResource("E:/Programming/1. Office project/Project/Cable Desktop app/JinanItCableOM/file/" + rs.getString("scan_photo")).getFile());
////                String filePath = file.getAbsolutePath();
//                ImageIcon imageIcon = new ImageIcon(getClass().getResource("E:/Programming/1. Office project/Project/Cable Desktop app/JinanItCableOM/file/"+fileName));
//                Image image = imageIcon.getImage().getScaledInstance(sed.photoLabel.getWidth(), sed.photoLabel.getHeight(), Image.SCALE_SMOOTH);
//                sed.photoLabel.setIcon(new ImageIcon(image));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_empTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allEmployeeLabel;
    private javax.swing.JTable empTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

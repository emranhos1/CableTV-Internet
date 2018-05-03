package com.eh.adminsupper;

import com.eh.dao.InsertQueryDao;
import com.eh.dao.SelectQueryDao;
import com.eh.dbconnection.conRs;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddAdmin extends javax.swing.JInternalFrame {

    private conRs conrs;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String adminName;
    private String phone;
    private String email;
    private String address;
    private String nid;
    private String username;
    private String password;
    private String photo;
    private String UPLOAD_LOCATION;
    private String fileName;
    private String newFileName;
    private File uploadLocationPath;
    private FileOutputStream out1;
    private String tableName;
    private String columnName;
    private String roleId;
    private String values;
    private boolean Addadmin;
    private String tableName1;
    private String columnName1;
    private String values1;
    private boolean AddDetails;

    public AddAdmin() {
        initComponents();
        loadRole();
    }

    public void loadRole() {

        String columnName = " * ";
        String tableName = " role ";
        try {
            conrs = SelectQueryDao.selectQueryWithOutWhereClause(columnName, tableName);
            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String name = rs.getString("name");
                roleComboBox.addItem(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<>();
        adminNameLabel = new javax.swing.JLabel();
        adminNameTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        phoneLabel1 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        nidLabel = new javax.swing.JLabel();
        nidTextField = new javax.swing.JTextField();
        photoButton = new javax.swing.JButton();
        photoNameTextField = new javax.swing.JTextField();
        photoLabel = new javax.swing.JLabel();
        addAdminButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        roleIdLabel = new javax.swing.JLabel();
        roleIdTextField = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Admin");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        roleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleLabel.setText("Role :");

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One" }));
        roleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleComboBoxActionPerformed(evt);
            }
        });

        adminNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adminNameLabel.setText("Admin Name :");

        phoneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phoneLabel.setText("Phone No :");

        phoneLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phoneLabel1.setText("Email :");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addressLabel.setText("Address :");

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane1.setViewportView(addressTextArea);

        nidLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nidLabel.setText("NID No :");

        photoButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        photoButton.setText("Photo");
        photoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoButtonActionPerformed(evt);
            }
        });

        addAdminButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addAdminButton.setText("Add Admin");
        addAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminButtonActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernameLabel.setText("Username :");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel.setText("Password :");

        roleIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleIdLabel.setText("Role Id :");

        roleIdTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adminNameLabel)
                            .addComponent(phoneLabel)
                            .addComponent(phoneLabel1)
                            .addComponent(addressLabel)
                            .addComponent(nidLabel)
                            .addComponent(usernameLabel)
                            .addComponent(roleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nidTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adminNameTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(photoButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(photoNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roleIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roleIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(addAdminButton)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleLabel)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photoButton)
                    .addComponent(photoNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminNameLabel)
                            .addComponent(adminNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel1)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nidLabel)
                    .addComponent(nidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roleIdLabel)
                        .addComponent(roleIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(addAdminButton)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void photoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filePath = file.getAbsolutePath();
        System.out.println(filePath);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH));
        photoLabel.setIcon(imageIcon);
        fileName = file.getName();
        photoNameTextField.setText(fileName);
    }//GEN-LAST:event_photoButtonActionPerformed

    private void roleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleComboBoxActionPerformed

        String roleName = roleComboBox.getSelectedItem().toString();

        String columnName = " role_id ";
        String tableName = " role ";
        String whereCondition = " name = '" + roleName + "'";

        try {
            conrs = SelectQueryDao.selectQueryWithWhereClause(columnName, tableName, whereCondition);

            con = conrs.getCon();
            pstm = conrs.getPstm();
            rs = conrs.getRs();

            while (rs.next()) {
                String roleId = rs.getString("role_id");
                roleIdTextField.setText(roleId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_roleComboBoxActionPerformed

    private void addAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminButtonActionPerformed

        adminName = adminNameTextField.getText();
        phone = phoneTextField.getText();
        email = emailTextField.getText();
        address = addressTextArea.getText();
        nid = nidTextField.getText();
        username = usernameTextField.getText();
        password = passwordTextField.getText();
        photo = photoNameTextField.getText();
        roleId = roleIdTextField.getText();
        if (!adminName.equals("")) {
            if (!phone.equals("")) {
                if (!email.equals("")) {
                    if (!address.equals("")) {
                        if (!nid.equals("")) {
                            if (!photo.equals("")) {
                                UPLOAD_LOCATION = "E:/Programming/1. Office project/Project/Cable Desktop app/JinanItCableOM/file/";
                                newFileName = UUID.randomUUID() + fileName;
                                uploadLocationPath = new File(UPLOAD_LOCATION);
                                File file = new File(UPLOAD_LOCATION + newFileName);
                                try {
                                    if (!file.exists()) {
                                        uploadLocationPath.mkdirs();
                                        out1 = new FileOutputStream(new File(UPLOAD_LOCATION + File.separator + newFileName));

                                        tableName = " admin ";
                                        columnName = " username, password, create_date, role_id ";
                                        values = "'" + username + "', MD5('" + password + "'), now(), '" + roleId + "'";
                                        Addadmin = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);

                                        tableName1 = " admin_details ";
                                        columnName1 = " admin_id, admin_name, phone, email, address, scan_photo, nid_no ";
                                        values1 = "(SELECT admin_id FROM admin WHERE username='" + username + "' and password = MD5('" + password + "')), '" + adminName + "', '" + phone + "', '" + email + "', '" + address + "', '" + photo + "', '" + nid + "'";
                                        AddDetails = InsertQueryDao.insertQueryWithOutWhereClause(tableName1, columnName1, values1);
                                        if (Addadmin) {
                                            if (AddDetails) {
                                                JOptionPane.showMessageDialog(null, "Admin Data Inserted Successfully");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Admin Data not Insert");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Admin Data not Insert");
                                        }
                                    }
                                } catch (FileNotFoundException | SQLException ex) {
                                    Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Select One Photo");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Insert NID No");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert Address");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Email");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Phone No");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert Admin Name");
        }
    }//GEN-LAST:event_addAdminButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdminButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JLabel adminNameLabel;
    private javax.swing.JTextField adminNameTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nidLabel;
    private javax.swing.JTextField nidTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel phoneLabel1;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton photoButton;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JTextField photoNameTextField;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JLabel roleIdLabel;
    private javax.swing.JTextField roleIdTextField;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}

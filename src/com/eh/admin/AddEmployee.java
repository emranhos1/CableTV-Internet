package com.eh.admin;

import com.eh.dao.InsertQueryDao;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Emran Hossain
 */
public class AddEmployee extends javax.swing.JInternalFrame {

    private File file;
    private String filePath;
    private String fileName;
    private int active;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String nid;
    private String area;
    private String address;
    private String salary;
    private String UPLOAD_LOCATION;
    private String newFileName;
    private File uploadLocationPath;
    private FileOutputStream out1;
    private String tableName;
    private String columnName;
    private String values;
    private boolean AddEmp;
    private String photo;

    public AddEmployee() {
        initComponents();
        setResizable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        imageLabal = new javax.swing.JLabel();
        photoText = new javax.swing.JTextField();
        chooseFile = new javax.swing.JButton();
        FNameLabel = new javax.swing.JLabel();
        LNameLabel = new javax.swing.JLabel();
        lName = new javax.swing.JTextField();
        phonetext = new javax.swing.JTextField();
        PhoneLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        addresslLabel = new javax.swing.JLabel();
        joinLabel = new javax.swing.JLabel();
        yesRadioButton = new javax.swing.JRadioButton();
        noRadioButton = new javax.swing.JRadioButton();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        areaComboBox = new javax.swing.JComboBox<>();
        nidLabel = new javax.swing.JLabel();
        nidText = new javax.swing.JTextField();
        startingSalaryLabel = new javax.swing.JLabel();
        salaryText = new javax.swing.JTextField();
        fName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        chooseFile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chooseFile.setText("Select Photo :");
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        FNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FNameLabel.setText("First Name :");

        LNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LNameLabel.setText("Last Name :");

        PhoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PhoneLabel.setText("Phone No :");

        EmailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EmailLabel.setText("Email :");

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        addresslLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addresslLabel.setText("Address :");

        joinLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        joinLabel.setText("Active :");

        buttonGroup1.add(yesRadioButton);
        yesRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yesRadioButton.setText("Yes");
        yesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(noRadioButton);
        noRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noRadioButton.setText("No");
        noRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noRadioButtonActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Add Employee");
        jLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        areaLabel.setText("Area :");

        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "A", "B", "C" }));

        nidLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nidLabel.setText("NID No :");

        startingSalaryLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        startingSalaryLabel.setText("Starting Salary :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(joinLabel)
                    .addComponent(PhoneLabel)
                    .addComponent(LNameLabel)
                    .addComponent(EmailLabel)
                    .addComponent(FNameLabel)
                    .addComponent(areaLabel)
                    .addComponent(nidLabel)
                    .addComponent(addresslLabel)
                    .addComponent(startingSalaryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phonetext)
                    .addComponent(emailText)
                    .addComponent(lName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nidText)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(salaryText)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yesRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(noRadioButton))
                    .addComponent(fName))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(chooseFile)
                            .addGap(238, 238, 238))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(save)
                            .addGap(18, 18, 18)
                            .addComponent(reset)
                            .addGap(126, 126, 126)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(photoText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageLabal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FNameLabel)
                    .addComponent(chooseFile)
                    .addComponent(photoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LNameLabel)
                            .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PhoneLabel)
                            .addComponent(phonetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailLabel)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(areaLabel)
                            .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nidLabel)
                            .addComponent(nidText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addresslLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startingSalaryLabel)
                            .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yesRadioButton)
                            .addComponent(noRadioButton)
                            .addComponent(save)
                            .addComponent(reset))
                        .addGap(70, 70, 70))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        file = chooser.getSelectedFile();
        filePath = file.getAbsolutePath();
        System.out.println(filePath);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(imageLabal.getWidth(), imageLabal.getHeight(), Image.SCALE_SMOOTH));
        imageLabal.setIcon(imageIcon);
        fileName = file.getName();
        photoText.setText(fileName);

    }//GEN-LAST:event_chooseFileActionPerformed

    private void yesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesRadioButtonActionPerformed
        active = 1;
    }//GEN-LAST:event_yesRadioButtonActionPerformed

    private void noRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noRadioButtonActionPerformed
        active = 0;
    }//GEN-LAST:event_noRadioButtonActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        firstName = fName.getText();
        lastName = lName.getText();
        phone = phonetext.getText();
        email = emailText.getText();
        area = (String) areaComboBox.getSelectedItem();
        nid = nidText.getText();
        address = addressArea.getText();
        salary = salaryText.getText();
        photo = photoText.getText();
        if (!firstName.equals("")) {
            if (!lastName.equals("")) {
                if (!phone.equals("")) {
                    if (!email.equals("")) {
                        if (areaComboBox.getSelectedIndex() > 0) {
                            if (!nid.equals("")) {
                                if (!address.equals("")) {
                                    if (!salary.equals("")) {
                                        if (yesRadioButton.isSelected() || noRadioButton.isSelected()) {

                                            if (!photo.equals("")) {
                                                UPLOAD_LOCATION = "E:/Programming/1. Office project/Project/Cable Desktop app/JinanItCableOM/file/";

                                                newFileName = UUID.randomUUID() + fileName;
                                                uploadLocationPath = new File(UPLOAD_LOCATION);
                                                File file = new File(UPLOAD_LOCATION + newFileName);
                                                try {
                                                    if (!file.exists()) {
                                                        uploadLocationPath.mkdirs();
                                                        out1 = new FileOutputStream(new File(UPLOAD_LOCATION + File.separator + newFileName));

                                                        tableName = " employee ";
                                                        columnName = " first_name, last_name, phone_no, email, area, nid_no, address, scan_photo, join_date, starting_salary, is_active ";
                                                        values = "'" + firstName + "', '" + lastName + "', '" + phone + "', '" + email + "', '" + area + "', '" + nid + "', '" + address + "', '" + newFileName + "', now(), '" + salary + "', '" + active + "'";
                                                        AddEmp = InsertQueryDao.insertQueryWithOutWhereClause(tableName, columnName, values);
                                                        if (!AddEmp) {
                                                            JOptionPane.showMessageDialog(null, "Employee Data Not Inserted!");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Employee Data Inserted Successfully");
                                                        }
                                                    }
                                                } catch (SQLException | FileNotFoundException ex) {
                                                    Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Select One Photo");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Select Active or Not");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Insert Salary");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Insert Address");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Insert NID No");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Select Area");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert Email");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Phone No");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insert Last Name");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert First Name");
        }
    }//GEN-LAST:event_saveActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        fName.setText("");
        lName.setText("");
        phonetext.setText("");
        emailText.setText("");
        areaComboBox.setSelectedIndex(0);
        nidText.setText("");
        addressArea.setText("");
        salaryText.setText("");
        photoText.setText("");
        imageLabal.setIcon(null);
    }//GEN-LAST:event_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel FNameLabel;
    private javax.swing.JLabel LNameLabel;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addresslLabel;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JLabel areaLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton chooseFile;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField fName;
    private javax.swing.JLabel imageLabal;
    private javax.swing.JLabel jLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel joinLabel;
    private javax.swing.JTextField lName;
    private javax.swing.JLabel nidLabel;
    private javax.swing.JTextField nidText;
    private javax.swing.JRadioButton noRadioButton;
    private javax.swing.JTextField phonetext;
    private javax.swing.JTextField photoText;
    private javax.swing.JButton reset;
    private javax.swing.JTextField salaryText;
    private javax.swing.JButton save;
    private javax.swing.JLabel startingSalaryLabel;
    private javax.swing.JRadioButton yesRadioButton;
    // End of variables declaration//GEN-END:variables
}

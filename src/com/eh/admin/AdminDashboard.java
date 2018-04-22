package com.eh.admin;

import com.eh.login.Login;

public class AdminDashboard extends javax.swing.JFrame {

    public AdminDashboard() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        
        AllDue ad = new AllDue();
        DesktopPanel.add(ad);
        ad.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        HomeMenu = new javax.swing.JMenu();
        EmpMenu = new javax.swing.JMenu();
        addEmployee = new javax.swing.JMenuItem();
        searchEmp = new javax.swing.JMenuItem();
        ConMenu = new javax.swing.JMenu();
        newCableConnection = new javax.swing.JMenuItem();
        allCableConnection = new javax.swing.JMenuItem();
        newInternetConnectionMenuItem = new javax.swing.JMenuItem();
        allInternetConnection = new javax.swing.JMenuItem();
        MACIPMenu = new javax.swing.JMenu();
        addMacIp = new javax.swing.JMenuItem();
        advanceMenu = new javax.swing.JMenu();
        PayrollMenu = new javax.swing.JMenu();
        EmpSalaryMenuItem = new javax.swing.JMenuItem();
        cableConnectionBillMenuItem = new javax.swing.JMenuItem();
        internatconnectionBillMenuItem = new javax.swing.JMenuItem();
        ReportMenu = new javax.swing.JMenu();
        inventoryMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        LogoutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DesktopPanel.setBackground(new java.awt.Color(0, 153, 153));
        DesktopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Dashboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout DesktopPanelLayout = new javax.swing.GroupLayout(DesktopPanel);
        DesktopPanel.setLayout(DesktopPanelLayout);
        DesktopPanelLayout.setHorizontalGroup(
            DesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        DesktopPanelLayout.setVerticalGroup(
            DesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );

        HomeMenu.setText("Home");
        HomeMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(HomeMenu);

        EmpMenu.setText("Employee");
        EmpMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        addEmployee.setText("Add Employee");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });
        EmpMenu.add(addEmployee);

        searchEmp.setText("Search Employee");
        searchEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmpActionPerformed(evt);
            }
        });
        EmpMenu.add(searchEmp);

        jMenuBar1.add(EmpMenu);

        ConMenu.setText("Connection");
        ConMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        newCableConnection.setText("New Cable Connection");
        newCableConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCableConnectionActionPerformed(evt);
            }
        });
        ConMenu.add(newCableConnection);

        allCableConnection.setText("All Cable Connection");
        allCableConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allCableConnectionActionPerformed(evt);
            }
        });
        ConMenu.add(allCableConnection);

        newInternetConnectionMenuItem.setText("New Internet Connection");
        newInternetConnectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInternetConnectionMenuItemActionPerformed(evt);
            }
        });
        ConMenu.add(newInternetConnectionMenuItem);

        allInternetConnection.setText("All Internet Connection");
        allInternetConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allInternetConnectionActionPerformed(evt);
            }
        });
        ConMenu.add(allInternetConnection);

        jMenuBar1.add(ConMenu);

        MACIPMenu.setText("MAC/IP");
        MACIPMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        addMacIp.setText("Add Mac IP");
        addMacIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMacIpActionPerformed(evt);
            }
        });
        MACIPMenu.add(addMacIp);

        jMenuBar1.add(MACIPMenu);

        advanceMenu.setText("Advance");
        advanceMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        advanceMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                advanceMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(advanceMenu);

        PayrollMenu.setText("Payroll");
        PayrollMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        EmpSalaryMenuItem.setText("Employee Salary");
        EmpSalaryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpSalaryMenuItemActionPerformed(evt);
            }
        });
        PayrollMenu.add(EmpSalaryMenuItem);

        cableConnectionBillMenuItem.setText("Cable Connection Bill");
        cableConnectionBillMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cableConnectionBillMenuItemActionPerformed(evt);
            }
        });
        PayrollMenu.add(cableConnectionBillMenuItem);

        internatconnectionBillMenuItem.setText("Internat Connection Bill");
        internatconnectionBillMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internatconnectionBillMenuItemActionPerformed(evt);
            }
        });
        PayrollMenu.add(internatconnectionBillMenuItem);

        jMenuBar1.add(PayrollMenu);

        ReportMenu.setText("Report");
        ReportMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(ReportMenu);

        inventoryMenu.setText("Inventory");
        inventoryMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem1.setText("Add Product");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        inventoryMenu.add(jMenuItem1);

        jMenuItem2.setText("Purchase OR Sell");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        inventoryMenu.add(jMenuItem2);

        jMenuBar1.add(inventoryMenu);

        LogoutMenu.setText("Logout");
        LogoutMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LogoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMenuMouseClicked(evt);
            }
        });
        LogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(LogoutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpSalaryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpSalaryMenuItemActionPerformed
//        new AddEmployee().dispose();
//        new AllCableConnection().dispose();
//        new AllEmployee().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new NewCableConnections().dispose();
//        new NewInternetConnection().dispose();
//        new NewMACIP().dispose();
        EmployeeSalary es = new EmployeeSalary();
        DesktopPanel.add(es);
        es.setVisible(true);
    }//GEN-LAST:event_EmpSalaryMenuItemActionPerformed

    private void LogoutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMenuMouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutMenuMouseClicked

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
//        this.dispose();
//        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutMenuActionPerformed

    private void searchEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmpActionPerformed
//        new AddEmployee().dispose();
//        new AllCableConnection().dispose();
//        new EmployeeSalary().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new NewCableConnections().dispose();
//        new NewInternetConnection().dispose();
//        new NewMACIP().dispose();
        AllEmployee ae = new AllEmployee();
        DesktopPanel.add(ae);
        ae.setVisible(true);
        
    }//GEN-LAST:event_searchEmpActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
//        new AllEmployee().dispose();
//        new AllCableConnection().dispose();
//        new EmployeeSalary().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new NewCableConnections().dispose();
//        new NewInternetConnection().dispose();
//        new NewMACIP().dispose();
        AddEmployee ae = new AddEmployee();
        DesktopPanel.add(ae);
        ae.setVisible(true);

    }//GEN-LAST:event_addEmployeeActionPerformed

    private void newCableConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCableConnectionActionPerformed
//        new AllEmployee().dispose();
//        new AllCableConnection().dispose();
//        new EmployeeSalary().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewInternetConnection().dispose();
//        new NewMACIP().dispose();
        NewCableConnections ncc = new NewCableConnections();
        DesktopPanel.add(ncc);
        ncc.setVisible(true);

    }//GEN-LAST:event_newCableConnectionActionPerformed

    private void allCableConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCableConnectionActionPerformed
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewInternetConnection().dispose();
//        new NewMACIP().dispose();
        AllCableConnection acc = new AllCableConnection();
        DesktopPanel.add(acc);
        acc.setVisible(true);

    }//GEN-LAST:event_allCableConnectionActionPerformed

    private void addMacIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMacIpActionPerformed
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewInternetConnection().dispose();
//        new AllCableConnection().dispose();
        NewMACIP nmi = new NewMACIP();
        DesktopPanel.add(nmi);
        nmi.setVisible(true);

    }//GEN-LAST:event_addMacIpActionPerformed

    private void newInternetConnectionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInternetConnectionMenuItemActionPerformed
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewMACIP().dispose();
//        new AllCableConnection().dispose();
        NewInternetConnection nic = new NewInternetConnection();
        DesktopPanel.add(nic);
        nic.setVisible(true);

    }//GEN-LAST:event_newInternetConnectionMenuItemActionPerformed

    private void allInternetConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allInternetConnectionActionPerformed
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new NewInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new EmployeeAdvance().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewMACIP().dispose();
//        new AllCableConnection().dispose();
        AllInternetConnection aic = new AllInternetConnection();
        DesktopPanel.add(aic);
        aic.setVisible(true);

    }//GEN-LAST:event_allInternetConnectionActionPerformed

    private void advanceMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advanceMenuMouseClicked
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new NewInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new AllInternetConnection().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewMACIP().dispose();
//        new AllCableConnection().dispose();
        EmployeeAdvance ea = new EmployeeAdvance();
        DesktopPanel.add(ea);
        ea.setVisible(true);

    }//GEN-LAST:event_advanceMenuMouseClicked

    private void cableConnectionBillMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cableConnectionBillMenuItemActionPerformed
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new NewInternetConnection().dispose();
//        new EmployeeAdvance().dispose();
//        new AllInternetConnection().dispose();
//        new InternetConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewMACIP().dispose();
//        new AllCableConnection().dispose();
        CableConnectionBill ccb = new CableConnectionBill();
        DesktopPanel.add(ccb);
        ccb.setVisible(true);
    }//GEN-LAST:event_cableConnectionBillMenuItemActionPerformed

    private void internatconnectionBillMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internatconnectionBillMenuItemActionPerformed
        InternetConnectionBill icb = new InternetConnectionBill();
        DesktopPanel.add(icb);
        icb.setVisible(true);
//        new AllEmployee().dispose();
//        new NewCableConnections().dispose();
//        new EmployeeSalary().dispose();
//        new NewInternetConnection().dispose();
//        new EmployeeAdvance().dispose();
//        new AllInternetConnection().dispose();
//        new CableConnectionBill().dispose();
//        new AddEmployee().dispose();
//        new NewMACIP().dispose();
//        new AllCableConnection().dispose();
    }//GEN-LAST:event_internatconnectionBillMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        Inventory i = new Inventory();
        DesktopPanel.add(i);
        i.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AddProduct ap = new AddProduct();
        DesktopPanel.add(ap);
        ap.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void HomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMenuMouseClicked
        
        AllDue ad = new AllDue();
        DesktopPanel.add(ad);
        ad.setVisible(true);
    }//GEN-LAST:event_HomeMenuMouseClicked

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ConMenu;
    public static javax.swing.JPanel DesktopPanel;
    private javax.swing.JMenu EmpMenu;
    private javax.swing.JMenuItem EmpSalaryMenuItem;
    private javax.swing.JMenu HomeMenu;
    private javax.swing.JMenu LogoutMenu;
    private javax.swing.JMenu MACIPMenu;
    private javax.swing.JMenu PayrollMenu;
    private javax.swing.JMenu ReportMenu;
    private javax.swing.JMenuItem addEmployee;
    private javax.swing.JMenuItem addMacIp;
    private javax.swing.JMenu advanceMenu;
    private javax.swing.JMenuItem allCableConnection;
    private javax.swing.JMenuItem allInternetConnection;
    private javax.swing.JMenuItem cableConnectionBillMenuItem;
    private javax.swing.JMenuItem internatconnectionBillMenuItem;
    private javax.swing.JMenu inventoryMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem newCableConnection;
    private javax.swing.JMenuItem newInternetConnectionMenuItem;
    private javax.swing.JMenuItem searchEmp;
    // End of variables declaration//GEN-END:variables
}

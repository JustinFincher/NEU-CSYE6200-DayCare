/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.view;

import javax.swing.*;

/**
 *
 * @author fincher
 */
public class ApplicationForm extends javax.swing.JFrame {

    public TaskAction dashboardAction = new TaskAction("Glance", new ImageIcon(getClass().getResource("/icons/report-24.png")));
    public TaskAction manageTeacherAction = new TaskAction("Teachers", new ImageIcon(getClass().getResource("/icons/teacher-24.png")));
    public TaskAction manageStudentAction = new TaskAction("Students", new ImageIcon(getClass().getResource("/icons/baby-24.png")));
    public TaskAction manageParentAction = new TaskAction("Parents", new ImageIcon(getClass().getResource("/icons/parent-24.png")));
    public TaskAction manageImmunizationAction = new TaskAction("Immunization", new ImageIcon(getClass().getResource("/icons/virus-24.png")));
    public TaskAction manageClassroomAction = new TaskAction("Classroom", new ImageIcon(getClass().getResource("/icons/classroom-24.png")));
    public TaskAction manageRatioRuleAction = new TaskAction("Ratio Rule", new ImageIcon(getClass().getResource("/icons/structure-24.png")));
    /**
     * Creates new form ApplicationForm
     */
    public ApplicationForm() {
        initComponents();
//        Image image = new ImageIcon(getClass().getResource("/icons/app-icon.png")).getImage();
//        if (System.getProperty("os.name", "").startsWith("Mac OS")) {
//            com.apple.eawt.Application.getApplication().setDockIconImage(image);
//        }
//        else {
//            setIconImage(image);
//        }
        dashboardTaskPane.add(dashboardAction);
        staffManageTaskPane.add(manageTeacherAction);
        staffManageTaskPane.add(manageStudentAction);
        staffManageTaskPane.add(manageParentAction);
        facilityManageTaskPane.add(manageClassroomAction);
        facilityManageTaskPane.add(manageImmunizationAction);
        facilityManageTaskPane.add(manageRatioRuleAction);
        
        menuBar.add(Box.createHorizontalGlue(), menuBar.getComponents().length - 1);
    }

    public void switchTo(JPanel panel)
    {
        splitViewContentPanel.removeAll();
        splitViewContentPanel.add(panel);
        splitViewContentPanel.revalidate();
        splitViewContentPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPanel = new javax.swing.JSplitPane();
        splitViewMenuScrollPanel = new javax.swing.JScrollPane();
        splitViewMenuTaskPaneContainer = new org.jdesktop.swingx.JXTaskPaneContainer();
        dashboardTaskPane = new org.jdesktop.swingx.JXTaskPane();
        systemAdminTaskPane = new org.jdesktop.swingx.JXTaskPane();
        staffManageTaskPane = new org.jdesktop.swingx.JXTaskPane();
        facilityManageTaskPane = new org.jdesktop.swingx.JXTaskPane();
        splitViewContentPanel = new javax.swing.JPanel();
        placeholderLabel = new javax.swing.JLabel();
        jXStatusBar1 = new org.jdesktop.swingx.JXStatusBar();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        documentationMenuItem = new javax.swing.JMenuItem();
        debugMenu = new javax.swing.JMenu();
        destroyDatabaseMenuItem = new javax.swing.JMenuItem();
        loadMockDataMenuItem = new javax.swing.JMenuItem();
        showDatabaseMenuItem = new javax.swing.JMenuItem();
        loginMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        splitPanel.setDividerLocation(230);
        splitPanel.setDividerSize(10);
        splitPanel.setName(""); // NOI18N

        splitViewMenuScrollPanel.setMinimumSize(new java.awt.Dimension(200, 23));

        splitViewMenuTaskPaneContainer.setToolTipText("");
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        splitViewMenuTaskPaneContainer.setLayout(verticalLayout1);

        dashboardTaskPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart-24.png"))); // NOI18N
        dashboardTaskPane.setTitle("Dashboard");
        splitViewMenuTaskPaneContainer.add(dashboardTaskPane);

        systemAdminTaskPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/identity-24.png"))); // NOI18N
        systemAdminTaskPane.setTitle("System Admin");
        splitViewMenuTaskPaneContainer.add(systemAdminTaskPane);

        staffManageTaskPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group-24.png"))); // NOI18N
        staffManageTaskPane.setTitle("Staff Management");
        splitViewMenuTaskPaneContainer.add(staffManageTaskPane);

        facilityManageTaskPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/location-24.png"))); // NOI18N
        facilityManageTaskPane.setTitle("Facility Management");
        splitViewMenuTaskPaneContainer.add(facilityManageTaskPane);

        splitViewMenuScrollPanel.setViewportView(splitViewMenuTaskPaneContainer);

        splitPanel.setLeftComponent(splitViewMenuScrollPanel);

        splitViewContentPanel.setLayout(new java.awt.BorderLayout());

        placeholderLabel.setForeground(new java.awt.Color(102, 102, 102));
        placeholderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placeholderLabel.setText("Select a panel from the left");
        placeholderLabel.setAlignmentX(0.5F);
        splitViewContentPanel.add(placeholderLabel, java.awt.BorderLayout.CENTER);

        splitPanel.setRightComponent(splitViewContentPanel);

        jLabel1.setText("Status");
        jXStatusBar1.add(jLabel1);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        documentationMenuItem.setText("Documentation");
        helpMenu.add(documentationMenuItem);

        debugMenu.setMnemonic('h');
        debugMenu.setText("Debug");

        destroyDatabaseMenuItem.setMnemonic('a');
        destroyDatabaseMenuItem.setText("Destroy Database");
        debugMenu.add(destroyDatabaseMenuItem);

        loadMockDataMenuItem.setMnemonic('a');
        loadMockDataMenuItem.setText("Load Mock Data");
        debugMenu.add(loadMockDataMenuItem);

        showDatabaseMenuItem.setMnemonic('a');
        showDatabaseMenuItem.setText("Show Database");
        debugMenu.add(showDatabaseMenuItem);

        helpMenu.add(debugMenu);

        menuBar.add(helpMenu);

        loginMenu.setMnemonic('h');
        loginMenu.setText("Login");
        loginMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        menuBar.add(loginMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXStatusBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(splitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jXStatusBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    public org.jdesktop.swingx.JXTaskPane dashboardTaskPane;
    private javax.swing.JMenu debugMenu;
    private javax.swing.JMenuItem deleteMenuItem;
    public javax.swing.JMenuItem destroyDatabaseMenuItem;
    public javax.swing.JMenuItem documentationMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private org.jdesktop.swingx.JXTaskPane facilityManageTaskPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private org.jdesktop.swingx.JXStatusBar jXStatusBar1;
    public javax.swing.JMenuItem loadMockDataMenuItem;
    private javax.swing.JMenu loginMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JLabel placeholderLabel;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    public javax.swing.JMenuItem showDatabaseMenuItem;
    private javax.swing.JSplitPane splitPanel;
    public javax.swing.JPanel splitViewContentPanel;
    public javax.swing.JScrollPane splitViewMenuScrollPanel;
    private org.jdesktop.swingx.JXTaskPaneContainer splitViewMenuTaskPaneContainer;
    private org.jdesktop.swingx.JXTaskPane staffManageTaskPane;
    public org.jdesktop.swingx.JXTaskPane systemAdminTaskPane;
    // End of variables declaration//GEN-END:variables

}

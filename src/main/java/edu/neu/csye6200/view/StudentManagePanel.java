/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.view;

import javax.swing.*;

/**
 *
 * @author Haotian Zheng
 */
public class StudentManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentManagePanel
     */
    public StudentManagePanel() {
        initComponents();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setAutoCreateColumnsFromModel(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbarPanel = new javax.swing.JPanel();
        refreshTableButton = new javax.swing.JButton();
        addStudentButton = new javax.swing.JButton();
        importTableButton = new javax.swing.JButton();
        exportTableButton = new javax.swing.JButton();
        searchPanel = new org.jdesktop.swingx.JXSearchPanel();
        titleLabel = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        toolbarPanel.setPreferredSize(new java.awt.Dimension(100, 38));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING);
        flowLayout1.setAlignOnBaseline(true);
        toolbarPanel.setLayout(flowLayout1);

        refreshTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-24.png"))); // NOI18N
        refreshTableButton.setText("Refresh");
        refreshTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));
        toolbarPanel.add(refreshTableButton);

        addStudentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-24.png"))); // NOI18N
        addStudentButton.setText("Add");
        addStudentButton.setMargin(new java.awt.Insets(0, 2, 0, 8));
        toolbarPanel.add(addStudentButton);

        importTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/import-24.png"))); // NOI18N
        importTableButton.setText("Import");
        importTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));
        toolbarPanel.add(importTableButton);

        exportTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/down-24.png"))); // NOI18N
        exportTableButton.setText("Export");
        exportTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));
        toolbarPanel.add(exportTableButton);

        searchPanel.setMinimumSize(new java.awt.Dimension(485, 37));
        searchPanel.setName(""); // NOI18N
        toolbarPanel.add(searchPanel);

        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | java.awt.Font.BOLD, titleLabel.getFont().getSize()+13));
        titleLabel.setText("Student");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableScrollPane.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableScrollPane)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(0, 0, 0)
                .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addStudentButton;
    public javax.swing.JButton exportTableButton;
    public javax.swing.JButton importTableButton;
    public javax.swing.JButton refreshTableButton;
    public org.jdesktop.swingx.JXSearchPanel searchPanel;
    public javax.swing.JTable table;
    public javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel toolbarPanel;
    // End of variables declaration//GEN-END:variables
}

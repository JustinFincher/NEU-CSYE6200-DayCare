/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.view;

/**
 *
 * @author xiangjingru
 */
public class ParentManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form ParentMangerPanel
     */
    public ParentManagePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        refreshTableButton = new javax.swing.JButton();
        addParentButton = new javax.swing.JButton();
        importTableButton = new javax.swing.JButton();
        exportTableButton = new javax.swing.JButton();
        searchPanel = new org.jdesktop.swingx.JXSearchPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        insertTableButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(850, 477));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 26)); // NOI18N
        jLabel1.setText("Parent");

        refreshTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-24.png"))); // NOI18N
        refreshTableButton.setText("Refresh");
        refreshTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));

        addParentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-24.png"))); // NOI18N
        addParentButton.setText("Add");
        addParentButton.setMargin(new java.awt.Insets(0, 2, 0, 8));

        importTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/import-24.png"))); // NOI18N
        importTableButton.setText("Import");
        importTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));

        exportTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/down-24.png"))); // NOI18N
        exportTableButton.setText("Export");
        exportTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));

        searchPanel.setMinimumSize(new java.awt.Dimension(485, 37));
        searchPanel.setName(""); // NOI18N

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

        insertTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/parent-24.png"))); // NOI18N
        insertTableButton.setText("Insert");
        insertTableButton.setMargin(new java.awt.Insets(0, 2, 0, 8));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refreshTableButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addParentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importTableButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exportTableButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertTableButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addParentButton)
                        .addComponent(importTableButton)
                        .addComponent(exportTableButton)
                        .addComponent(insertTableButton))
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addParentButton;
    public javax.swing.JButton exportTableButton;
    public javax.swing.JButton importTableButton;
    public javax.swing.JButton insertTableButton;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton refreshTableButton;
    public org.jdesktop.swingx.JXSearchPanel searchPanel;
    public javax.swing.JTable table;
    public javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}

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
public class StudentAddPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentAddPanel
     */
    public StudentAddPanel() {
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

        birthDayLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        birthDayEditorPane = new javax.swing.JEditorPane();
        emailAddressPaneLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        emailAddressPane = new javax.swing.JEditorPane();
        gradeLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        gradeEditorPane = new javax.swing.JEditorPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        hashedPasswordEditorPane = new javax.swing.JEditorPane();
        hashedPasswordLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        idEditorPane = new javax.swing.JEditorPane();
        realNameLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        realNameEditorPane = new javax.swing.JEditorPane();
        userLevelLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        userLevelEditorPane = new javax.swing.JEditorPane();
        userNameLabel = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        userNameEditorPane = new javax.swing.JEditorPane();
        walkInTimeLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        walkInTimeEditorPane = new javax.swing.JEditorPane();
        OKButton = new javax.swing.JButton();

        birthDayLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        birthDayLabel.setText("birthDay：");

        jScrollPane2.setViewportView(birthDayEditorPane);

        emailAddressPaneLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        emailAddressPaneLabel.setText("emailAddress：");

        jScrollPane3.setViewportView(emailAddressPane);

        gradeLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        gradeLabel.setText("grade：");

        jScrollPane4.setViewportView(gradeEditorPane);

        jScrollPane5.setViewportView(hashedPasswordEditorPane);

        hashedPasswordLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        hashedPasswordLabel.setText("hashedPassword：");

        idLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        idLabel.setText("id：");

        jScrollPane6.setViewportView(idEditorPane);

        realNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        realNameLabel.setText("realName：");

        jScrollPane7.setViewportView(realNameEditorPane);

        userLevelLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        userLevelLabel.setText("userLevel：");

        jScrollPane8.setViewportView(userLevelEditorPane);

        userNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        userNameLabel.setText("userName：");

        jScrollPane9.setViewportView(userNameEditorPane);

        walkInTimeLabel.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        walkInTimeLabel.setText("walkInTime：");

        jScrollPane10.setViewportView(walkInTimeEditorPane);

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(birthDayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gradeLabel)
                                    .addComponent(emailAddressPaneLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idLabel)
                                    .addComponent(realNameLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(hashedPasswordLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(walkInTimeLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userLevelLabel)
                                    .addComponent(userNameLabel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(OKButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthDayLabel)
                            .addComponent(hashedPasswordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailAddressPaneLabel)
                            .addComponent(idLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLevelLabel)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeLabel)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realNameLabel)
                    .addComponent(walkInTimeLabel)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OKButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton OKButton;
    public javax.swing.JEditorPane birthDayEditorPane;
    public javax.swing.JLabel birthDayLabel;
    public javax.swing.JEditorPane emailAddressPane;
    public javax.swing.JLabel emailAddressPaneLabel;
    public javax.swing.JEditorPane gradeEditorPane;
    public javax.swing.JLabel gradeLabel;
    public javax.swing.JEditorPane hashedPasswordEditorPane;
    public javax.swing.JLabel hashedPasswordLabel;
    public javax.swing.JEditorPane idEditorPane;
    public javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JEditorPane realNameEditorPane;
    public javax.swing.JLabel realNameLabel;
    public javax.swing.JEditorPane userLevelEditorPane;
    public javax.swing.JLabel userLevelLabel;
    public javax.swing.JEditorPane userNameEditorPane;
    public javax.swing.JLabel userNameLabel;
    public javax.swing.JEditorPane walkInTimeEditorPane;
    public javax.swing.JLabel walkInTimeLabel;
    // End of variables declaration//GEN-END:variables
}

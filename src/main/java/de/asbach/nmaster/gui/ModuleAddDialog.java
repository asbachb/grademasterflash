package de.asbach.nmaster.gui;

import de.asbach.nmaster.model.Module;

/*
 * NewJDialog.java
 *
 * Created on 23. August 2008, 14:11
 */
/**
 *
 * @author Benjamin Asbach <benjamin.asbach at gmail.com>
 */
public class ModuleAddDialog extends javax.swing.JDialog {

    private Module result;

    /** Creates new form NewJDialog */
    public ModuleAddDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ComponentCenterer.centerComponent(this);

        this.getRootPane().setDefaultButton(cmdSave);
    }

    public ModuleAddDialog(java.awt.Frame parent, boolean modal, Module template) {
        this(parent, modal);

        txtModuleNo.setText(String.valueOf(template.getModulNumber()));
        txtModuleAlias.setText(template.getModuleName());
        txtCreditPoints.setText(String.valueOf(template.getCreditPoints()));
        if (template.getGrade() != 0) {
            txtGrade.setText(String.valueOf(template.getGrade()));
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModuleNo = new javax.swing.JLabel();
        txtModuleNo = new javax.swing.JTextField();
        lblModuleAlias = new javax.swing.JLabel();
        txtModuleAlias = new javax.swing.JTextField();
        cmdAbort = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        lblCreditPoints = new javax.swing.JLabel();
        txtCreditPoints = new javax.swing.JTextField();
        lblGrade = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblModuleNo.setText("Modul Nr.");

        lblModuleAlias.setText("Modul Anzeigename:");

        cmdAbort.setText("Abbrechen");
        cmdAbort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAbortActionPerformed(evt);
            }
        });

        cmdSave.setText("Speichern");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        lblCreditPoints.setText("Creditpoints:");

        lblGrade.setText("Erreichte Note (optional):");

        txtGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradeActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtModuleNo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addComponent(lblModuleNo)
                            .addComponent(lblModuleAlias)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtModuleAlias, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdAbort))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtCreditPoints, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addComponent(lblCreditPoints)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addComponent(lblGrade))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModuleNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModuleNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblModuleAlias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModuleAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCreditPoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCreditPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdSave)
                    .addComponent(cmdAbort))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
    try {
        result = new Module(txtModuleAlias.getText(), txtModuleNo.getText(), Double.parseDouble(txtCreditPoints.getText()));
        if (!"".equals(txtGrade.getText())) {
            final double grade = Double.parseDouble(txtGrade.getText().replace(",", "."));

            if (grade > 0 && grade < 6) {
                result.setGrade(grade);
            }
        }
    } catch (Exception e) {
        result = null;
    } finally {
        dispose();
    }
}//GEN-LAST:event_cmdSaveActionPerformed

private void cmdAbortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbortActionPerformed
    dispose();
}//GEN-LAST:event_cmdAbortActionPerformed

private void txtGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtGradeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAbort;
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel lblCreditPoints;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblModuleAlias;
    private javax.swing.JLabel lblModuleNo;
    private javax.swing.JTextField txtCreditPoints;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtModuleAlias;
    private javax.swing.JTextField txtModuleNo;
    // End of variables declaration//GEN-END:variables

    public Module getResult() {
        return result;
    }
}
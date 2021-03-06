/*
 * OptionsDialog.java
 *
 * Created on 8. September 2008, 08:45
 */

package de.asbach.nmaster.gui;

import de.asbach.nmaster.core.GrademasterProperties;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class OptionsDialog extends javax.swing.JDialog {
    private static final long serialVersionUID = -8608621550355255484L;

    private GrademasterProperties properties;
    /** Creates new form OptionsDialog */
    public OptionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        properties = GrademasterProperties.getInstance();
        initComponents();
        
        if(properties.get("precission") != null){
            txtNumbersAfterKomma.setText(properties.getProperty("precission"));
        }else{
            txtNumbersAfterKomma.setText("1");
        }
        
        ComponentCenterer.centerComponent(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumbersAfterKomma = new javax.swing.JLabel();
        txtNumbersAfterKomma = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNumbersAfterKomma.setText("Anzahl der Stellen hinter dem Komma:");

        txtNumbersAfterKomma.setText("NULL");

        cmdSave.setText("Speichern");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtNumbersAfterKomma, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNumbersAfterKomma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(cmdSave)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumbersAfterKomma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumbersAfterKomma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if( hasChanged() ){
            try {
                properties.setProperty("precission", txtNumbersAfterKomma.getText());
                properties.save();
            } catch (IOException ex) {
                Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}//GEN-LAST:event_formWindowClosing

private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
    formWindowClosing(null);
    dispose();
}//GEN-LAST:event_cmdSaveActionPerformed

    
private boolean hasChanged() {
    return !"".equals(txtNumbersAfterKomma.getText()) && (
            properties.getProperty("precission") == null ||
            Integer.valueOf(txtNumbersAfterKomma.getText()) != Integer.valueOf(properties.getProperty("precission"))
           );
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel lblNumbersAfterKomma;
    private javax.swing.JTextField txtNumbersAfterKomma;
    // End of variables declaration//GEN-END:variables

}

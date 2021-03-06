/*
 * AboutFrame.java
 *
 * Created on 27. August 2008, 00:54
 */

package de.asbach.nmaster.gui;

import de.asbach.nmaster.core.Version;
import de.asbach.nmaster.core.VersionNotFoundException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class AboutFrame extends javax.swing.JDialog {

    /** Creates new form AboutFrame */
    public AboutFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        ComponentCenterer.centerComponent(this);
        
        try {
            lblVersion.setText("grademasterflash " + Version.getInstance().getVersion());
        } catch (VersionNotFoundException ex) {
            Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        cmdVisitPage = new javax.swing.JButton();
        lblMe = new javax.swing.JLabel();
        lblIconset = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel() {
            @Override
            public void paint(java.awt.Graphics g) {
                ((java.awt.Graphics2D) g).setRenderingHint(
                    java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON
                );
                super.paint(g);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmdVisitPage.setText("check for updates");
        cmdVisitPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVisitPageActionPerformed(evt);
            }
        });

        lblMe.setText("Benjamin Asbach, 2008");

        lblIconset.setText("Icons based on silk iconset by Mark James");
        lblIconset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconsetMouseClicked(evt);
            }
        });
        lblIconset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblIconsetMouseMoved(evt);
            }
        });

        lblVersion.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        try{
            lblVersion.setText("grademasterflash " + Version.getInstance().getVersion());
        }catch(VersionNotFoundException e){
            Logger.getLogger(AboutFrame.class.getName()).warning(e.getLocalizedMessage());
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblIconset))
                    .addComponent(lblVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdVisitPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(lblMe)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIconset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(cmdVisitPage))
                    .addComponent(lblMe))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmdVisitPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVisitPageActionPerformed
    try {
        Desktop.getDesktop().browse(new URI("http://foo.bluebug.de/grademasterflash/"));
    } catch (URISyntaxException ex) {
        Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_cmdVisitPageActionPerformed

private void lblIconsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconsetMouseClicked
    try {
        Desktop.getDesktop().browse(new URI("http://www.famfamfam.com/lab/icons/silk/"));
    } catch (URISyntaxException ex) {
        Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_lblIconsetMouseClicked

private void lblIconsetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconsetMouseMoved

}//GEN-LAST:event_lblIconsetMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdVisitPage;
    private javax.swing.JLabel lblIconset;
    private javax.swing.JLabel lblMe;
    private javax.swing.JLabel lblVersion;
    // End of variables declaration//GEN-END:variables

}

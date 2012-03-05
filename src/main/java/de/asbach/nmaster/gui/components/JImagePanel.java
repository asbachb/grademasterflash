package de.asbach.nmaster.gui.components;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Benjamin Asbach <benjamin.asbach at gmail.com>
 */
public class JImagePanel extends JPanel{
    private static final long serialVersionUID = 3234377203691909507L;

    private ImageIcon image;
    
    public JImagePanel(){
        super();
    }
    public JImagePanel(ImageIcon image){
        this.image = image;
    }
    
    public ImageIcon getImage(){
        return image;
    }
    public void getImage(ImageIcon image){
        this.image = image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            g.drawImage(image.getImage(), 0, 0, this);
        }
    }
}

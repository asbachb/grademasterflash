package de.asbach.nmaster.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Benjamin Asbach <benjamin.asbach at gmail.com>
 */
public class ComponentCenterer {
    public static void centerComponent(Component toCenter){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        toCenter.setLocation((dim.width - toCenter.getWidth()) / 2, (dim.height - toCenter.getHeight()) / 2);
    }
}

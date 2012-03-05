package de.asbach.nmaster.gui.components;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 *
 * @author Benjamin Asbach <benjamin.asbach at gmail.com>
 */
public class SemesterTabbedPane extends JTabbedPane{
    private static final long serialVersionUID = -1265299490510536945L;
    
    private List<AddTabListener> addTabListeners;
    
    public SemesterTabbedPane(){
        super();
        
        addTabListeners = new ArrayList<AddTabListener>();        
        addTab("", new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("images/add.png")), new AddTabPanel());        
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(getSelectedComponent() instanceof AddTabPanel){
                    for(AddTabListener l : addTabListeners){
                        l.addTab();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(getSelectedComponent() instanceof AddTabPanel){
                    for(AddTabListener l : addTabListeners){
                        l.addTab();
                    }
                }
            }
        });
    }
    
    public void addTabListener(AddTabListener listener){
        addTabListeners.add(listener);
    }
    public void removeTabLister(AddTabListener listener){
        addTabListeners.remove(listener);
    }
    
    @Override
    public void removeAll(){
        for(Component c : getComponents()){
            if(!(c instanceof AddTabPanel)){
                remove(c);
            }
        }
    }
}
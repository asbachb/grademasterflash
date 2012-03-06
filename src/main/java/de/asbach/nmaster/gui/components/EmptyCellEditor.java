package de.asbach.nmaster.gui.components;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class EmptyCellEditor extends DefaultCellEditor {
    private static final long serialVersionUID = 2384357553553140299L;

    public EmptyCellEditor(){
        super(new JTextField());
        setClickCountToStart(1);
    }
    
    @Override
    public Object getCellEditorValue(){
        Object o = super.getCellEditorValue();        
        
        return o;
    }    
    
    @Override
    public Component getTableCellEditorComponent(JTable table,
                                             Object value,
                                             boolean isSelected,
                                             int row,
                                             int column){
        Component c = super.getTableCellEditorComponent(table, value, isSelected, row, column);
        
        ((JTextField)c).setText("");
        
        
        return c;        
    }
}

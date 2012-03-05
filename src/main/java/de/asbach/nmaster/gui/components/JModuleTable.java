package de.asbach.nmaster.gui.components;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Benjamin Asbach <benjamin.asbach at gmail.com>
 */
public class JModuleTable extends JTable {
    private static final long serialVersionUID = -3608698649196032084L;

    public JModuleTable() {
        super();
    }
    
    @Override
    public TableCellRenderer getCellRenderer(int row, int column) {
        if(column == 3){
            TableCellRenderer tcr = super.getCellRenderer(row, column);
            ((DefaultTableCellRenderer)tcr).setBackground(Color.RED);
            
            return tcr;
        }else
            return super.getCellRenderer(row, column);
    }
}

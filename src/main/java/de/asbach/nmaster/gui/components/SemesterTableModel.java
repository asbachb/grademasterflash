package de.asbach.nmaster.gui.components;

import de.asbach.nmaster.model.Module;
import de.asbach.nmaster.model.Semester;
import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Benjamin Asbach <benjamin.asbach at gmail.com>
 */
public class SemesterTableModel extends AbstractTableModel{
    private static final long serialVersionUID = 2738801554947619541L;
    
    private Semester semester;
    
    public SemesterTableModel(Semester semester){
        this.semester = semester;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Modul Nr.";
            case 1:
                return "Modul Name";
            case 2:
                return "Credit Points";
            case 3:
                return "Erreichte Note";
            default:
                return "NULL";
        }
    }

    @Override
    public int getRowCount() {
        return semester.getModules().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return semester.getModules().get(row).getModulNumber();
            case 1:
                return semester.getModules().get(row).getModuleName();                
            case 2:
                return semester.getModules().get(row).getCreditPoints();
            case 3:
                if(semester.getModules().get(row).getGrade() == 0)
                    return "<Note eintragen>";
                else{
                    double d = semester.getModules().get(row).getGrade();
                    DecimalFormat df = new DecimalFormat("0.0");
                    return df.format(d);
                }
            default:
                return "NULL";
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        switch(column){
            case 3:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        switch(column){
            case 3:
                if(!aValue.equals("")){
                    double d = Double.valueOf(((String)aValue).replace(",", "."));
                    if(d >= 0 && d <= 5){
                        semester.getModules().get(row).setGrade(d);
                    }
                }
                fireTableDataChanged();
        }
    }
    
    public Module getModuleAt(int row){
        return semester.getModules().get(row);
    }
}
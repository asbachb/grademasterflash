package de.asbach.nmaster.core;

import de.asbach.nmaster.gui.OptionsDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class GrademasterProperties extends Properties{
    private static final long serialVersionUID = 7311417827809871221L;

    public static int DEFAULT_PRECISSION = 1;
    public static String PRECISSION_KEY = "precission";
    
    public static String DEFAULT_HOME = 
        System.getProperty("user.home") + File.separator + 
        ".grademasterflash" + File.separator;
    private static String DEFAULT_SETTINGS_XML = "settings.xml";
    private static GrademasterProperties self = new GrademasterProperties();
    
    protected GrademasterProperties(){
        super();
        try {
            loadFromXML(new FileInputStream(new File(DEFAULT_HOME + DEFAULT_SETTINGS_XML)));
        } catch (InvalidPropertiesFormatException ex) {
            Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static GrademasterProperties getInstance(){
        return self;
    }
    
    public void save() throws IOException {
        final File f = new File(DEFAULT_HOME);
        if ( !f.exists() ) {
            f.mkdir();
        }
        
        storeToXML(new FileOutputStream(new File(DEFAULT_HOME + DEFAULT_SETTINGS_XML))
            , "grademasterflash settings xmls", "UTF-8");
    }
}

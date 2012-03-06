package de.asbach.nmaster.core;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class VersionNotFoundException extends Exception{
    private static final long serialVersionUID = 3700881654134734924L;
    public VersionNotFoundException(){
        super();
    }
    public VersionNotFoundException(String s){
        super(s);
    }
}

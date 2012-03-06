package de.asbach.nmaster.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class Semester implements Serializable{
    private static final long serialVersionUID = -2002944207570138303L;
    
    private String semesterAlias;
    private List<Module> moduleList;
    
    public Semester(String semesterAlias){
        this.moduleList = new ArrayList<Module>();
        this.semesterAlias = semesterAlias;
    }    

    public String getSemesterAlias() {
        return semesterAlias;
    }
    public void setSemesterAlias(String semesterAlias) {
        this.semesterAlias = semesterAlias;
    }
    
    public void addModule(Module m){
        moduleList.add(m);
    }
    public void removeModule(Module m){
        moduleList.remove(m);
    }
    public List<Module> getModules(){
        return moduleList;
    }
}
package de.asbach.nmaster.model;

import java.io.Serializable;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class Module implements Serializable{
    private static final long serialVersionUID = -7911838200760911752L;
    
    private String  moduleName;
    private String  modulNumber;
    private double  creditPoints;
    private double  grade;
    private int     percentage;
    
    public Module(String moduleName, String moduleNumber, double creditPoints){
        this.moduleName = moduleName;
        this.modulNumber = moduleNumber;
        this.creditPoints = creditPoints;
    }

    public String getModulNumber() {
        return modulNumber;
    }
    public String getModuleName() {
        return moduleName;
    }

    public void setCreditPoints(double creditPoints) {
        this.creditPoints = creditPoints;
    }

    public void setModulNumber(String modulNumber) {
        this.modulNumber = modulNumber;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getCreditPoints() {
        return creditPoints;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 *
 * @author Dawei
 */
public class Dose extends DBObject {
    
    private boolean check;
    private LocalDate doseDate;
    private LocalDate doseDeadline;
    
    /**
     * Construct an unchecked Dose 
     * 
     * @param doseDeadline The deadline of this Dose
     */
    public Dose(LocalDate doseDeadline) {
        this(false, null, doseDeadline);
    }
    
    /**
     *  
     * @param check The status of this Dose, checked or unchecked
     * @param doseDate The date this dose was given. 
     * @param doseDeadline The deadline of this Dose
     */
    public Dose(boolean check, LocalDate doseDate, LocalDate doseDeadline) {
        this.check = check;
        this.doseDate = doseDate;
        this.doseDeadline = doseDeadline;
    }
    
    /**
     * 
     * @return The status of this Dose
     */
    public boolean getCheck() {
        return this.check;
    }
    
    /**
     * 
     * @return The date this dose was given
     */
    public LocalDate getDoseDate() {
        return this.doseDate;
    }
    
    /**
     * 
     * @return The deadline of this Dose
     */
    public LocalDate getDoseDeadline() {
        return this.doseDeadline;
    }
    
    /**
     * 
     * @param check The status of this Dose
     */
    public void setCheck(boolean check) {
        this.check = check;
    }

    /**
     *
     * @param doseDate
     */
    public void setDoseDate(LocalDate doseDate) {
        this.doseDate = doseDate;
    }

    /**
     *
     * @param doseDeadline
     */
    public void setDoseDeadline(LocalDate doseDeadline) {
        this.doseDeadline = doseDeadline;
    }
}

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
    
    public Dose(boolean check, LocalDate doseDate, LocalDate doseDeadline) {
        this.check = check;
        this.doseDate = doseDate;
        this.doseDeadline = doseDeadline;
    }
    
    public boolean getCheck() {
        return this.check;
    }
    
    public LocalDate getDoseDate() {
        return this.doseDate;
    }
    
    public LocalDate getDoseDeadline() {
        return this.doseDeadline;
    }
    
    public void setCheck(boolean check) {
        this.check = check;
    }
    
    public void setDoseDate(LocalDate doseDate) {
        this.doseDate = doseDate;
    }
    
    public void setDoseDeadline(LocalDate doseDeadline) {
        this.doseDeadline = doseDeadline;
    }
}

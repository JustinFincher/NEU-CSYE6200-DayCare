package edu.neu.csye6200.model;

import java.util.LinkedList;

/**
 * Infant : Student of age 0 to 23 months
 *
 * @author Dawei
 */
public class InfantImmunizationRecord extends ImmunizationRecord {
    public InfantImmunizationRecord() {
        super();   
    }
    
    @Override
    /**
     * Method to return flu shot recommendation for infant Students
     * 
     * @param age The age of the Student
     * @return A String of flu shot recommendation
     */
    public String fluShotRecommendation(int age) {
        if (age < 4) { return "Not Applicable"; }
        else { return "Influenza (IIV) recommended"; }
    }
}

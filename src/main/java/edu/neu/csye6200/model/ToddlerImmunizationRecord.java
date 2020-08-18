package edu.neu.csye6200.model;

/**
 * Infant : Student of age 24 to 60 months
 * 
 * @author Dawei
 */
public class ToddlerImmunizationRecord extends ImmunizationRecord{
    
    public ToddlerImmunizationRecord() {
        super();   
    }

    @Override
    /**
     * Method to return flu shot recommendation for toddler Students
     * 
     * @param age The age of the Student
     * @return A String of flu shot recommendation
     */
    public String fluShotRecommendation(int age) {
        return "Influenza (IIV) or Influenza (LAIV)";
    }
    
}

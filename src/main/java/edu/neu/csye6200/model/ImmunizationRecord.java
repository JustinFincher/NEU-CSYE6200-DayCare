package edu.neu.csye6200.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dawei
 */
public abstract class ImmunizationRecord extends DBObject{
    private Map<Vaccine, List<Dose>> record;

    /**
     * Default constructor
     */
    public ImmunizationRecord() {
        record = new HashMap<>();
    }

    /**
     * Method to add new vaccination to record
     * 
     * @param v The Vaccine to be added
     * @param doses A List of all required doses
     */
    public void addNewVaccine(Vaccine v, List<Dose> doses) {
        record.put(v, doses);
    }

    /**
     * Method to add new dose to an existing vaccination record
     * 
     * @param v The Vaccine to add dose to
     * @param d The Dose to be added
     * @return True if successfully added this Dose, otherwise false
     */
    public boolean addNewDose(Vaccine v, Dose d) {
        return record.get(v).add(d);
    }

    /**
     * Method to remove immunization record of the given Vaccine
     * 
     * @param v The Vaccine to be removed
     * @return The List of Dose of this Vaccine
     */
    public List<Dose> removeVaccine(Vaccine v) {
        return record.remove(v);
    }

    /**
     * Method to remove an existing Dose
     * 
     * @param v The Vaccine to remove Dose from
     * @param n The index of the Dose to be removed
     * @return The removed Dose 
     */
    public Dose removeDose(Vaccine v, int n) {
        return record.get(v).remove(n);
    }

    /**
     * Method to check one Dose
     * 
     * @param v The Vaccine to check Dose of
     * @return Return true if successfully check a Dose of the given Vaccine
     *         v. If no available Dose to check, return false
     */
    public boolean checkDose(Vaccine v) {
        for (Dose d : record.get(v)) {
            if (!d.getCheck()) {
                d.setCheck(true);
                return true;
            }
        }
        // No available Dose to check
        return false;
    }

    /**
     * Method to check if this record is complete 
     * 
     * @return Return true if all Doses of all Vaccines are checked
     */
    public boolean isComplete() {
        for (List<Dose> doses : record.values()) {
            for (Dose d : doses) {
                if (!d.getCheck()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * @param age The age of the Student
     * @return A String of flu shot recommendation
     */
    public abstract String fluShotRecommendation(int age);
}

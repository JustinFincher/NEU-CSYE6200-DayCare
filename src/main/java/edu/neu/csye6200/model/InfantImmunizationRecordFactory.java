package edu.neu.csye6200.model;

/**
 *
 * @author Dawei
 */
public class InfantImmunizationRecordFactory extends ImmunizationRecordFactory {
    
    @Override
    /**
     * Method to generate an InfantImmunizationRecord
     * 
     * @return An InfantImmunizationRecord from the factory
     */
    public ImmunizationRecord getImmunizationRecord() {
        return new InfantImmunizationRecord();
    }
}

package edu.neu.csye6200.model;

/**
 *
 * @author Dawei
 */
public class ToddlerImmunizationRecordFactory extends ImmunizationRecordFactory{
    
    @Override
    /**
     * Method to generate a ToddlerImmunizationRecord
     * 
     * @return An ToddlerImmunizationRecord from the factory
     */
    public ImmunizationRecord getImmunizationRecord() {
        return new ToddlerImmunizationRecord();
    }
}

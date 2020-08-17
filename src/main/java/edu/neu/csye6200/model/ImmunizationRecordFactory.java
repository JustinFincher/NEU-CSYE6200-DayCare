package edu.neu.csye6200.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dawei
 */
public class ImmunizationRecordFactory extends DBObject {
    public class ImmunizationRecord extends DBObject{
        private Map<Vaccine, List<Dose>> record;
        private boolean isComplete;
        
        public ImmunizationRecord() {
            record = new HashMap<>();
            isComplete = false;
        }
        
        public void addNewVaccine(Vaccine v, List<Dose> doses) {
            record.put(v, doses);
        }
        
        public void addNewDose(Vaccine v, Dose d) {
            record.get(v).add(d);
        }
        
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
    }
    
    public ImmunizationRecord getImmunizationRecord() {
        return new ImmunizationRecord();
    }
}

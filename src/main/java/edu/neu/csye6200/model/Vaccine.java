package edu.neu.csye6200.model;


/**
 *
 * @author Dawei
 */
public class Vaccine extends DBObject {
    private String name;
    private String description;
    
    public Vaccine(String name) {
        this(name, "No Description.");
    }
    
    public Vaccine(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}

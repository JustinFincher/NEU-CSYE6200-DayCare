package edu.neu.csye6200.model;


/**
 *
 * @author Dawei
 */
public class Vaccine extends DBObject {
    private String name;
    private String description;
    
    /**
     * Construct a Vaccine with a name
     * @param name Name of the Vaccine
     */
    public Vaccine(String name) {
        this(name, "No Description.");
    }
    
    /**
     * Construct a Vaccine with a name and a description
     * @param name Name of the Vaccine
     * @param description The description of this Vaccine
     */
    public Vaccine(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * 
     * @return The name of the Vaccine
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * 
     * @param name The name of the Vaccine
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @return The description of the Vaccine
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * 
     * @param description The description of the Vaccine
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

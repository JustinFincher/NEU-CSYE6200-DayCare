package edu.neu.csye6200.model;

/**
 * Base class for all classes that are about to have CRUD operations with DB
 */
public class DBObject
{
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    private Integer id;
}

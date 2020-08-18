package edu.neu.csye6200.model;

import java.util.Map;

/**
 * Base class for all classes that are about to have CRUD operations with DB
 */
public class DBObject
{
    public Integer getId() { return id == null ? 0 : id; }
    public void setId(Integer id) { this.id = id; }
    private Integer id;

    public void saveCsv(Map<String, String> map) {
    }

    public void loadCsv(Map<String, String> map) {
    }

}

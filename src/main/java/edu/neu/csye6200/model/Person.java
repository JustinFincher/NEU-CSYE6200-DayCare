package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.annotation.DatabaseField;
import edu.neu.csye6200.helper.annotation.DatabaseTable;

@DatabaseTable(tableName = "Person")
public class Person
{
    @DatabaseField(fieldName = "id", fieldType = DatabaseFieldType.INTEGER)
    public int id;
}

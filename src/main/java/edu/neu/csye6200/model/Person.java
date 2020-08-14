package edu.neu.csye6200.model;

public class Person extends DBObject
{
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    private String realName;
}

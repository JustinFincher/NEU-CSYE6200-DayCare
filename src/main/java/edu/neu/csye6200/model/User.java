package edu.neu.csye6200.model;

public class User extends Person
{
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String userName;

    public Integer getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
    private Integer userLevel;

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    private String emailAddress;
}

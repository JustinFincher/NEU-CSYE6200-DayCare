package edu.neu.csye6200.model;

public class Teacher extends User
{
    public Integer getCredits() {
        return credits;
    }
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    private Integer credits;

    public String getEmailAddress() { return emailAddress == null ? "i@example.com" : emailAddress; }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    private String emailAddress;
}

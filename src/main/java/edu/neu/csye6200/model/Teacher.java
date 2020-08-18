package edu.neu.csye6200.model;

import java.util.Map;

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

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("email_address",getEmailAddress());
    }

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setEmailAddress(map.getOrDefault("email_address",""));
    }
}

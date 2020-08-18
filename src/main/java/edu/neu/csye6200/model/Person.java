package edu.neu.csye6200.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Person extends DBObject
{
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) {
       this.emailAddress = emailAddress;
    }
    private String realName;

    private String emailAddress;
    
    public LocalDate getBirthDay() { return birthDay; }
    public void setBirthDay(LocalDate birthDay) { this.birthDay = birthDay; }
    private LocalDate birthDay;

    public Integer getAge() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.YEARS));}
}

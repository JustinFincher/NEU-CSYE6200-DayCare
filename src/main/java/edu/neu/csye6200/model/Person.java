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
    private String realName;

    public LocalDate getBirthDay() { return birthDay; }
    public void setBirthDay(LocalDate birthDay) { this.birthDay = birthDay; }
    private LocalDate birthDay;

    public Integer getAgeInYear() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.YEARS));}
    public Integer getAgeInMonth() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.MONTHS));}
}

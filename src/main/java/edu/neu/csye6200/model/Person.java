package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Person extends DBObject
{
    public String getRealName() {
        return realName == null ? "" : realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    private String realName;

    public LocalDate getBirthDay() { return birthDay == null ? LocalDate.now() : birthDay; }
    public void setBirthDay(LocalDate birthDay) { this.birthDay = birthDay; }
    private LocalDate birthDay;

    @JavaBeansIgnore
    public Integer getAgeInYear() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.YEARS));}
    @JavaBeansIgnore
    public Integer getAgeInMonth() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.MONTHS));}
}

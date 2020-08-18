package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

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

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("real_name", getRealName());
    }

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setRealName(map.getOrDefault("real_name", ""));
    }
}

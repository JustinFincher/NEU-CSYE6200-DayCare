package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;

import java.time.*;
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

    public LocalDateTime getBirthDay() { return birthDay == null ? LocalDateTime.now() : birthDay; }
    public void setBirthDay(LocalDateTime birthDay) { this.birthDay = birthDay; }
    private LocalDateTime birthDay;

    @JavaBeansIgnore
    public Integer getAgeInYear() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.YEARS));}
    @JavaBeansIgnore
    public Integer getAgeInMonth() {return Math.toIntExact(getBirthDay().until(LocalDateTime.now(), ChronoUnit.MONTHS));}

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("real_name", getRealName());
        map.put("birth_day", String.valueOf(getBirthDay().toEpochSecond(ZoneOffset.UTC)));
    }

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setRealName(map.getOrDefault("real_name", ""));
        setBirthDay(Instant.ofEpochSecond(Long.parseLong(map.getOrDefault("birth_day","0"))).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}

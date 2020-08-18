package edu.neu.csye6200.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

/**
 * Student Data Model
 * Should has these fields:
 *  - grade
 *  - walk-in date
 *  - immunization record
 *
 * @see <a href="https://www.notion.so/haotianzheng/Student-256835304927473cb082a6feabdb5d8e">Student Data On Notion</a>
 * @author Haotian Zheng
 */
public class Student extends User
{
    public LocalDateTime getWalkInTime() { return walkInTime == null ? LocalDateTime.now() : walkInTime; }
    public void setWalkInTime(LocalDateTime walkInTime) { this.walkInTime = walkInTime; }
    private LocalDateTime walkInTime;

    public Integer getGrade() { return grade == null ? 100 : grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
    private Integer grade;

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setGrade(Integer.parseInt(map.getOrDefault("grade", "0")));
        setWalkInTime(Instant.ofEpochSecond(Long.parseLong(map.getOrDefault("walk_in_time","0"))).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("grade",getGrade().toString());
        map.put("walk_in_time", String.valueOf(getWalkInTime().toEpochSecond(ZoneOffset.UTC)));
    }
}

package edu.neu.csye6200.model;

import java.time.LocalDateTime;
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
public class Student extends User implements CsvSerializable
{
    public LocalDateTime getWalkInTime() { return walkInTime == null ? LocalDateTime.now() : walkInTime; }
    public void setWalkInTime(LocalDateTime walkInTime) { this.walkInTime = walkInTime; }
    private LocalDateTime walkInTime;

    public Integer getGrade() { return grade == null ? 100 : grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
    private Integer grade;

    @Override
    public void loadCsv(Map<String, String> map) {

    }

    @Override
    public void saveCsv(Map<String, String> map) {

    }
}

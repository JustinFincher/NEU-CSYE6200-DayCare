package edu.neu.csye6200.model;

import java.time.LocalDateTime;

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
    public LocalDateTime getWalkInTime() { return walkInTime; }
    public void setWalkInTime(LocalDateTime walkInTime) { this.walkInTime = walkInTime; }
    private LocalDateTime walkInTime;

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
    private Integer grade;

    @Override
    public String saveCsv() {
        return null;
    }

    @Override
    public void loadCsv(String csvStr) {

    }

    @Override
    public String toString() {
        return "Student{" +
                "walkInTime=" + walkInTime +
                ", grade=" + grade +
                ", saveCsv='" + saveCsv() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", userLevel=" + getUserLevel() +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", hashedPassword='" + getHashedPassword() + '\'' +
                ", realName='" + getRealName() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", age=" + getAgeInYear() +
                ", id=" + getId() +
                '}';
    }
}

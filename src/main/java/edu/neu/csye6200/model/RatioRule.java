package edu.neu.csye6200.model;

public class RatioRule extends DBObject
{
    public Integer getMaxGroupsPerRoom() {
        return maxGroupsPerRoom;
    }
    public void setMaxGroupsPerRoom(Integer maxGroupsPerRoom) {
        this.maxGroupsPerRoom = maxGroupsPerRoom;
    }
    private Integer maxGroupsPerRoom;

    public Integer getMaxStudentPerTeacher() {
        return maxStudentPerTeacher;
    }
    public void setMaxStudentPerTeacher(Integer maxStudentPerTeacher) { this.maxStudentPerTeacher = maxStudentPerTeacher; }
    private Integer maxStudentPerTeacher;

    public Integer getMinAgeInMonth() {
        return minAgeInMonth;
    }
    public void setMinAgeInMonth(Integer minAgeInMonth) {
        this.minAgeInMonth = minAgeInMonth;
    }
    private Integer minAgeInMonth;

    public Integer getMaxAgeInMonth() {
        return maxAgeInMonth;
    }
    public void setMaxAgeInMonth(Integer maxAgeInMonth) {
        this.maxAgeInMonth = maxAgeInMonth;
    }
    private Integer maxAgeInMonth;
}

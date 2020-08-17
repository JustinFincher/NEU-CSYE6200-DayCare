package edu.neu.csye6200.model;

public class RatioRule extends DBObject
{
    public Integer getMaxGroupsPerRoom() {
        return maxGroupsPerRoom;
    }

    public void setMaxGroupsPerRoom(Integer maxGroupsPerRoom) {
        this.maxGroupsPerRoom = maxGroupsPerRoom;
    }

    public Integer getMaxStudentPerTeacher() {
        return maxStudentPerTeacher;
    }

    public void setMaxStudentPerTeacher(Integer maxStudentPerTeacher) {
        this.maxStudentPerTeacher = maxStudentPerTeacher;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    private Integer maxGroupsPerRoom;
    private Integer maxStudentPerTeacher;
    private Integer minAge;
    private Integer maxAge;
}

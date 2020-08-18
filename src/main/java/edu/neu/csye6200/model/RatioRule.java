package edu.neu.csye6200.model;

import java.util.Map;

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
    public void setMaxStudentPerTeacher(Integer maxStudentPerTeacher) { this.maxStudentPerTeacher = maxStudentPerTeacher; }

    public Integer getMinAgeInMonth() {
        return minAgeInMonth;
    }
    public void setMinAgeInMonth(Integer minAgeInMonth) {
        this.minAgeInMonth = minAgeInMonth;
    }
    public Integer getMaxAgeInMonth() {
        return maxAgeInMonth;
    }
    public void setMaxAgeInMonth(Integer maxAgeInMonth) {
        this.maxAgeInMonth = maxAgeInMonth;
    }

    private Integer maxGroupsPerRoom;
    private Integer maxStudentPerTeacher;
    private Integer minAgeInMonth;
    private Integer maxAgeInMonth;

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("max_groups_per_room",getMaxGroupsPerRoom().toString());
        map.put("max_student_per_teacher",getMaxStudentPerTeacher().toString());
        map.put("min_age_in_month",getMinAgeInMonth().toString());
        map.put("max_age_in_month",getMaxAgeInMonth().toString());
    }

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setMaxGroupsPerRoom(Integer.parseInt(map.get("max_groups_per_room")));
        setMaxStudentPerTeacher(Integer.parseInt(map.get("max_student_per_teacher")));
        setMinAgeInMonth(Integer.parseInt(map.get("min_age_in_month")));
        setMaxAgeInMonth(Integer.parseInt(map.get("max_age_in_month")));
    }
}

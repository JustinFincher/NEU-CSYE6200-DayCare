package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Classroom extends DBObject
{
    List<ClassroomGroup> groups;

    Classroom()
    {
        // DB
        List<RatioRule> rules = new ArrayList<>();

        rules.forEach(ratioRule -> {
            Integer maxGroupsPerRoom = ratioRule.getMaxGroupsPerRoom();
            // groups.add()
        });
    }

    public void addTeacher(Teacher teacher)
    {

    }

    public void autoFill(List<Teacher> teachers, List<Student> students){
        int maxTeacherSize = groups.size();
        if (teachers.size() <= maxTeacherSize)
        {
            for (int i = 0; i < maxTeacherSize; i++) {
                groups.get(i).setTeacher(teachers.get(i));
            }
        }

        students.forEach(s -> {

        });
    }

}

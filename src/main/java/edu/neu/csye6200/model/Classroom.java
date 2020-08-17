package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.manager.DatabaseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Classroom extends DBObject
{
    List<ClassroomGroup> groups;


    Classroom()
    {

        List<RatioRule> rules;
        rules = DatabaseManager.getDB().onDemand(RatioRuleDao.class).list(SQLUtils.getTableName(RatioRule.class));



        rules.forEach(ratioRule -> {
            Integer maxGroupsPerRoom = ratioRule.getMaxGroupsPerRoom();
            // groups.add()
            for (int i = 0; i < maxGroupsPerRoom; i++) {
                groups.add(new ClassroomGroup());
            }

        });
    }

    public boolean canAddTeacher(Teacher teacher)
    {
        return groups.get(groups.size()-1).getTeacher()==null;
    }

    public void addTeacher(Teacher teacher)
    {
        groups.forEach(classroomGroup -> {
            if (classroomGroup.getTeacher()==null){
                classroomGroup.setTeacher(teacher);
            }

        });
    }

/*    public void autoFill(List<Teacher> teachers, List<Student> students){
        int maxTeacherSize = groups.size();
        if (teachers.size() <= maxTeacherSize)
        {
            for (int i = 0; i < maxTeacherSize; i++) {
                groups.get(i).setTeacher(teachers.get(i));
            }
        }

        students.forEach(s -> {

        });
    }*/

}

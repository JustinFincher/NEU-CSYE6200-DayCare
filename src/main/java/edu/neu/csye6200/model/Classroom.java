package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;
import edu.neu.csye6200.manager.DatabaseManager;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Classroom extends DBObject
{
    @JavaBeansIgnore
    public List<ClassroomGroup> getGroups()
    {
        return Arrays.stream(groupIds.split(","))
                .map(Integer::parseInt)
                .map(i -> DatabaseManager.getDB()
                        .onDemand(ClassroomGroupDao.class)
                        .find(ClassroomGroup.class, i))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    @JavaBeansIgnore
    public void setGroups(List<ClassroomGroup> groups)
    {
        groupIds = groups.stream().map(DBObject::getId).map(Object::toString).collect(Collectors.joining(","));
    }
    public String getGroupIds() { return groupIds; }
    public void setGroupIds(String groupIds) { this.groupIds = groupIds; }
    private String groupIds;

//    Classroom()
//    {
//        List<RatioRule> rules;
//        rules = DatabaseManager.getDB().onDemand(RatioRuleDao.class).list(SQLUtils.getTableName(RatioRule.class));
//
//
//
//        rules.forEach(ratioRule -> {
//            Integer maxGroupsPerRoom = ratioRule.getMaxGroupsPerRoom();
//            // groups.add()
//            for (int i = 0; i < maxGroupsPerRoom; i++) {
//                groups.add(new ClassroomGroup());
//            }
//
//        });
//    }
//
//    public boolean canAddTeacher(Teacher teacher)
//    {
//        return groups.get(groups.size()-1).getTeacher()==null;
//    }
//
//    public void addTeacher(Teacher teacher)
//    {
//        groups.forEach(classroomGroup -> {
//            if (classroomGroup.getTeacher()==null){
//                classroomGroup.setTeacher(teacher);
//            }
//
//        });
//    }

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

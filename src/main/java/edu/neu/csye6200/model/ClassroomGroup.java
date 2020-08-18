package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;
import edu.neu.csye6200.manager.DatabaseManager;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClassroomGroup extends DBObject {

    @JavaBeansIgnore
    public Teacher getTeacher()
    {
        return DatabaseManager.getDB()
                .onDemand(TeacherDao.class)
                .find(Teacher.class, teacherId);
    }
    @JavaBeansIgnore
    public void setTeacher(Teacher teacher)
    {
        teacherId = teacher.getId();
    }

    public Integer getTeacherId() { return teacherId; }
    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }
    private Integer teacherId;

    @JavaBeansIgnore
    public RatioRule getRatioRule()
    {
        return DatabaseManager.getDB()
                .onDemand(RatioRuleDao.class)
                .find(RatioRule.class, teacherId);
    }
    @JavaBeansIgnore
    public void setRatioRule(RatioRule ratioRule)
    {
        ratioRuleId = ratioRule.getId();
    }
    public Integer getRatioRuleId() { return ratioRuleId; }
    public void setRatioRuleId(Integer ratioRuleId) { this.ratioRuleId = ratioRuleId; }
    public Integer ratioRuleId;

    @JavaBeansIgnore
    public List<Student> getStudents()
    {
        return Arrays.stream(studentIds.split(","))
                .map(Integer::parseInt)
                .map(i -> DatabaseManager.getDB()
                        .onDemand(StudentDao.class)
                        .find(Student.class, i))
                .filter(Objects::nonNull).collect(Collectors.toList());
    }
    @JavaBeansIgnore
    public void setStudents(List<Student> students)
    {
        studentIds = students.stream().map(DBObject::getId).map(Object::toString).collect(Collectors.joining(","));
    }
    public String getStudentIds() { return studentIds; }
    public void setStudentIds(String studentIds) { this.studentIds = studentIds; }
    private String studentIds;

//
//    public boolean canAddStudent(Student student)
//    {
//        return students.size() < rule.getMaxStudentPerTeacher() &&
//                student.getAgeInYear() < rule.getMaxAgeInMonth() &&
//                rule.getMinAgeInMonth() < student.getAgeInYear();
//    }
//
//    public void addStudent(Student student)
//    {
//        students.add(student);
//    }


}

package edu.neu.csye6200.model;

import java.util.List;

public class ClassroomGroup {

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    private Teacher teacher;
    private List<Student> students;
    private RatioRule rule;

    public boolean canAddStudent(Student student)
    {
        return students.size() < rule.getMaxStudentPerTeacher() &&
                student.getAgeInYear() < rule.getMaxAgeInMonth() &&
                rule.getMinAgeInMonth() < student.getAgeInYear();
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }
}

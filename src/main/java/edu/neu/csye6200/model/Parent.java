package edu.neu.csye6200.model;

public class Parent extends Person
{
    @Override
    public String toString() {
        return "Parent{" +
                "realName='" + getRealName() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", age=" + getAge() +
                ", id=" + getId() +
                '}';
    }
}

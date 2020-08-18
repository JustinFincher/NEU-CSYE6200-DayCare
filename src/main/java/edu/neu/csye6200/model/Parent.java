package edu.neu.csye6200.model;


import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;
import edu.neu.csye6200.manager.DatabaseManager;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Parent extends Person implements CsvSerializable
{
    public String getAddress() { return address == null ? "" : address; }
    public void setAddress(String address) { this.address = address; }
    private String address;

    public String getPhoneNumber() { return phoneNumber == null ? "" : phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    private String phoneNumber;

    public String getEmailAddress() { return emailAddress == null ? "i@example.com" : emailAddress; }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    private String emailAddress;

    @JavaBeansIgnore
    public List<Student> getChildren()
    {
        return Arrays.stream(childrenIds.split(","))
            .map(Integer::parseInt)
            .map(i -> DatabaseManager.getDB()
                            .onDemand(StudentDao.class)
                            .findById(SQLUtils.getTableName(Student.class),
                                    i))
            .map(Optional::get)
            .filter(Objects::nonNull).collect(Collectors.toList());
    }
    @JavaBeansIgnore
    public void setChildren(List<Student> children)
    {
        childrenIds = children.stream().map(DBObject::getId).map(Object::toString).collect(Collectors.joining(","));
    }
    public boolean hasChild(Student child)
    {
        return hasChild(child.getId());
    }
    public boolean hasChild(Integer childId)
    {
        return Arrays.stream(childrenIds.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .contains(childId);
    }

    public String getChildrenIds() { return childrenIds; }
    public void setChildrenIds(String childrenIds) { this.childrenIds = childrenIds; }
    private String childrenIds;

    @Override
    public String saveCsv() {
        return null;
    }
    
    @Override
    public void loadCsv(String csvStr) {

    }
}

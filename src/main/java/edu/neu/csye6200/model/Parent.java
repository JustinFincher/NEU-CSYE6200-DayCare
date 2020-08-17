package edu.neu.csye6200.model;


public class Parent extends Person implements CsvSerializable
{
  
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    private String address;

    public Integer getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(Integer phoneNumber) { this.phoneNumber = phoneNumber; }
    private Integer phoneNumber;
    
    public String getChildName() { return childName; }
    public void setChildName(String childName) { this.childName = childName; }
    private String childName;

    @Override
    public String saveCsv() {
        return null;
    }
    
    @Override
    public void loadCsv(String csvStr) {

    }

    @Override
    public String toString() {
        return "Parent{" +
                "address=" + address +
                ", phoneNumber=" + phoneNumber +
                ", saveCsv='" + saveCsv() + '\'' +
                ", realName='" + getRealName() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", age=" + getAge() +
                ", id=" + getId() +
                ", childName=" + childName +
                '}';
    }
}

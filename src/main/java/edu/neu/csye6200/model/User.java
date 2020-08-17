package edu.neu.csye6200.model;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class User extends Person
{
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String userName;

    public Integer getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
    private Integer userLevel;

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    private String emailAddress;

    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }
    public void setPassword(String password) {
        setHashedPassword(Hashing.sha256().hashString(password, Charset.defaultCharset()).toString());
    }
    private String hashedPassword;
}

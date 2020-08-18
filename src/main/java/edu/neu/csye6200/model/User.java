package edu.neu.csye6200.model;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.Map;

public class User extends Person
{
    public String getUserName() { return userName == null ? "" : userName; }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String userName;

    public Integer getUserLevel() { return userLevel == null ? 0 : userLevel; }
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
    private Integer userLevel;

    public String getHashedPassword() { return hashedPassword == null ? Hashing.sha256().hashString("password", Charset.defaultCharset()).toString() : hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }
    public void setPassword(String password) {
        setHashedPassword(Hashing.sha256().hashString(password, Charset.defaultCharset()).toString());
    }
    private String hashedPassword;
    public boolean isPasswordRight(String password)
    {
        return hashedPassword.equals(Hashing.sha256().hashString(password, Charset.defaultCharset()).toString());
    }

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("user_name",getUserName());
        map.put("hashed_password",getHashedPassword());
    }

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setUserName(map.getOrDefault("user_name",""));
        setHashedPassword(map.getOrDefault("hashed_password",null));
    }
}

package com.hsgene.entity;

import java.util.Date;

/**
 * Created by lenovo on 2016/6/16.
 */
public class User {

    private Integer id;
    private String userCode;// 属性名和数据库字段名相同，xml映射文件中就不需要其别名或者使用resultMap进行映射
    private String userName;
    private String userPassword;
    private String birthday;// 只要属性名和字段名相同，就算类型不一样，mybatis也会自动类型转换

    public User() {
        super();
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String userCode, String userName, String userPassword ,String birthday) {
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.birthday = birthday;
    }

    public User(Integer id, String userCode, String userName, String userPassword) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(Integer id, String userCode, String userName, String userPassword, String birthday) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

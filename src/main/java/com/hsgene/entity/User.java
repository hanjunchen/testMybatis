package com.hsgene.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by lenovo on 2016/6/16.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer id;
    private String userCode;// 属性名和数据库字段名相同，xml映射文件中就不需要其别名或者使用resultMap进行映射
    private String userName;
    private String userPassword;
    private String birthday;// 只要属性名和字段名相同，就算类型不一样，mybatis也会自动类型转换

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

}

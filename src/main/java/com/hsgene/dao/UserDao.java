package com.hsgene.dao;

import com.hsgene.entity.User;

import java.util.List;

/**
 * Created by lenovo on 2016/6/25.
 */
public interface UserDao {

    public int getCount();

    public List<User> getList();
    // mybatis中的增删改操作都默认返回受影响的行数
    public int insert(User user);

    public int update(User user);

    public int delete(User user);
}

package com.yang.dao;

import com.yang.entity.User;

public interface UserDao {
    //根据用户名查询一个
    User selectOne(String username);

    //添加一个
    void insertOne(User user);
}

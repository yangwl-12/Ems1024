package com.yang.service;

import com.yang.entity.User;


public interface UserService {
    //根据用户名查询一个
    User findOne(String username);

    //添加一个
    void addOne(User user);
}

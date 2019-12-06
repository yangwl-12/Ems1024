package com.yang.service;

import com.yang.dao.UserDao;
import com.yang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findOne(String username) {
        return userDao.selectOne(username);
    }

    @Override
    public void addOne(User user) {
        userDao.insertOne(user);
    }
}

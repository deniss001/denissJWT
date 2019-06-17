package com.example.jwt.service.impl;

import com.example.jwt.dao.UserDao;
import com.example.jwt.model.User;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }
}

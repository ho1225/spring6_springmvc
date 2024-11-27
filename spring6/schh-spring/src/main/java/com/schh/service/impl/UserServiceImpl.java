package com.schh.service.impl;

import com.schh.anno.Bean;
import com.schh.anno.Di;
import com.schh.dao.UserDao;
import com.schh.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service......");
        //use DAO method
        userDao.add();
    }
}

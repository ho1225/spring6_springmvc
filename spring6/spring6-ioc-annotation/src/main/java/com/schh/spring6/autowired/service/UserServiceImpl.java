package com.schh.spring6.autowired.service;

import com.schh.spring6.autowired.dao.UserDao;
import com.schh.spring6.autowired.dao.UserRedisDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    private UserDao userDao;
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service......");
        userDao.add();
    }
}

package com.schh.spring6.resource.service;

import com.schh.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service......");
        myUserDao.add();
    }
}

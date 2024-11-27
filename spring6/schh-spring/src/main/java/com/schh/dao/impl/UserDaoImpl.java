package com.schh.dao.impl;

import com.schh.anno.Bean;
import com.schh.dao.UserDao;


@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao...........");
    }
}

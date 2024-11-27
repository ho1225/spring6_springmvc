package com.schh.spring6;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class TestUser {

    //manual log
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        User user = (User) context.getBean("user");
        System.out.println("1: "+ user);
        user.add();
        logger.info("#### run manual log");

    }

    //reflection create object
    // make is as .class file and return it to .javajc5o
    @Test
    public void testUserObject1() throws Exception {
        Class clazz = Class.forName("com.schh.spring6.User");

//        Object o = clazz.newInstance();
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}

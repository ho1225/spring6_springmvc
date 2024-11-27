package com.schh.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = (User) context.getBean("user");

        System.out.println("from id: " + user1);

        User user2 = context.getBean(User.class);
        System.out.println("from type: "+ user2);

        User user3 = context.getBean("user", User.class);
        System.out.println("from id+type"+ user3);
    }
}

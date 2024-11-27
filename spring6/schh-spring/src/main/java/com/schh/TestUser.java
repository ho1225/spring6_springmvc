package com.schh;

import com.schh.bean.AnnotationApplicationContext;
import com.schh.bean.ApplicationContext;
import com.schh.service.UserService;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.schh");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}

package com.schh.spring6.resource.controller;

import com.schh.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {

    @Resource(name = "myUserService")
    private UserService userService;

    public void add() {
        System.out.println("controller....");
        userService.add();
    }

}

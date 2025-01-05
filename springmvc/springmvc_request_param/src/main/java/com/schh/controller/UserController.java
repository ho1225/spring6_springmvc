package com.schh.controller;

import com.schh.domain.User;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("common param transfer name => "+ name);
        System.out.println("common param transfer age => "+ age);
        return "{'module': 'common param'}";
    }


    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName, int age) {
        System.out.println("common param transfer name => "+ userName);
        System.out.println("common param transfer age => "+ age);
        return "{'module': 'common param'}";
    }

    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojo param transfer name => " + user);
        return "{'module': 'common param'}";
    }

    @RequestMapping("/pojoContainParam")
    @ResponseBody
    public String pojoContainParam(User user) {
        System.out.println("pojo contain param transfer name => " + user);
        return "{'module': 'common param'}";
    }


    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println("arrayParam transfer name => " + Arrays.toString(likes));
        return "{'module': 'common param'}";
    }

    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("listParam transfer name => " + likes);
        return "{'module': 'common param'}";
    }

}

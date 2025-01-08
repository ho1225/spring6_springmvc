package com.schh.controller;

import com.schh.domain.User;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("common param transfer name => " + name);
        System.out.println("common param transfer age => " + age);
        return "{'module': 'common param'}";
    }


    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName, int age) {
        System.out.println("common param transfer name => " + userName);
        System.out.println("common param transfer age => " + age);
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

    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json) list => " + likes);
        return "{'module': 'list common for json param'}";
    }

    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user) {
        System.out.println("list pojo(json) => " + user);
        return "{'module': 'list pojo for json param'}";
    }

    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list) {
        System.out.println("list pojo(json) list => " + list);
        return "{'module': 'list pojo for json param'}";
    }

    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") Date date2) {
        System.out.println("dateParam => " + date);
        System.out.println("dateParam => " + date1);
        System.out.println("dateParam => " + date2);
        return "{'module': 'date Param'}";
    }
}

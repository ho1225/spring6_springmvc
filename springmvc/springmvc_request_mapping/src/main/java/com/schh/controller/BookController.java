package com.schh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/book/save")
    @ResponseBody
    public String save() {
        System.out.println("book save...");
        return "{'module': 'book save'}";
    }
}

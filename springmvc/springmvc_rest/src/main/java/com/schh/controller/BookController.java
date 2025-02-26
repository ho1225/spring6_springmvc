package com.schh.controller;

import com.schh.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save(){
        System.out.println("book save..." );
        return "{'module': 'book save}";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("book delete..." + id);
        return "{'module': 'book delete}";
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody Book book){
        System.out.println("book update..." + book);
        return "{'module': 'book update}";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("book getById..." + id);
        return "{'module': 'book getById}";
    }
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getAll(){
        System.out.println("book get all...");
        return "{'module': 'book getall}";
    }
}

package com.schh.controller;

import com.schh.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("save book: " + book);
        return "save success";
    }

    @PutMapping
    public String update(@RequestBody Book book) {
        System.out.println("update book: " + book);
        return "update success";
    }

    @DeleteMapping( "/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("delete book id: " + id);
        return "delete success";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("get book id: " + id);
        return "get success";
    }

    @GetMapping
    public String getAll() {
        System.out.println("get all books");
        return "get all success";
    }
}

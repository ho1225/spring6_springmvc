package com.schh.controller;

import com.schh.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save ===>" + book);
        return "{'module': 'book save success}";
    }

    @GetMapping
    public List<Book> getAll(){
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setType("type1");
        book1.setName("book1");
        book1.setDescription("book1 description");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setType("type2");
        book2.setName("book2");
        book2.setDescription("book2 description");
        bookList.add(book2);

        return bookList;
    }


}

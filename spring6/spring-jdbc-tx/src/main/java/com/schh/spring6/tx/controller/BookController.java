package com.schh.spring6.tx.controller;

import com.schh.spring6.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //buy book method: (book id and user id)
    public void buyBook(Integer bookId, Integer userId) {
        // use service method
        bookService.buyBook(bookId, userId);
    }
}

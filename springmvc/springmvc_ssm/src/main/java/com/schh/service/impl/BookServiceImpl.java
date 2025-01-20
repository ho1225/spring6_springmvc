package com.schh.service.impl;

import com.schh.domain.Book;
import com.schh.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public boolean save(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Book getById(Integer id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }
}

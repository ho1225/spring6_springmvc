package com.schh.service;

import com.schh.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {

    /**
     * Saves the given book to the database.
     *
      * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * updates the given book in the database.
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * Deletes the book with the given id from the database.
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     *  Returns the book with the given id.
     * @param id
     * @return
     */
    public Book getById(Integer id);

    /**
     * Returns all books in the database.
     * @return
     */
    public List<Book> getAll();
}

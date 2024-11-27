package com.schh.spring6.tx.service;

import com.schh.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //query book price by book id
        Integer price = bookDao.getBookPriceByBookId(bookId);

        // update book stock (-1)
        bookDao.updateStock(bookId);


        // update user balance (-book price)
        bookDao.updateUserBalance(userId, price);
    }
}

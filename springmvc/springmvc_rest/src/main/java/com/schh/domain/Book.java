package com.schh.domain;

public class Book {
    private String Book;
    private Integer price;

    @Override
    public String toString() {
        return "Book{" +
                "Book='" + Book + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBook() {
        return Book;
    }

    public void setBook(String book) {
        Book = book;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

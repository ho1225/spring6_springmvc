package com.schh.spring6.iocxml.di;

public class Book {
    private String bname;

    private String author;

    private String others;

    public Book() {
        System.out.println("non-arg constructor executed");
    }
    public Book(String bname, String author) {
        System.out.println("arg constructor executed");
        this.bname = bname;
        this.author = author;
    }


    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}

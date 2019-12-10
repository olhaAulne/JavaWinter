package com.company;

public class Book {
    private String name, author, publisher;
    private int year, page;
    private double price;

    public Book() {
        name = "Title";
        author = "Author";
        publisher = "Publisher";
        year = 0;
        page = 0;
        price = 0.0;
    }

    public Book(String name, String author, String publisher, int year, int page, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.page = page;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "Title=" + name+", Author = "+author+", Publisher="+publisher+", " +
                "Year="+year+", Page="+page+", Price="+price;
    }
}

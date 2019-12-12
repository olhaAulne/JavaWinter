package com.company.model;

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

    public Book (String name, String author, String publisher, int year, int page, double price) {
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

    public String getAuthor() {

        return author;
    }

    public String getPublisher() {

        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getPage() {
        return page;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " Title=" + name+",Author = "+author+",Publisher="+publisher+"," +
                "Year="+year+",Page="+page+",Price="+price+"\n";
    }

}

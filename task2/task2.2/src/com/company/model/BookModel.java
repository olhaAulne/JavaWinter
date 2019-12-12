package com.company.model;

import java.util.Arrays;
import java.util.Comparator;

public class BookModel {
    public Book [] books;

    public Book[] getBooks() {return books;}

    public BookModel() {books = DataSourseBook.getArrayBook();}

    public  Book [] sortBook(){
        Book [] newBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(newBooks, new PublisherComparator());
        return newBooks;
    }

    public Book [] searchByAuthor(String author){
        Book [] newBooks = new Book[books.length];
        int i=0;
        for (Book el:books) {
            if(el.getAuthor().equalsIgnoreCase(author)){
                newBooks[i]=el;
            i++;
            }
        }
        return newBooks;
    }

    public Book [] searchByPublisher(String publisher){
        Book [] newBooks = new Book[books.length];
        int i=0;
        for (Book el:books) {
            if(el.getPublisher().equalsIgnoreCase(publisher)){
                newBooks[i]=el;
                i++;
            }
        }
        return newBooks;
    }

    public Book [] searchByYear(int year){
        Book [] newBooks = new Book[books.length];
        int i=0;
        for (Book el:books) {
            if(el.getYear()>year){
                newBooks[i]=el;
                i++;
            }
        }
        return newBooks;
    }
}

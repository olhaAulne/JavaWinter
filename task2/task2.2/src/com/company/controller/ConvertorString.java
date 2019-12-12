package com.company.controller;

import com.company.model.Book;

public class ConvertorString {
    public static String convertArrayBook(Book[] books){
        String res = "";
        for (Book el:books) {
            if(el!=null) {
            res +=el.toString();
            }
        }
        return res;
    }
}

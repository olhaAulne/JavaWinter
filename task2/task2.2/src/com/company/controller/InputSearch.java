package com.company.controller;

import com.company.view.InputData;
import com.company.model.BookModel;
import com.company.view.BookView;

public class InputSearch {
    public static void InputAuthor(BookModel model,BookView view) {
        view.viewData("Enter author -> ");
        String author = InputData.input();
        if(ConvertorString.convertArrayBook(model.searchByAuthor(author))!=""){
        view.viewData("List of "+author+"`s book\n");
        view.viewData(ConvertorString.convertArrayBook(model.searchByAuthor(author)));
        }
        else view.viewData("Not found "+author+"`s book\n");
    }

    public static void InputPublisher(BookModel model,BookView view) {
        view.viewData("Enter publisher -> ");
        String publisher = InputData.input();
        if(ConvertorString.convertArrayBook(model.searchByPublisher(publisher))!=""){
            view.viewData("List of "+publisher+" publisher book\n");
            view.viewData(ConvertorString.convertArrayBook(model.searchByPublisher(publisher)));
        }
        else view.viewData("Not found "+publisher+" publisher book\n");
    }

    public static void InputYear(BookModel model,BookView view) {
        view.viewData("Enter year -> ");
        int year = Integer.parseInt(InputData.input());
        if(ConvertorString.convertArrayBook(model.searchByYear(year))!=""){
            view.viewData("List of book after "+year+"\n");
            view.viewData(ConvertorString.convertArrayBook(model.searchByYear(year)));
        }
        else view.viewData("Not found book after "+year+"\n");
    }

}

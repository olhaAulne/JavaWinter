package com.company.controller;

import com.company.model.BookModel;
import com.company.view.BookView;
import com.company.view.InputData;
import com.company.view.MenuView;

public class BookController {
    private BookModel model = new BookModel();
    private BookView view = new BookView();

    public void run() {
        MenuView.viewMenu();
        view.viewData("Enter № option -> ");
        String menuNumber = InputData.input();
        while (!menuNumber.equals("0")) {
            switch (menuNumber) {
                case "1": {
                    InputSearch.InputAuthor(model, view);
                    break;
                }
                case "2": {
                    InputSearch.InputPublisher(model, view);
                    break;
                }
                case "3": {
                    InputSearch.InputYear(model, view);
                    break;
                }
                case "4": {
                    view.viewData(ConvertorString.convertArrayBook(model.sortBook()));
                    break;
                }
                default: {
                    MenuView.viewMenu();
                    view.viewData("Enter № option -> ");
                    break;
                }
            }
        menuNumber = InputData.input();
        }
    }
}

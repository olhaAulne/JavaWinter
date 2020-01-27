package com.bank.menu;

import com.bank.domain.User;
import com.bank.service.UserService;

import java.util.Locale;

public class BankController {
    private final UserService userService;
    private View view = new View();
    private final static ResourceManager manager = ResourceManager.INSTANCE;

    public BankController(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        view.viewData("Choose language EN(English)\\RU(Russian)");
        String lang = InputData.input();
        String country = "";
        String language = "";
        switch (lang.toUpperCase()) {
            case "EN":
                country = "US";
                language = "EN";
                break;
            case "RU":
                country = "RU";
                language = "RU";
                break;
        }
        manager.changeResource(new Locale(language, country));
        view.viewData(manager.getString("mainMenu"));
        String menuNumber = InputData.input();
        while (!menuNumber.equals("0")) {
            switch (menuNumber) {
                case "1": {
                    menuLogin();
                    break;
                }
                case "2": {
                    menuRegister();
                    break;
                }
                default: {
                    view.viewData(manager.getString("mainMenu"));
                    break;
                }
            }
            menuNumber = InputData.input();
        }
    }

    private void menuLogin() {
        view.viewData(manager.getString("enterEmail"));
        String emailInput = InputData.input();
        view.viewData(manager.getString("enterPassword"));
        String passwordInput = InputData.input();
        userService.login(emailInput, passwordInput);
        view.viewData(manager.getString("messageLogin"));
        menuForFind();

    }

    private void menuRegister() {
        view.viewData(manager.getString("enterEmail"));
        String emailInput = InputData.input();
        view.viewData(manager.getString("enterPassword"));
        String passwordInput = InputData.input();
        userService.register(User.builder().withEmail(emailInput).withPassword(passwordInput).build());
        view.viewData(manager.getString("messageRegister"));
    }

    private void menuForFind() {
        view.viewData(manager.getString("loginMenu"));
        String menuNumber = InputData.input();
        while (!menuNumber.equals("0")) {
            switch (menuNumber) {
                case "1": {
                    view.viewData(manager.getString("enterPage"));
                    userService.findAll(Integer.parseInt(InputData.input()));
                    break;
                }
                case "2": {
                    view.viewData(manager.getString("findId"));
                    view.viewData(userService.findById(Integer.parseInt(InputData.input())).toString());
                    break;
                }
                case "3": {
                    view.viewData(manager.getString("findEmail"));
                    view.viewData(userService.findByEmail(InputData.input()).toString());
                    break;
                }
                default: {
                    view.viewData(manager.getString("mainMenu"));
                    break;
                }
            }
            menuNumber = InputData.input();
        }
    }
}

package com.bank.menu;


import com.bank.domain.User;
import com.bank.service.UserService;

public class View {
    private final UserService userService;

    public View(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        MenuItem.mainMenuShow();
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
                    MenuItem.mainMenuShow();
                    break;
                }
            }
            menuNumber = InputData.input();
        }
    }

    private void menuLogin() {
        System.out.println("Enter email");
        String emailInput = InputData.input();
        System.out.println("Enter password");
        String passwordInput = InputData.input();
        userService.login(emailInput, passwordInput);
        System.out.println("You logged in");
        menuForFind();

    }

    private void menuRegister() {
        System.out.println("Enter email");
        String emailInput = InputData.input();
        System.out.println("Enter password");
        String passwordInput = InputData.input();
        userService.register(User.builder().withEmail(emailInput).withPassword(passwordInput).build());
        System.out.println("User registered");
    }

    private void menuForFind() {
        MenuItem.loginMenuShow();
        String menuNumber = InputData.input();
        while (!menuNumber.equals("0")) {
            switch (menuNumber) {
                case "1": {
                    System.out.println("Enter page number");
                    userService.findAll(Integer.parseInt(InputData.input()));
                    break;
                }
                case "2": {
                    System.out.println("Enter user id");
                    System.out.println(userService.findById(Integer.parseInt(InputData.input())));
                    break;
                }
                case "3": {
                    System.out.println("Enter user email");
                    System.out.println(userService.findByEmail(InputData.input()));
                    break;
                }
                default: {
                    MenuItem.mainMenuShow();
                    break;
                }
            }
            menuNumber = InputData.input();
        }
    }

}
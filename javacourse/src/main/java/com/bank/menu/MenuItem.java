package com.bank.menu;

public class MenuItem {

    private static final String mainMenu = "Menu:" +
            "\n1 - to login" +
            "\n2 - to register" +
            "\n0 - to exit\n"+
            "\nEnter № option -> ";

    private static final String loginMenu = "Menu:" +
            "\n1 - to find all users" +
            "\n2 - to find user by id" +
            "\n3 - to find user by email" +
            "\n0 - to exit\n"+
            "\nEnter № option -> ";

    public static void mainMenuShow() {
        System.out.println(mainMenu);
    }

    public static void loginMenuShow() {
        System.out.println(loginMenu);
    }
}

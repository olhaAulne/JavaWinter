package com.bank;


import com.bank.injector.ApplicationInjector;

public class ConsoleApplication {
    public static void main(String[] args) {

        ApplicationInjector injector = ApplicationInjector.getInstance();
        injector.getView().run();
    }
}

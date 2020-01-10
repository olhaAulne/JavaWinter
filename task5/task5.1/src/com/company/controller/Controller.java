package com.company.controller;

import com.company.model.Journal;
import com.company.model.Storage;
import com.company.view.IMenuStrings;
import com.company.view.Menu;

import java.util.Locale;
import java.util.Scanner;

import static com.company.controller.Internationalization.RESOURCE;


public class Controller implements IMenuStrings {

    public void start(){
        Locale.setDefault(new Locale("en", "GB"));

        Menu.greeting();
        Menu.commands();

        String command = "";
        Scanner scanner = new Scanner(System.in);
        command = scanner.next();

        while(!command.equals(RESOURCE.getValue(MENU_EXIT))){

            if(command.equals(RESOURCE.getValue(MENU_ADD))){
                toStorage(enteringData());
            } else if(command.equals(RESOURCE.getValue(MENU_JOURNAL))){

                Menu.showJournal(Storage.INSTANCE.getJournal());
            } else if(command.equals(RESOURCE.getValue(MENU_RU))){

                System.out.println(RESOURCE.getValue(MENU_CHANGING_TO_RU));
                RESOURCE.changeLang(new Locale("ru"));

            } else if(command.equals(RESOURCE.getValue(MENU_EN))){

                System.out.println(RESOURCE.getValue(MENU_CHANGING_TO_EN));
                RESOURCE.changeLang(new Locale("en"));
            }

            Menu.commands();
            command = scanner.next();
        }

    }

    private Journal enteringData(){
        Scanner enter = new Scanner(System.in);

        String lastNameIn;
        do{
            Menu.inviteAddNewStudent();
            lastNameIn = enter.next();
        }while (!InputValidator.isLastNameValid(lastNameIn));

        String firstNameIn;
        do{
            Menu.inviteAddFirstName();
            firstNameIn = enter.next();
        }while (!InputValidator.isFirstNameValid(firstNameIn));

        String birthDateIn;
        do{
            Menu.inviteAddBirthDate();
            birthDateIn = enter.next();
        }while (!InputValidator.isBirthDateValid(birthDateIn));

        String phoneIn;
        do{
            Menu.inviteAddPhone();
            phoneIn = enter.nextLine();
        }while (!InputValidator.isPhoneValid(phoneIn));

        String addressIn;
        do{
            Menu.inviteAddAddress();
            addressIn = enter.nextLine();
        }while (!InputValidator.isAdressValid(addressIn));

        return new Journal(lastNameIn, firstNameIn, birthDateIn, phoneIn, addressIn);
    }

    private void toStorage(Journal entry){
        Storage.INSTANCE.addNewEntry(entry);
    }
}

package com.company.controller;



import com.company.view.IValidationStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.controller.Internationalization.RESOURCE;

public class InputValidator implements IValidationStrings {

    public static String LAST_NAME_REG_EXP = "lastNameRegExp";

    public static String FIRST_NAME_REG_EXP = "firstNameRegExp";

    public static String BIRTH_DATE_REG_EXP = "birthDateRegExp";

    public static String PHONE_REG_EXP = "phoneRegExp";

    public static String ADDRESS_REG_EXP_BY_TASK = "addressRegExpByTask";
    //private static String getAddressRegExpUS = "^\\d{1,5}\\s[A-Z][a-z]*\\s(St|Blvd|Square|Ave)\\s[A-Z][a-z]*,\\s[A-Z]{2}\\s\\d{5},\\sUS";

    public static boolean isLastNameValid(String lastName){
        Pattern pattern = Pattern.compile(RESOURCE.getValue(LAST_NAME_REG_EXP));
        Matcher matcher = pattern.matcher(lastName);

        if(matcher.find()){
            System.out.println(RESOURCE.getValue(VALIDATION_LAST_NAME_OK));
            return true;
        } else {
            System.out.println(RESOURCE.getValue(VALIDATION_LAST_NAME_ERROR));
            return false;
        }
    }

    public static boolean isFirstNameValid(String firstName){
        Pattern pattern = Pattern.compile(RESOURCE.getValue(FIRST_NAME_REG_EXP));
        Matcher matcher = pattern.matcher(firstName);

        if(matcher.find()){
            System.out.println(RESOURCE.getValue(VALIDATION_FIRST_NAME_OK));
            return true;
        } else {
            System.out.println(RESOURCE.getValue(VALIDATION_FIRST_NAME_ERROR));
            return false;
        }
    }

    public static boolean isBirthDateValid(String birthDate){
        Pattern pattern = Pattern.compile(RESOURCE.getValue(BIRTH_DATE_REG_EXP));
        Matcher matcher = pattern.matcher(birthDate);

        if(matcher.find()){
            System.out.println(RESOURCE.getValue(VALIDATION_BIRTH_DATE_OK));
            return true;
        } else {
            System.out.println(RESOURCE.getValue(VALIDATION_BIRTH_DATE_ERROR));
            return false;
        }
    }

    public static boolean isPhoneValid(String phoneNumber){
        Pattern pattern = Pattern.compile(RESOURCE.getValue(PHONE_REG_EXP));
        Matcher matcher = pattern.matcher(phoneNumber);

        if(matcher.find()){
            System.out.println(RESOURCE.getValue(VALIDATION_PHONE_OK));
            return true;
        } else {
            System.out.println(RESOURCE.getValue(VALIDATION_PHONE_ERROR));
            return false;
        }
    }

    public static boolean isAdressValid(String address){
        Pattern pattern = Pattern.compile(RESOURCE.getValue(ADDRESS_REG_EXP_BY_TASK));
        Matcher matcher = pattern.matcher(address);

        if(matcher.find()){
            System.out.println(RESOURCE.getValue(VALIDATION_ADDRESS_OK));
            return true;
        } else {
            System.out.println(RESOURCE.getValue(VALIDATION_ADDRESS_ERROR));
            return false;
        }
    }
}

package com.company.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public enum Internationalization {
    RESOURCE;

    public ResourceBundle resourceBundle;
    private String resourceName = "MenuStrings";

    Internationalization() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeLang(Locale newLoc){
        Locale.setDefault(newLoc);
        resourceBundle = ResourceBundle.getBundle(resourceName, newLoc);
    }

    public String getValue(String key) {
        try {
            return new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


}

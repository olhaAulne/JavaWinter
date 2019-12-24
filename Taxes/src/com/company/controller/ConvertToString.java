package com.company.controller;


public class ConvertToString {
    public static String convertLong(long value, String message) {
        return  String.format("%s = %d\n", message, value);
    }

    public static String convertInt(int value, String message) {
        return  String.format("%s = %d\n", message, value);
    }
}

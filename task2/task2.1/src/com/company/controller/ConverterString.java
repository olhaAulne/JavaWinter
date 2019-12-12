package com.company.controller;

import com.company.model.entity.Shape;

public class ConverterString {
    public static String convertArraySahpes(Shape[] shapes){
        String res = "";
        for (Shape el:shapes) {
            res +=el.draw();
        }
        return res;
    }

    public static String convertDouble(double value, String message) {
        return  String.format("%s = %.2f\n", message, value);
    }
}

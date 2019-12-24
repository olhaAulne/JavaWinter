package com.company.view;

import java.util.Scanner;

/**
 * Class for data input
 */

public class InputData {
    private static Scanner sc = new Scanner (System.in);
    public static String input() {
        return sc.next();
    }
}

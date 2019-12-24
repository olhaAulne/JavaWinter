package com.company.view;

import java.util.Collection;

/**
 * Class for displaying data
 */

public class TaxView {
    public void viewData (String text){
        System.out.print(text);
    }
    public void viewCollection (Collection<String> taxes){
        taxes.forEach(System.out::println);
    }
}

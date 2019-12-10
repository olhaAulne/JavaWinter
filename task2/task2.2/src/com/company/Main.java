package com.company;

import java.util.Random;
import java.util.Arrays;

public class Main {
    public static Book [] create (int n){
        Book [] bookArray = new Book[n];
        Random rnd = new Random();
        for (int i=0; i<n; i++){
            bookArray[i] = new Book ("Title"+(i+1),"Author"+(i+1),"Publisher"+(i+1),
                    rnd.nextInt(220) + 1800,
                    rnd.nextInt(1000) + 10,
                    rnd.nextInt(1000) + 10 + rnd.nextDouble());
        }
        return bookArray;
    }

    public static void show (Book [] array){
        for (Book i: array) {
            System.out.println(i.toString());
        }
    }


    public static void main(String[] args) {
        Book [] bookArray = create(10);
        show(bookArray);
        Arrays.sort(bookArray, new PublisherComparator());
        System.out.println("Sorted by publisher");
        show(bookArray);


    }
}

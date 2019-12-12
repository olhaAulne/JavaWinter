package com.company.model;

import java.util.Random;

public class DataSourseBook {


    public static Book[] getArrayBook (){
        int n=10;
        Book [] bookArray = new Book[n];
        Random rnd = new Random();
        bookArray[0] = new Book ("Pride and Prejudice","Jane Austen","Pearson",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[1] = new Book ("Jane Eyre","Charlotte Bronte","McGraw-Hill Education",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[2] = new Book ("Animal Farm","George Orwell","Oxford University Press",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[3] = new Book ("The Picture of Dorian Gray","Oscar Wilde","Prentice Hall",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[4] = new Book ("Hamlet","William Shakespeare","Cambridge University Press",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[5] = new Book ("Great Expectations","Charles Dickens","Cambridge University Press",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[6] = new Book ("Don Quixote","Miguel De Cervantes","Pearson",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[7] = new Book ("Robinson Crusoe","Daniel Defo","Oxford University Press",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[8] = new Book ("Emma","Jane Austen","McGraw-Hill Education",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());
        bookArray[9] = new Book ("Vanity Fair","William Thackeray","Pearson",
                rnd.nextInt(220) + 1800,rnd.nextInt(1000) + 10, rnd.nextInt(1000) + 10 + rnd.nextDouble());

        return bookArray;
    }
}

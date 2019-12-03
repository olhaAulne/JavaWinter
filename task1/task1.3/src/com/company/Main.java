package com.company;

public class Main {
    public static void pyramide(int lenth) {

        for(int row = 1; row <= lenth; row++) {
            for(int space = 0; space < lenth-row; space++) {
                System.out.print(" ");
            }
            for(int desc = row; desc > 1; desc--) {
                System.out.print(desc);
            }
            for(int asc = 1; asc <= row; asc++) {
                System.out.print(asc);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        pyramide(5);
    }
}

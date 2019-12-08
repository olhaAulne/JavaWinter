package com.company;

public class Main {
     public static String toBinary (int n){
         String rez = "";
         while(n!=0){
             if(n%2==0){
                 rez+="0";
            }
            else rez+="1";
            n=n/2;
         }
         rez = reverse(rez);
         return rez;
    }

    public static String toOctal (int n){
        String rez = "";
        while(n!=0){
            if(n%8==0){
                rez+="0";
            }
            else rez+=n%8;
            n=n/8;
        }
        rez = reverse(rez);
        return rez;
    }

    public static String toHexademical(int n) {
        String rez = "";
        while (n != 0) {
            if (n % 16 < 10) {
                rez += n % 16;
            } else {
                char symbol = 'A';
                symbol += (n % 16 - 10);
                rez += symbol;
            }
            n = n / 16;
        }
        rez = reverse(rez);
        return rez;
    }
    public static String reverse(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(a.length - 1) - i] = a[i];
        }
        return new String(b);
    }

    public static void main(String[] args) {
        int number = 500;
        System.out.println("Десятичная: "+number);
        System.out.println("Двоичная: "+toBinary(number));
        System.out.println("Восьмиричная: "+toOctal(number));
        System.out.println("Шестнадцатиричная: "+toHexademical(number));

    }
}

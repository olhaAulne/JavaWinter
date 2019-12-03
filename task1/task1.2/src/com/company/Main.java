package com.company;

public class Main {


    public static String perfectNumber(int range){
        String rez = "";
        int i,j,sum;
        for(i=2;i<=range;i++){
            sum=0;
            for(j=1;j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            if(sum==i){
                rez=rez+i+" ";
            }
        }
        return rez;
    }

    public static void main(String[] args) {
        int range = 10000;
        System.out.println(perfectNumber(range));
    }
}

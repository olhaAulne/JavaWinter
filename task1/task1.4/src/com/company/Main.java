package com.company;

import java.util.Random;

public class Main {
    public static int [][] createMatrix (int n){
        int [][] matrix = new int[n][n];
        Random rnd = new Random();
        for (int i=0;i < matrix.length;i++) {
            for (int j=0;j < matrix[i].length;j++) {
                matrix[i][j]=rnd.nextInt(21) - 10;
            }
        }
        return matrix;
    }
    public static void showMatrix (int [][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int [][] rotateMatrix ( int [][] array){
        int n = array.length;
        int tmp;
        for (int i=0;i<n/2;i++){
            for (int j=i;j<n-1-i;j++){
                tmp = array[i][j];
                array[i][j ]= array[j][n-1-i];
                array[j][n-1-i] = array[n-1-i][n-1-j];
                array[n-1-i][n-1-j] = array[n-1-j][i];
                array[n-1-j][i] = tmp;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int n=4;
        int [][] matrix = createMatrix(n);
        System.out.println("Исходная матрица");
        showMatrix(matrix);
        System.out.println("Поворот");
        showMatrix(rotateMatrix(matrix));

    }
}

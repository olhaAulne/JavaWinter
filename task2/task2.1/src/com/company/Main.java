package com.company;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {

    public static Shape [] create (){
        Shape [] shapeArray = new Shape[12];
        shapeArray[0] = new Rectangle("RED", 10, 4);
        shapeArray[1] = new Rectangle("GREEN", 15, 20);
        shapeArray[2] = new Rectangle("YELLOW", 12, 12);
        shapeArray[3] = new Rectangle("BLUE", 7, 3);
        shapeArray[4] = new Triangle("RED", 5, 3, 6);
        shapeArray[5] = new Triangle("GREEN", 12, 10, 7);
        shapeArray[6] = new Triangle("YELLOW", 21, 15, 9);
        shapeArray[7] = new Triangle("BLUE", 13, 4, 14);
        shapeArray[8] = new Circle("RED", 5);
        shapeArray[9] = new Circle("GREEN", 11);
        shapeArray[10] = new Circle("YELLOW", 7);
        shapeArray[11] = new Circle("BLUE", 25);
        return shapeArray;
    }

    public static void show (Shape [] array){
        for (Shape i: array) {
            System.out.println(i.draw());
        }
    }

    public static double areaAll (Shape [] array){
        double area = 0;
        for (Shape i: array) {
            area+=i.calcArea();
        }
        return new BigDecimal(area).setScale(2, RoundingMode.UP).doubleValue();
    }

    public static double typeArea (Shape [] array, String typeShape){
        double area = 0;
        for (Shape i: array) {
            if( typeShape.equals(i.getClass().getSimpleName())){
                area+=i.calcArea();
            }
        }
        return new BigDecimal(area).setScale(2, RoundingMode.UP).doubleValue();
    }


    public static void main(String[] args) {
        Shape [] shapeArray = create();
        show(shapeArray);
        System.out.println("The area of all figures " + areaAll(shapeArray));
        System.out.println("The area of all Circle " + typeArea(shapeArray, "Circle"));
        Arrays.sort(shapeArray, new AreaComparation());
        System.out.println("Sorted by area");
        show(shapeArray);
        Arrays.sort(shapeArray, new ColorComparation());
        System.out.println("Sorted by color");
        show(shapeArray);

    }
}

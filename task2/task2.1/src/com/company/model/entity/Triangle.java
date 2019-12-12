package com.company.model.entity;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(String colorShape, double a, double b, double c) {
        super(colorShape);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return super.toString()+ ", a=" + a + ", b=" + b + ", c=" + c ;
    }

    @Override
    public double calcArea() {
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }


}

package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {
    private double r;

    public Circle(String colorShape, double r) {
        super(colorShape);
        this.r = r;
    }

    @Override
    public String toString() {
        return super.toString() + ", w=" + r ;
    }

    @Override
    public double calcArea() {
        return Math.PI*Math.pow(r,2);
    }

    @Override
    public String draw() {
        double s = new BigDecimal(calcArea()).setScale(2, RoundingMode.UP).doubleValue();
        String str = this+"; area="+s;
       // System.out.printf("%s; area=%.2f\n", this, calcArea());
        return str;
    }
}

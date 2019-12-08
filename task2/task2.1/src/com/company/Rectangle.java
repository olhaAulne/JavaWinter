package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle extends Shape {
    private double w;
    private double h;

    public Rectangle(String colorShape, double w, double h) {
        super(colorShape);
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", w=" + w + ", h=" + h ;
    }

    @Override
    public double calcArea() { return w * h;}

    @Override
    public String draw() {
        double s = new BigDecimal(calcArea()).setScale(2, RoundingMode.UP).doubleValue();
        String str = this+"; area="+s;
      //  System.out.printf("%s; area=%.2f\n", this, calcArea());
        return str;
    }
}

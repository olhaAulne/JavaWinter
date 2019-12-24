package com.company.model.entity;

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

    public static Circle parseShape(String data) {
        String[] tokens = data.split("[:,]");
        return new Circle(tokens[1],
                Double.parseDouble(tokens[2]));
    }
}

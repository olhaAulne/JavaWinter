package com.company;

public abstract class Shape implements Drawable {
    private String colorShape;

    public Shape(String colorShape) {
        this.colorShape = colorShape;
    }

    public String getColorShape() {
        return colorShape;
    }

    public void setColorShape(String colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": colorShape=" + colorShape;
    }
    public abstract double calcArea();
}

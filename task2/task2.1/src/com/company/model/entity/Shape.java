package com.company.model.entity;

import com.company.model.Drawable;

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

    @Override
    public String draw() {
        return String.format("%s; area=%.2f\n", this, calcArea());
    }

    public abstract double calcArea();
}

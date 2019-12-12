package com.company.model;

import com.company.model.entity.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeModel {
    private Shape[] shapes;

    public Shape[] getShapes() {
        return shapes;
    }

    public ShapeModel() {
        shapes = DataSourseShapes.getArrayShapes();
    }

    public double areaAll (){
        double area = 0.0;
        for (Shape i: shapes) {
            area += i.calcArea();
        }
        return area;
    }

    public double typeArea (String typeShape){
        double area = 0.0;
        for (Shape i: shapes) {
            if( typeShape.equalsIgnoreCase(i.getClass().getSimpleName())){
                area+=i.calcArea();
            }
        }
        return area;
    }

    public  Shape [] sortShapes (Comparator compatrator){
        Shape [] newShapes = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(newShapes, compatrator);
        return newShapes;
    }

}

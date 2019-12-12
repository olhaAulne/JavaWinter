package com.company.model;

import com.company.model.entity.Circle;
import com.company.model.entity.Rectangle;
import com.company.model.entity.Shape;
import com.company.model.entity.Triangle;

public class DataSourseShapes {
    public static Shape[] getArrayShapes (){
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
}

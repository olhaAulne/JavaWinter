package com.company.controller;

import com.company.model.ShapeModel;
import com.company.model.entity.Shape;
import com.company.view.InputData;
import com.company.view.ShapeView;

import java.util.Comparator;

public class InputType {

    public static void InputShapeType(ShapeModel model,ShapeView view){
        view.viewData("Enter type shape -> ");
        String type = InputData.input();
        view.viewData(ConverterString.convertDouble(model.typeArea(type), type + " area"));
    }
    public static void InputSortType(ShapeModel model,ShapeView view){
        view.viewData("Enter criteria sorting (area, color)-> ");
        String criteria = InputData.input().toLowerCase();
        Comparator comparator = null;
        switch (criteria) {
            case "area":
                comparator = new Comparator<Shape>() {
                    @Override
                    public int compare(Shape o, Shape t1) {
                        return (int) (o.calcArea() - t1.calcArea());
                    }
                }; break;
            case "color":
                comparator = new Comparator<Shape>() {
                    @Override
                    public int compare(Shape o, Shape t1) {
                        return o.getColorShape().compareTo(t1.getColorShape());
                    }
                }; break;
        }
        if(comparator != null){
            view.viewData(ConverterString.convertArraySahpes(model.sortShapes(comparator)));
        }
        else {
            view.viewData("Invalid criteria!!!");
        }
    }

}

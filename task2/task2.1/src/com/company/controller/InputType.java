package com.company.controller;

import com.company.model.AreaComparation;
import com.company.model.ColorComparation;
import com.company.model.ShapeModel;
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
            case "area": comparator = new AreaComparation(); break;
            case "color": comparator = new ColorComparation(); break;
        }
        if(comparator != null){
            view.viewData(ConverterString.convertArraySahpes(model.sortShapes(comparator)));
        }
        else {
            view.viewData("Invalid criteria!!!");
        }
    }

}

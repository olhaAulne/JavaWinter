package com.company.model;

import com.company.model.entity.Shape;

import java.util.Comparator;

public class AreaComparation implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Shape s1=(Shape)o;
        Shape s2=(Shape)t1;
        return (int) (s1.calcArea() - s2.calcArea()) ;
    }
}

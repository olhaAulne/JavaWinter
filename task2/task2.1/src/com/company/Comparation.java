package com.company;

import java.util.Comparator;

class AreaComparation implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Shape s1=(Shape)o;
        Shape s2=(Shape)t1;
        if (s1.calcArea() > s2.calcArea()) return -1;
        if (s1.calcArea() < s2.calcArea()) return 1;
        return 0;
    }
}

class ColorComparation implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        String name1 = ((Shape)o).getColorShape();
        String name2 = ((Shape)t1).getColorShape();
        return name1.compareTo(name2);
    }
}
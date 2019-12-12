package com.company.model;

import com.company.model.entity.Shape;

import java.util.Comparator;


   public class ColorComparation implements Comparator {
       @Override
       public int compare(Object o, Object t1) {
           String name1 = ((Shape) o).getColorShape();
           String name2 = ((Shape) t1).getColorShape();
           return name1.compareTo(name2);
       }
   }


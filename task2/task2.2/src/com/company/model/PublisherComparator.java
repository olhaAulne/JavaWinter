package com.company.model;

import com.company.model.Book;

import java.util.Comparator;

public class PublisherComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String name1 = ((Book)o1).getPublisher();
        String name2 = ((Book)o2).getPublisher();
        return name1.compareTo(name2);
    }
}

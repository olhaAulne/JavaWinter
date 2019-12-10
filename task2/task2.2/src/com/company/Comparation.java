package com.company;

import java.util.Comparator;

class AuthorComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String name1 = ((Book)o1).getAuthor();
        String name2 = ((Book)o2).getAuthor();
        return name1.compareTo(name2);
    }
}

class YearComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Book b1=(Book)o1;
        Book b2=(Book)o2;
        return b1.getYear()-b2.getYear();
    }
}

class PublisherComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String name1 = ((Book)o1).getPublisher();
        String name2 = ((Book)o2).getPublisher();
        return name1.compareTo(name2);
    }
}

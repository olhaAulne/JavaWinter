package org.lesson3;

@FunctionalInterface
public interface MyInterface {
    int A = 10;

    void method();

    default void method1(){

    }

    static int counter (int i){
        return i;
    }

}

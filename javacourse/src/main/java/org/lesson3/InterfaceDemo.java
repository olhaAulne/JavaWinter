package org.lesson3;

import java.util.function.Function;

public class InterfaceDemo {
    public static void main(String[] args) {
        final MyInterface myInterface = new MyInterface() {
            public void method() {
                System.out.println("anonymus");
            }
        };

        MyInterface lambda = () -> System.out.println("lambda anonymus");

        myInterface.method();
        lambda.method();
        OneParameter<String> oneParameter = message->System.out.println(message.isEmpty());
        TwoParameter twoParameter = ( message, n) -> {
            for (int i=0; i<n;i++){
            System.out.println(message);}
        };


    }
}

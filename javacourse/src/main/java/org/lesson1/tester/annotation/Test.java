package org.lesson1.tester.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    Class<? extends Throwable> expectedException() default Default.class;
    String expectedMessage() default "";

    class Default extends Throwable {
        private Default(){}
    };

}

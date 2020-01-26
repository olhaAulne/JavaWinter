package org.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class Calculator {
    private static final Map<String, ToIntBiFunction<Integer,Integer>> OPERATOR_TO_OPERATON = new HashMap<>();
    static {
        OPERATOR_TO_OPERATON.put("+", Integer::sum);
        OPERATOR_TO_OPERATON.put("-", (a,b)->a-b);
    }

    public int calculate(int a, String operator, int b){

        return OPERATOR_TO_OPERATON.get(operator).applyAsInt(a,b);

    }
}



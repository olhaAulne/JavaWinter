package org.lesson1;


import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class CalculationTest {
    @Parameterized.Parameter(value = 0)
    public int numberA;

    @Parameterized.Parameter(value = 1)
    public String operator;

    @Parameterized.Parameter(value = 2)
    public int numberB;

    @Parameterized.Parameter(value = 3)
    public int expected;

    @Parameterized.Parameters(name = "{index}: testCalculate({0}{1}{2}) = {3}")
    public static Collection<Object []> data(){
        return Arrays.asList(new Object[][]{
                {1, "+", 1, 2},
                {2, "+", 3, 5},
                {8, "-",2 ,6},
                {2, "-",3 ,-1},
                {5, "*",2 ,10},
                {-2, "*",2 ,-4},
                {8, "/", 4, 2},
        });
    }


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Calculator calculator;



    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void calcTest() {
        assertThat(calculator.calc(numberA,operator,numberB), is(expected));
    }

    @Test
    public void calcShouldThrowIllegalArgumentExceptionWhenOperatorIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Operator is null");
        calculator.calc(1, null, 3);
    }

    @Test
    public void calcShouldThrowIllegalArgumentExceptionWhenOperatorIsNotExpected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Operator is not expected");
        calculator.calc(1, "%", 3);
    }
}

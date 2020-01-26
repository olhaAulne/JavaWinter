package homework.fibonacci;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static homework.fibonacci.Fibonacci.fibonacci;
import static homework.fibonacci.Fibonacci.fibonacciRecursion;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class FibonacciTest {
    @Parameterized.Parameter(value = 0)
    public int number;

    @Parameterized.Parameter(value = 1)
    public long expected;

    @Parameterized.Parameters(name = "{index}: testFibonacci {0} = {1}")
    public static Collection<Object []> data(){
        return Arrays.asList(new Object[][]{
                {11, 89},
                {5, 5},
                {20, 6765},
                {40, 102334155},
                {0, 0}
        });
    }

    @Test
    public void fibonacciRecursionTest() {
        assertThat(fibonacciRecursion(number), is(expected));
    }

    @Test
    public void fibonacciTest() {
        assertThat(fibonacci(number), is(expected));
    }


}
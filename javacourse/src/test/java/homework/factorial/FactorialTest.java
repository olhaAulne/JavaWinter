package homework.factorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class FactorialTest {
    @Parameterized.Parameter(value = 0)
    public int number;

    @Parameterized.Parameter(value = 1)
    public BigInteger expected;

    @Parameterized.Parameters(name = "{index}: testFactorial {0} = {1}")
    public static Collection<Object []> data(){
        return Arrays.asList(new Object[][]{
                {0, BigInteger.valueOf(1)},
                {1, BigInteger.valueOf(1)},
                {3, BigInteger.valueOf(6)},
                {8, BigInteger.valueOf(40_320)},
                {10, BigInteger.valueOf(3_628_800)},
                {12, BigInteger.valueOf(479_001_600)}
        });
    }

    @Test
    public void factorialTest() {
        assertThat(Factorial.factorial(number), is(expected));
    }

    @Test
    public void factTreeTest() {
        assertThat(Factorial.factTree(BigInteger.valueOf(number)), is(expected));
    }
}
package homework.factorial;

import java.math.BigInteger;

import static homework.factorial.Factorial.*;

public class Main {
    public static void main (String[] args) {
        System.out.println(factorial(4));
        System.out.println(factTree(BigInteger.valueOf(4)));
    }
}

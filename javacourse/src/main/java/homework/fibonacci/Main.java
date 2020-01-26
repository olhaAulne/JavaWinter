package homework.fibonacci;


import static homework.fibonacci.Fibonacci.fibonacci;
import static homework.fibonacci.Fibonacci.fibonacciRecursion;

public class Main {
    public static void main (String[] args) {
        System.out.println(fibonacciRecursion(40));
        System.out.println(fibonacci(20));
    }
}

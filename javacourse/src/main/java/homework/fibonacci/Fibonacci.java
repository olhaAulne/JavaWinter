package homework.fibonacci;

public class Fibonacci {

    static long fibonacciRecursion(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    static long fibonacci(int n) {
        int n0 = 1;
        int n1 = 1;
        int rez = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
           for (int i=3; i<=n; i++) {
               rez = n0+n1;
               n0 = n1;
               n1 = rez;
           }
           return rez;
        }
    }

}

package homework.factorial;


import java.math.BigInteger;

public class Factorial {
    static BigInteger factorial(int n)
    {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= n; ++i){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }

    static BigInteger prodTree(BigInteger l, BigInteger r)
    {
        if (r.compareTo(l) == -1)
            return BigInteger.valueOf(1);
        if (r.compareTo(l) == 0)
            return l;
        if (r.subtract(l).compareTo(BigInteger.valueOf(1)) == 0)
            return l.multiply(r);
        BigInteger m = l.add(r).divide(BigInteger.valueOf(2));
        return prodTree(l, m).multiply(prodTree(m.add(BigInteger.valueOf(1)), r)) ;
    }

    static BigInteger factTree(BigInteger n)
    {
        if (n.compareTo(BigInteger.valueOf(0)) == -1)
            return BigInteger.valueOf(0);
        if (n.compareTo(BigInteger.valueOf(0)) == 0)
            return BigInteger.valueOf(1);
        if (n.compareTo(BigInteger.valueOf(1)) == 0 || n.compareTo(BigInteger.valueOf(2)) == 0)
            return n;
        return prodTree(BigInteger.valueOf(2), n);
    }
}

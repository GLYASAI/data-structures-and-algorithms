package org.abewang.iq.rdp;

/**
 * 求n的阶乘
 *
 * @Author Abe
 * @Date 2018/6/10.
 */
public class Factorial {
    public static long getFactorial(long n) {
        if (n == 0L) {
            return 1L;
        }

        return n * getFactorial(n -1);
    }

    public static long getFactorial2(long n) {
        if (n == 0L) {
            return 1L;
        }

        long res = 1L;
        for (;n > 0L; n--) {
            res *= n;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(getFactorial(n));
        System.out.println(getFactorial2(n));
    }
}

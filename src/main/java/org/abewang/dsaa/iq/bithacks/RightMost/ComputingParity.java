package org.abewang.dsaa.iq.bithacks.RightMost;

/**
 * Computing parity of a number.
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class ComputingParity {

    public static boolean computing(int n) {
        boolean res = false;

        while (n != 0) {
            res = !res;

            n = n & (n - 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Parity of " + n + " is " + (computing(n) ? "odd." : "even."));
    }
}

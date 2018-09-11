package org.abewang.dsaa.iq.bithacks.kthbit;

/**
 * Check k'th bit is set for a number.
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class CheckKth {

    public static boolean isKthBitSet(int num, int k) {
        return (num & (1 << k - 1)) != 0;
    }

    public static void main(String[] args) {
        int num = 20, k = 3;
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
        if (isKthBitSet(num, k)) {
            System.out.println(k + "-th bit is set.");
        } else {
            System.out.println(k + "-th bit isn't set.");
        }
    }
}

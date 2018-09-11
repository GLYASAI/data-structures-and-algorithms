package org.abewang.dsaa.iq.bithacks.kthbit;

/**
 * Turn on k'th bit in a number
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class TurnOnKth {
    public static void turnOffKth(int num, int k) {
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
        System.out.println("turn k'th bit on.");
        num |= 1 << k - 1;
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
    }

    public static void main(String[] args) {
        turnOffKth(16, 3);
    }
}

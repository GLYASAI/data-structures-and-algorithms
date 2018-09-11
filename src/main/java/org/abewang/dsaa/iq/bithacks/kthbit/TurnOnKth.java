package org.abewang.dsaa.iq.bithacks.kthbit;

/**
 * turn on k'th bit in a number
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class TurnOnKth {
    public static void turnOffKth(int num, int k) {
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
        num |= 1 << k - 1;
        System.out.println("turn k'th bit on.");
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
    }

    public static void main(String[] args) {
        turnOffKth(16, 3);
    }
}

package org.abewang.dsaa.iq.bithacks.kthbit;

/**
 * Toggle the k'th bit.
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class ToggleKth {

    public static int toggleKthBit(int num, int k) {
            return num ^ (1 << k - 1);
    }

    public static void main(String[] args) {
        int num = 20, k = 3;
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
        System.out.println("Toggle the " + k + "'th bit.");
        num = toggleKthBit(num, k);
        System.out.println(num + " in binary is " + Integer.toBinaryString(num));
    }
}

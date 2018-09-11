package org.abewang.dsaa.iq.bithacks.basic;

/**
 * swap two integers without using any third variable.
 *
 * x ^ x = 0
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class Swap {

    public static void swap(int a, int b) {
        System.out.println("before swap: a = " + a + "; b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("after swap: a = " + a + "; b = " + b);
    }

    public static void main(String[] args) {
        swap(3, 4);
    }
}

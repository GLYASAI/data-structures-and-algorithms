package org.abewang.dsaa.iq.bithacks;

/**
 * @Author Abe
 * @Date 2018/9/11.
 */
public class EvenOrOdd {
    public static void evenOrOdd(int a) {
        if ((a & 1) == 0) {
            System.out.println(a + " is even.");
        } else {
            System.out.println(a + " is odd.");
        }
    }

    public static void main(String[] args) {
        evenOrOdd(5);
    }
}

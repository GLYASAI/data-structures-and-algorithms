package org.abewang.dsaa.iq.bithacks.basic;

/**
 * detect if two integers have opposite signs or not.
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class OppositeSigns {
    public static void ifHaveOppositeSigns(int a, int b) {
        if ((a ^ b) < 0) {
            System.out.println(a + " and " + b + " have opposite signs.");
        } else {
            System.out.println(a + " and " + b + " don't have opposite signs.");
        }
    }

    public static void main(String[] args) {
        ifHaveOppositeSigns(4, 8);
        ifHaveOppositeSigns(4, -8);
        ifHaveOppositeSigns(-4, -8);
    }
}

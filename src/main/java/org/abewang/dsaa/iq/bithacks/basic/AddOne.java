package org.abewang.dsaa.iq.bithacks.basic;

/**
 * Add 1 to a given integer
 *
 * -x = ~x + 1, x + 1 = -~x
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class AddOne {

    public static void addOne(int a) {
        System.out.println(a + " add 1 is " + -~a);
    }

    public static void main(String[] args) {
        addOne(5);
        addOne(-5);
        addOne(0);
    }
}

package org.abewang.dsaa.iq.foobar;

/**
 * 求一个整数中二进制1的个数
 *
 * @Author Abe
 * @Date 2018/9/4.
 */
public class NumberOfOne {
    public static int getOneNum(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);  // 有多少个1, 就可以进行多少次这个操作.
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String temp = Integer.toBinaryString(-1);
        System.out.println(temp);
        System.out.println(getOneNum(-1));
    }
}

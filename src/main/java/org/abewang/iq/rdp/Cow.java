package org.abewang.iq.rdp;

/**
 * @Author Abe
 * @Date 2018/6/16.
 */
public class Cow {
    public static int count(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2 || n ==3) {
            return n;
        }

        return count(n - 1) + count(n - 3);
    }

    public static int count2(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2 || n ==3) {
            return n;
        }

        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp;
        int tmp2;
        for (int i = 4; i <= n; i++) {
            tmp = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp;
            prepre = tmp2;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(count(n));
        System.out.println(count2(n));
    }
}

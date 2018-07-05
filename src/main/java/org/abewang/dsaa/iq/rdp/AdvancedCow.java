package org.abewang.dsaa.iq.rdp;

/**
 * 进阶母牛问题
 *
 * @Author Abe
 * @Date 2018/6/16.
 */
public class AdvancedCow {
    public static int count(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2 || n ==3) {
            return n;
        }

        return count(n - 1) + count(n - 3) - 2 * count(n - 10);
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
        int n = 12;
        System.out.println(count(n));
        System.out.println(count2(n));
    }
}

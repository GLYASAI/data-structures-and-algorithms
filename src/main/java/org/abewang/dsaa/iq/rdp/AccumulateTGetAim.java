package org.abewang.dsaa.iq.rdp;

/**
 * 题目八: 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false
 *
 * @Author Abe
 * @Date 2018/9/10.
 */
public class AccumulateTGetAim {
    /**
     * 递归版本
     */
    public static boolean canGetAimRec(int[] arr, int aim, int sum, int idx) {
        if (idx == arr.length) {
            return aim == sum;
        }

        return canGetAimRec(arr, aim, sum, idx + 1) || canGetAimRec(arr, aim, sum + arr[idx], idx + 1);
    }

    public static boolean canGetAim(int[] arr, int aim) {
        boolean[][] res = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < aim; i++) {
            res[arr.length][i] = false;
        }
        for (int i = 0; i <= arr.length; i++) {
            res[i][aim] = true;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < aim; j++) {
                boolean a = res[i + 1][j];
                boolean b = false;
                if (j + arr[i] <= aim) {
                    b = res[i + 1][j + arr[i]];
                }
                res[i][j] = a || b;
            }
        }

        return res[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8};
        int aim = 10;
        System.out.println(canGetAimRec(arr, aim, 0, 0));
        System.out.println(canGetAim(arr, aim));
    }
}

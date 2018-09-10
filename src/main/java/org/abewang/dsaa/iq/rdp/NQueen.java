package org.abewang.dsaa.iq.rdp;

/**
 * N皇后问题
 * N皇后问题是指在NxN的棋盘要摆N个皇后, 要求任何两个皇后不同行, 不同列,
 * 也不在同一条斜线上. 给定一个整数n, 返回n皇后的摆法有多少种.
 *
 * @Author Abe
 * @Date 2018/9/7.
 */
public class NQueen {

    public int num(int n) {
        if (n < 1) {
            return 0;
        }

        int[] record = new int[n];
        return process(0, record, n);
    }

    public int process(int i, int[] record, int n) {
        if (i == n) {  // i已经超过n + 1行了, 说明成功了, 计数+1
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, record)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }

        return res;
    }

    public boolean isValid(int i, int j, int[] record) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || (Math.abs(i - k) == Math.abs(j - record[k]))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueen nq = new NQueen();
        System.out.println(nq.num(8));
    }
}

package org.abewang.dsaa.iq.hash;

/**
 * 岛问题
 *
 * @Author Abe
 * @Date 2018/6/10.
 */
public class Islands {
    public static int count(int[][] arr) {
        if (arr == null) {
            return 0;
        }

        int r = arr.length;
        int c = arr[0].length;
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr, i, j, r, c);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] arr, int i, int j, int r, int c) {
        if (i < 0 || i > r - 1 || j < 0 || j > c || arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 2;
        infect(arr, i - 1, j, r, c);
        infect(arr, i + 1, j, r, c);
        infect(arr, i, j - 1, r, c);
        infect(arr, i, j + 1, r, c);
    }

    public static void main(String[] args) {
        int[][] m1 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(count(m1));

        int[][] m2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(count(m2));
    }
}

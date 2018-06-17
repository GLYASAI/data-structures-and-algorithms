package org.abewang.iq.rdp;

import java.util.Arrays;

/**
 * 最小的路径和
 *
 * @Author Abe
 * @Date 2018/6/16.
 */
public class MinPath {
    public static int getMinPath(int[][] mat, int r, int c) {
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            return mat[r][c];
        }
        if (r == mat.length -1) {
            return mat[r][c] + getMinPath(mat, r, c + 1);
        }
        if (c == mat[0].length - 1) {
            return mat[r][c] + getMinPath(mat, r + 1, c);
        }
        return mat[r][c] + Math.min(getMinPath(mat, r, c + 1), getMinPath(mat, r + 1, c));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] res = new int[col + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[1] = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // res[j]没有更新前表示第i-1行第j个元素的最小路径和
                // res[j - 1]表示第i行第j-1个元素的最小路径和
                res[j] = Math.min(res[j], res[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return res[col];
    }

    public static void main(String[] args) {
//        int[][] mat = {
//                {0, 1, 4, 7},
//                {5, 1, 2, 1},
//                {3, 0, 8, 1}
//        };
        int[][] mat = {{0}};
        System.out.println(getMinPath(mat, 0, 0));
        System.out.println(minPathSum(mat));
    }
}

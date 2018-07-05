package org.abewang.dsaa.iq;

/**
 * 逆时针旋转正方形矩阵
 *
 * @Author Abe
 * @Date 2018/5/5.
 */
public class RotateMatrix {
    public static void rotateMatrix(int[][] arr) {
        if (arr == null || arr.length != arr[0].length) {
            System.out.println("require square matrix");
            return;
        }

        int tRow = 0;
        int tCol = 0;
        int dRow = arr.length - 1;
        int dCol = arr.length - 1;
        rotateEdge(arr, tRow, tCol, dRow, dCol);
    }

    public static void rotateEdge(int[][] arr, int tRow, int tCol, int dRow, int dCol) {
        while (tRow < dRow && tCol < dCol) {
            int time = dCol - tCol;
            for (int i = 0; i < time; i++) {
                int tmp = arr[tRow][tCol + i];
                arr[tRow][tCol + i] = arr[tRow + i][dCol];
                arr[tRow + i][dCol] = arr[dRow][dCol - i];
                arr[dRow][dCol - i] = arr[dRow - i][tCol];
                arr[dRow - i][tCol] = tmp;
            }
            tRow++; tCol++;
            dRow--; dCol--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        rotateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

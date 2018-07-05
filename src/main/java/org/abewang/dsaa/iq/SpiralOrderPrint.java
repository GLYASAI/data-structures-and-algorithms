package org.abewang.dsaa.iq;

/**
 * 转圈打印矩阵
 *
 * @Author Abe
 * @Date 2018/5/3.
 */
public class SpiralOrderPrint {
    public static void spiralOrderPrint(int[][] mat) {
        int tRow = 0;
        int tCol = 0;
        int dRow = mat.length - 1;
        int dCol = mat[0].length - 1;
        while (tRow <= dRow && tCol <= dCol) {
            printEdge(mat, tRow++, tCol++, dRow--, dCol--);
        }
    }

    private static void printEdge(int[][] mat, int tRow, int tCol, int dRow, int dCol) {
        if (tRow == dRow) {
            for (int i = tCol; i <= dCol; i++) {
                System.out.print(mat[tRow][i]);
                System.out.print(" ");
            }
        } else if (tCol == dCol) {
            for (int i = tRow; i <= dRow; i++) {
                System.out.print(mat[i][dRow]);
                System.out.print(" ");
            }
        } else {
            int curRow = tRow;
            int curCol = tCol;
            while (curCol != dCol) {
                System.out.print(mat[curRow][curCol]);
                System.out.print(" ");
                curCol++;
            }
            while (curRow != dRow) {
                System.out.print(mat[curRow][curCol]);
                System.out.print(" ");
                curRow++;
            }
            while (curCol != tCol) {
                System.out.print(mat[curRow][curCol]);
                System.out.print(" ");
                curCol--;
            }
            while (curRow != tRow) {
                System.out.print(mat[curRow][curCol]);
                System.out.print(" ");
                curRow--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }
}

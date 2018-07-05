package org.abewang.dsaa.iq;

/**
 * “之” 字形打印矩阵
 *
 * @Author Abe
 * @Date 2018/5/5.
 */
public class ZigZagPrintMatrix {
    public static void zigZagPrintMatrix(int[][] matrix) {
        boolean fromTop = false;
        int tRow = 0;
        int tCol = 0;
        int dRow = 0;
        int dCol = 0;
        int eRow = matrix.length - 1;
        int eCol = matrix[0].length - 1;
        while (tRow != eRow + 1) {
            printBias(matrix, tRow, tCol, dRow, dCol, fromTop);
            fromTop = !fromTop;
            tRow = tCol == eCol ? tRow + 1 : tRow;
            tCol = tCol == eCol ? tCol : tCol + 1;
            dCol = dRow == eRow ? dCol + 1 : dCol;
            dRow = dRow == eRow ? dRow : dRow + 1;
        }
    }

    public static void printBias(int[][] matrix, int tRow, int tCol, int dRow, int dCol, boolean fromTop) {
        if (fromTop) {
            while (tRow <= dRow) {
                System.out.print(matrix[tRow++][tCol--]);
                System.out.print(" ");
            }
        } else {
            while (dRow >= tRow) {
                System.out.print(matrix[dRow--][dCol++]);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        zigZagPrintMatrix(matrix);
    }
}

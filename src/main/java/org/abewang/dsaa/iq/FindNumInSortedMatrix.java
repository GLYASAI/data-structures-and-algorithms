package org.abewang.dsaa.iq;

/**
 * 在行列都排好序的矩阵中找数
 *
 * @Author Abe
 * @Date 2018/5/5.
 */
public class FindNumInSortedMatrix {
    public static boolean findNumInSortedMatrix(int[][] matrix, int item) {
        int x = matrix.length - 1;
        int y = 0;
        while (x > 0 && y < matrix[0].length) {
            if (matrix[x][y] > item) {
                x--;
            } else if (matrix[x][y] < item) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8},
                {5, 7, 7, 9}};
        System.out.println(findNumInSortedMatrix(matrix, 7));
        System.out.println(findNumInSortedMatrix(matrix, 6));
    }
}

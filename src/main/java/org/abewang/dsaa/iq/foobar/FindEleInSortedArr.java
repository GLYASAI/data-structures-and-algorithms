package org.abewang.dsaa.iq.foobar;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @Author Abe
 * @Date 2018/9/6.
 */
public class FindEleInSortedArr {
    /* 思路:
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增.
     * 因此从左下角开始查找，当要查找数字比左下角数字大时, 右移
     * 要查找数字比左下角数字小时，上移
     */
    public static boolean find(int target, int [][] array) {
        int x = 0, y = array.length - 1;
        while (x < array[0].length && y >= 0) {
            int cur = array[x][y];
            if (target > cur) {
                x++;
            } else if (target < cur) {
                y--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int ele = 7;
        System.out.println(find(ele, arr));
    }
}

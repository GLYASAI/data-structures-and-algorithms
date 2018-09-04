package org.abewang.dsaa.iq.rdp;

/**
 * 题目
 * 求数组中两个元素差的最大值（后面的元素减去前面的元素）；对应实际生活中的股票买卖，找出可能的最大收益；
 *
 * @Author Abe
 * @Date 2018/9/4.
 */
public class MaxDifference {
    public static void main(String[] args) {
        int[] arr = new int[] {23, 3, 53, 34, 100, -40, 56};
        System.out.println(getMaxDiff(arr));;
    }

    public static int getMaxDiff(int[] arr) {
        int maxDiff = Integer.MIN_VALUE;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // 如果当前元素与最小值的差值(arr[i] - min), 则替换maxDiff.
            maxDiff = arr[i] - min > maxDiff ? arr[i] - min : maxDiff;

            // 更新最小值
            min = arr[i] < min ? arr[i] : min;
        }

        return maxDiff;
    }
}

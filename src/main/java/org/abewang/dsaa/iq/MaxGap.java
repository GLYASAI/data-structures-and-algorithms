package org.abewang.dsaa.iq;

import java.util.Arrays;

/**
 * 给定一个数组， 求如果排序之后， 相邻两数的最大差值， 要求时
 * 间复杂度O(N)， 且要求不能用非基于比较的排序。
 *
 * @Author Abe
 * @Date 2018/4/30.
 */
public class MaxGap {
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int len = arr.length;

        // 最小值, 最大值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max) {
            return 0;
        }

        // 初始化桶
        boolean[] hasNum = new boolean[len];  // 为什么是len + 1?
        int[] mins = new int[len];
        int[] maxs = new int[len];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], min, max, len - 1);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        // 依次找出每一个非空桶的最大值与下一个非空桶的最小值的差值，取其最大值
        int lastMax = maxs[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    /**
     * 求桶的位置
     */
    public static int bucket(int num, int min, int max, int len) {
        return (num - min) * len / (max - min);
    }

    /**
     * 绝对正确但是复杂度不好的方法b
     */
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        Arrays.sort(arr);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            res = Math.max(res, arr[i + 1] - arr[i]);
        }

        return res;
    }

    /**
     * 随机样本产生器
     *
     * @param maxSize 数组大小最大值
     * @param maxVal  数组元素最大值
     * @return 随机生成的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxVal) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxVal + 1) * Math.random() - maxVal * Math.random());
        }
        return arr;
    }

    /**
     * 复制数组
     *
     * @param arr 源数组
     * @return 复制的数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int testTimes = 5000000;
        int maxSize = 100;
        int maxVal = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxVal);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

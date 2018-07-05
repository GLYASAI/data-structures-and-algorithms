package org.abewang.dsaa.iq.sort;

/**
 * 随机快速排序
 *
 * @Author Abe
 * @Date 2018/4/25.
 */
public class RandomQuickSort {
    public static void randomQuickSort(int arr[], int left, int right) {
        if (left < right) {
            // 在left ~ right中随机抽取一个数和right交换
            swap(arr, right, left + (int)(Math.random() * (right - left + 1)));
            int[] p = partition(arr, left, right);
            randomQuickSort(arr, left, p[0]);
            randomQuickSort(arr, p[1], right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int lessIdx = left - 1;
        int greaterIdx = right;
        while (left < greaterIdx) {
            if (arr[left] < arr[right]) {
                swap(arr, ++lessIdx, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --greaterIdx, left);
            } else {
                left++;
            }
        }
        swap(arr, greaterIdx, right);

        return new int[] {lessIdx, ++greaterIdx};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void display(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            int ele = (int) (Math.random() * (100 + 1));
            arr[i] = ele;
        }

        display(arr);
        randomQuickSort(arr, 0, arr.length - 1);
        display(arr);
    }
}
package org.abewang.dsaa.simplesorting;

/**
 * 冒泡排序
 * @Author Abe
 * @Date 2018/3/9.
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end > 1; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 任何数与0异或后仍然为它本身，两个相同的数异或后为0
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void display(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            int ele = (int) (Math.random() * (100 + 1));
            arr[i] = ele;
        }

        display(arr);
        bubbleSort(arr);
        display(arr);
    }
}

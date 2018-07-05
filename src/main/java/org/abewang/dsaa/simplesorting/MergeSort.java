package org.abewang.dsaa.simplesorting;

import com.sun.istack.internal.NotNull;

/**
 * @Author Abe
 * @Date 2018/4/22.
 */
public class MergeSort {
    public static void mergeSort(int arr[]) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * <<: 左移运算符，num << 1,相当于num乘以2
     * >>: 右移运算符，num >> 1,相当于num除以2
     */
    public static void mergeSort(int arr[], int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];  // 辅助数组
        int helpIdx = 0;
        while (p1 <= mid && p2 <= right) {
            help[helpIdx++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[helpIdx++] = arr[p1++];
        }
        while (p2 <= right) {
            help[helpIdx++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
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
        mergeSort(arr);
        display(arr);
    }
}

package org.abewang.dsaa.iq.sort;

/**
 * 荷兰国旗
 *
 * @Author Abe
 * @Date 2018/4/24.
 */
public class DutchNationalFlagProblem {
    public static void dutch(int[] arr, int num, int left, int right) {
        int lessIdx = left - 1;
        int greaterIdx = right + 1;
        int current = left;
        while (current < greaterIdx) {
            if (arr[current] < num) {
                swap(arr, ++lessIdx, current++);
            } else if (arr[current] > num) {
                swap(arr, --greaterIdx, current);
            } else {
                current++;
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
        dutch(arr, 50, 0, arr.length - 1);
        display(arr);
    }
}

package org.abewang.dsaa.iq.sort;

/**
 * 堆排序(大根堆)
 *
 * @Author Abe
 * @Date 2018/4/26.
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        while (heapSize > 1) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * trickleDown
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int root = arr[index];
        int leftChild = 2 * index + 1;
        while (leftChild < heapSize) {  // 至少有一个左子节点
            int rightChild = leftChild + 1;
            int biggerChild = rightChild < heapSize && arr[rightChild] > arr[leftChild] ? rightChild : leftChild;

            if (root >= arr[biggerChild] ) {
                break;
            }

            arr[index] = arr[biggerChild];
            index = biggerChild;
            leftChild = 2 * index + 1;
        }

        arr[index] = root;
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
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            int ele = (int) (Math.random() * (100 + 1));
            arr[i] = ele;
        }

        display(arr);
        heapSort(arr);
        display(arr);
    }
}

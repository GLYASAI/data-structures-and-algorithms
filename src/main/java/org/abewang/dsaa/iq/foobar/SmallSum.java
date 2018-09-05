package org.abewang.dsaa.iq.foobar;

/**
 * 小和问题
 * 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数， 没有；
 * 3左边比3小的数， 1；
 * 4左边比4小的数， 1、 3；
 * 2左边比2小的数， 1；
 * 5左边比5小的数， 1、 3、 4、 2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 * @Author Abe
 * @Date 2018/9/5.
 */
public class SmallSum {

    public static int merge(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        int a = merge(arr, left, mid);
        int b = merge(arr, mid + 1, right);
        int sum = mergeSortSum(arr, left, right);

        return a + b + sum;
    }

    public static int mergeSortSum(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int p1 = left;
        int p2 = mid + 1;

        int idx = 0;
        int[] help = new int[right - left + 1];
        int sum = 0;
        while (p1 <= mid && p2 <= right) {
            sum += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[idx++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[idx++] = arr[p1++];
        }
        while (p2 <= right) {
            help[idx++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left++] = help[i];
        }

        return sum;
    }

    public static int comparator(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }

        return sum;
    }

    public static int[] generateArray(int len, int range) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (range + 1));
        }

        return arr;
    }

    public static int[] copyArray(int arr[]) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        int times = 100; // 循环次数
        int len = 500;  // 数组长度
        int range = 1000;  // 元素最大值

        boolean isCorrect = true;
        while (times-- > 0) {
            int[] arr = generateArray(len, range);
            int[] copy = copyArray(arr);
            if (merge(arr, 0, arr.length - 1) != comparator(copy)) {
                isCorrect = false;
                break;
            }
        }
        System.out.println(isCorrect ? "Good!" : "F*ck!");
    }
}

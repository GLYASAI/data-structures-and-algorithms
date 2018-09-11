package org.abewang.dsaa.iq.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find all pairs with given sum in it.
 *
 * @Author Abe
 * @Date 2018/9/11.
 */
public class FindPairs {
    public static void findPairs(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                System.out.println("Pair found at index " + map.get(sum - arr[i]) + " and " + i);
                isFound = true;
            }
            map.put(arr[i], i);
        }

        if (!isFound) {
            System.out.println("Pair not found");
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int sum = 100;
        findPairs(arr, sum);
    }
}

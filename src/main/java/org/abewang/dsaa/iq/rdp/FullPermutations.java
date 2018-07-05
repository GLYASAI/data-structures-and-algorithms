package org.abewang.dsaa.iq.rdp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Abe
 * @Date 2018/6/10.
 */
public class FullPermutations {

    public static void permutations(char[] charArr, int n) {
        if (n == charArr.length) {
            System.out.println(String.valueOf(charArr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = n; i < charArr.length; i++) {
            if (!set.contains(charArr[i])) {
                set.add(charArr[i]);
                swap(charArr, i, n);
                permutations(charArr, n + 1);
                swap(charArr, i, n);
            }
        }
    }

    public static void swap(char[] charArr, int i, int j) {
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }

    public static void permutations2(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        do {
            System.out.println(String.valueOf(charArr));
        } while (nextPerm(charArr) != null);
    }

    public static char[] nextPerm(char[] charArr) {
        int j = -1;
        int k = -1;
        for (int i = charArr.length - 1; i > 0; i--) {
            if (charArr[i] > charArr[i - 1]) {
                j = i - 1;
                break;
            }
        }
        if (j == -1) {
            return null;
        }
        for (int i = charArr.length - 1; i > j; i--) {
            if (charArr[i] > charArr[j]) {
                k = i;
                break;
            }
        }

        swap(charArr, j, k);
        // reverse
        reverse(charArr, j);
        return charArr;
    }

    public static void reverse(char[] charArr, int j) {
        int head = j + 1;
        int tail = charArr.length - 1;
        int length = (charArr.length - j) / 2;
        for (int i = j; i < length; i++) {
            swap(charArr, head, tail);
            head++;
            tail--;
        }
    }

    public static void main(String[] args) {
        String str = "cba";
        permutations(str.toCharArray(), 0);
        System.out.println();
        permutations2(str);
    }
}

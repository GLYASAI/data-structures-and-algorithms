package org.abewang.dsaa.iq.rdp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1、假设字符串为p1p2….pn,我们从后往前寻找第一个符合pj<pj+1条件的字符pj，也就是说，p1p2…pj-1pjpj+1…pn中pj<pj+1并且pj+1>pj+2>…pn。
 *
 * 2、再次从后往前寻找第一个大于pj的字符pk，也就是说，p1p2pj-1pjpj+1…pk-1pkpk+1…pn中从后往前pk>pj并且pk+1,…pn<pj，可以看出pk也是比pj大的数中最小的一个，因为最差情况下k=j+1。
 *
 * 3、交换pj和pk，这样在p1p2…pj前j个字符变大了，pj放到原来pk的位置上同样符合pj+1>…pk-1>pj>pk+1…>pn。
 *
 * 4、为了得到恰好大于该字符串的下一个排列，我们看到从j+1之后的字符串是降序排列的，我们将其翻转，就可以得到想要的结果了。
 *
 * 那么什么时候整个过程结束呢？当再也找不到符合条件的j时，说明当前的字符串已经是逆序的了，也就是字典序最大。
 *
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
        // 从数组后面开始, 找出比前一个字符小的字符的下标
        for (int i = charArr.length - 1; i > 0; i--) {
            if (charArr[i] > charArr[i - 1]) {
                j = i - 1;
                break;
            }
        }

        if (j == -1) {  // j等于-1, 说明charArr元素的大小是降序的, 全排列结束
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

package org.abewang.iq.rdp;

/**
 * 打印所有的子序列
 *
 * @Author Abe
 * @Date 2018/6/10.
 */
public class PrintSubSeq {
    public static void process(char[] charArr, int n) {
        if (n == charArr.length) {
            System.out.println(String.valueOf(charArr));
            return;
        }

        process(charArr, n + 1);
        char temp = charArr[n];
        charArr[n] = 0;
        process(charArr, n + 1);
        charArr[n] = temp;
    }

    public static void main(String[] args) {
        String test = "abc";
        process(test.toCharArray(), 0);
    }
}

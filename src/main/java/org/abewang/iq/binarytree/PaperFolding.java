package org.abewang.iq.binarytree;

/**
 * 折纸问题
 *
 * @Author Abe
 * @Date 2018/5/12.
 */
public class PaperFolding {
    /**
     * 递归打印折痕方向
     *
     * @param isDown 方向是否是down
     * @param N 对折数
     */
    public static void printKinkMark(boolean isDown, int N) {
        if (N == 0) {
            return;
        }
        N--;
        printKinkMark(true, N);
        System.out.println(isDown ? "down" : "up");
        printKinkMark(false, N);
    }

    public static void main(String[] args) {
        printKinkMark(true, 4);
    }
}

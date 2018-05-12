package org.abewang.iq.btree;

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
     * @param i 当前对折数
     * @param N 对折数
     */
    public static void printKinkMark(boolean isDown, int i, int N) {
        if (i++ > N) {
            return;
        }
        printKinkMark(true, i, N);
        System.out.println(isDown ? "down" : "up");
        printKinkMark(false, i, N);
    }

    public static void main(String[] args) {
        printKinkMark(true, 1, 4);
    }
}

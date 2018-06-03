package org.abewang.iq.rdp;

/**
 * 汉诺塔
 *
 * @Author Abe
 * @Date 2018/6/3.
 */
public class HanoiTower {
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
        } else {
            process(N - 1, from, help, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            process(N - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        int N = 3;
        process(N, "left", "right", "mid"); 
    }
}

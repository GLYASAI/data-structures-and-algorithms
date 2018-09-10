package org.abewang.dsaa.iq.rdp;

/**
 * @Author Abe
 * @Date 2018/9/10.
 */
public class BagProblem {
    public static int bagProblem(int[] w, int[] v, int weight, int idx, int bag) {
        if (weight > bag) {
            return Integer.MIN_VALUE;
        }
        if (idx == w.length) {
            return 0;
        }

        return Math.max(bagProblem(w, v, weight, idx + 1, bag),
                v[idx] + bagProblem(w, v, weight + w[idx], idx + 1, bag));
    }

    public static void main(String[] args) {
        int[] w = { 3, 2, 4, 7 };
        int[] v = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(bagProblem(w, v, 0, 0, bag));
    }
}

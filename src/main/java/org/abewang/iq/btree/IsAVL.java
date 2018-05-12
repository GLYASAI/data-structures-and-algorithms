package org.abewang.iq.btree;

/**
 * 判断一棵二叉树是否是平衡二叉树
 *
 * @Author Abe
 * @Date 2018/5/12.
 */
public class IsAVL {
    public static boolean isBalance(Node node) {
        boolean[] res = new boolean[]{true};
        getHeight(node, 0, res);
        return res[0];
    }

    public static int getHeight(Node node, int height, boolean[] res) {
        if (node == null) {
            return height;
        }

        int leftHeight = getHeight(node.left, height + 1, res);
        if (!res[0]) {
            return height;
        }

        int rightHeight = getHeight(node.right, height + 1, res);
        if (!res[0]) {
            return height;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            res[0] = false;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}

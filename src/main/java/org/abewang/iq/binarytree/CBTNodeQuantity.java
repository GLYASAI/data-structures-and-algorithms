package org.abewang.iq.binarytree;

/**
 * 完全二叉树的节点数
 *
 * @Author Abe
 * @Date 2018/5/13.
 */
public class CBTNodeQuantity {
    public static Integer countCBTNode(Node node, int level, int height) {
        if (level == height) {
            return 1;
        }

        if (getMostLeftLevel(node.right, level + 1) == height) {
            return (1 << (height - level)) + countCBTNode(node.right, level + 1, height);
        } else {
            return (1 << (height - level - 1))+ countCBTNode(node.left, level + 1, height);
        }
    }

    public static Integer getMostLeftLevel(Node node, int level) {
        while (node != null && node.left != null) {
            level++;
            node = node.left;
        }

        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(getMostLeftLevel(head, 1));
//        head.right.right = new Node(7);
        System.out.println(countCBTNode(head, 1, getMostLeftLevel(head, 1)));
    }
}

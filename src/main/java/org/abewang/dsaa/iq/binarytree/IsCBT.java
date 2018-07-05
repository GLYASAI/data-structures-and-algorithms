package org.abewang.dsaa.iq.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Abe
 * @Date 2018/5/13.
 */
public class IsCBT {
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        boolean end = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            Node left = head.left;
            Node right = head.right;
            if ((end && (left != null || right != null))
                    || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                end = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
//        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        System.out.println(isCBT(head));
    }
}

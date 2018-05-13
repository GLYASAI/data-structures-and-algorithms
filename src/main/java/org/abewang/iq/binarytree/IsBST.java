package org.abewang.iq.binarytree;

import java.util.Stack;

/**
 * 判断是否是二叉搜索树(Binary Search Tree)
 *
 * @Author Abe
 * @Date 2018/5/12.
 */
public class IsBST {
    public static boolean isBST(Node node) {
        Stack<Node> stack = new Stack<>();
        Node pre = new Node(Integer.MIN_VALUE);
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.value < pre.value) {
                    return false;
                } else {
                    pre = node;
                }
                node = node.right;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        System.out.println(isBST(head));
    }
}

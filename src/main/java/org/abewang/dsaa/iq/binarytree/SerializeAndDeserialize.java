package org.abewang.dsaa.iq.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化与反序列化
 *
 * @Author Abe
 * @Date 2018/5/10.
 */
public class SerializeAndDeserialize {
    public static class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * 按层遍历序列化二叉树
     *
     * @param head 根节点
     * @return 序列化后的字符串
     */
    public static String serializeByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        String result = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                result += node.left.value + "!";
            } else {
                result += "#!";
            }
            if (node.right != null) {
                queue.offer(node.right);
                result += node.right.value + "!";
            } else {
                result += "#!";
            }
        }

        return result;
    }

    /**
     * 反序列化按层遍历序列化后的字符串
     *
     * @param serializeStr 按层遍历序列化后的字符串
     * @return 反序列化后的BTree的根节点
     */
    public static Node deserializeByLevel(String serializeStr) {
        String[] eleArr = serializeStr.split("!");
        int index = 0;
        Node head = getNodeByString(eleArr[index++]);
        if (head == null) {
            return head;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.left = getNodeByString(eleArr[index++]);
            cur.right = getNodeByString(eleArr[index++]);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return head;
    }

    public static Node getNodeByString(String val) {
        if ("#".equals(val)) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        String serializeStr = serializeByLevel(head);
        Node head2 = deserializeByLevel(serializeByLevel(head));
        String serializeStr2 = serializeByLevel(head2);
        System.out.println(serializeStr.equals(serializeStr2));
    }
}

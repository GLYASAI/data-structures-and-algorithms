package org.abewang.dsaa.iq;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 *
 * @Author Abe
 * @Date 2018/5/6.
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRandom(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            nodeMap.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            nodeMap.get(cur).rand = nodeMap.get(cur.rand);
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            cur = cur.next;
        }
        return nodeMap.get(head);
    }

    public static Node advancedCopyListWithRandom(Node head) {
        // 将当前节点的副本插入到与当前节点与下一个节点之间
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        // 连接rand节点
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.rand = cur.rand == null ? null : new Node(cur.rand.value);
            cur = next;
        }

        // split
        cur = head;
        Node res = cur.next;
        while (cur != null) {
            next = cur.next.next;
            Node copy = cur.next;
            copy.next = next == null ? null : next.next;
            cur.next = next;
            cur = next;
        }

        return res;
    }

    public static void printList(Node head) {
        System.out.print("list: ");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();

        System.out.print("rand: ");
        cur = head;
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next;
        head.next.rand = head.next.next;
        head.next.next.rand = head;
        head.next.next.next.rand = head.next.next;
        head.next.next.next.next.rand = head.next.next.next.next.next;
        head.next.next.next.next.next.rand = null;
        printList(head);
        printList(copyListWithRandom(head));
        System.out.println("=================");

        printList(advancedCopyListWithRandom(head));
    }
}

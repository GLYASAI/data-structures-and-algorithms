package org.abewang.dsaa.iq;

/**
 * 翻转单向、双向链表
 *
 * @Author Abe
 * @Date 2018/5/5.
 */
public class ReverseList {
    // region 单向链表
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }
    // endregion

    // region 双向链表
    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void printList(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }
    // endregion

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printList(head);
        head = reverseList(head);
        printList(head);

        System.out.println("=======");

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.next = new DoubleNode(3);
        head2.next.pre = head2;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.pre = head2.next.next;
        printList(head2);
        printList(reverseList(head2));
    }
}

package org.abewang.dsaa.iq;

/**
 * 将单向链表按某值划分成左边小、 中间相等、 右边大的形式
 *
 * @Author Abe
 * @Date 2018/5/6.
 */
public class PartitionLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node partition(Node head, int pivot) {
        if (head == null) {
            return null;
        }

        Node lessHead = null;
        Node lessTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node moreHead = null;
        Node moreTail = null;


        // partition
        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else if (head.value == pivot) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }
            head = next;
        }

        // reconnect
        if (lessTail != null) {
            lessTail.next = equalHead;
            equalTail = equalTail == null ? lessTail : equalTail;
        }
        if (equalTail != null) {
            equalTail.next = moreHead;
        }

        return lessHead != null ? lessHead : equalHead != null ? equalHead : moreHead;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(0);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        printLinkedList(partition(head, 4));
    }
}

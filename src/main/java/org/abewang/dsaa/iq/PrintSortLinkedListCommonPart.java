package org.abewang.dsaa.iq;

import static sun.misc.Version.print;

/**
 * 打印两个有序链表的公共部分
 *
 * @Author Abe
 * @Date 2018/5/5.
 */
public class PrintSortLinkedListCommonPart {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printCommon(Node head, Node head2) {
        System.out.print("Common Part: ");
        while (head != null && head2 != null) {
            if (head.value < head2.value) {
                head = head.next;
            } else if (head.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head.value);
                System.out.print(" ");
                head = head.next;
                head2 = head2.next;
            }
        }
        System.out.println();
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
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        printLinkedList(head);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);
        head2.next.next.next = new Node(5);
        head2.next.next.next.next = new Node(7);
        printLinkedList(head2);

        printCommon(head, head2);
    }
}

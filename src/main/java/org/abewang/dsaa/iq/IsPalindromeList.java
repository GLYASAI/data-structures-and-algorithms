package org.abewang.dsaa.iq;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 *
 * @Author Abe
 * @Date 2018/5/5.
 */
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindromeList(Node head) {
        Node slowPointer = head;
        Node fastPointer = head.next;
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (fastPointer == null) {
                while (head != slowPointer) {
                    stack.push(head);
                    head = head.next;
                }
                break;
            } else if (fastPointer.next == null) {
                while (head != slowPointer.next) {
                    stack.push(head);
                    head = head.next;
                }
                break;
            } else {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        }
        while (!stack.isEmpty()) {
            if ((stack.pop().value) != (slowPointer.next.value)) {
                return false;
            }
            slowPointer = slowPointer.next;
        }
        return true;
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
        {
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(2);
            head.next.next.next = new Node(1);
            printLinkedList(head);
            System.out.println(isPalindromeList(head));
        }

        {
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(2);
            head.next.next.next.next = new Node(1);
            printLinkedList(head);
            System.out.println(isPalindromeList(head));
        }
    }
}

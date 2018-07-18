package org.abewang.dsaa.iq;

/**
 * 两个单链表相交的一系列问题
 *
 * @Author Abe
 * @Date 2018/5/6.
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node findFirstIntersectNode(Node head1, Node head2) {
        Node n1 = getLoopNode(head1);
        Node n2 = getLoopNode(head2);
        if (n1 == null && n2 == null) {  // 两个无环链表
            return noLoop(head1, head2);
        } else if (n1 != null && n2 != null) {  // 两个有环链表
            return bothLoop(n1, n2);
        }

        return null;
    }

    public static Node noLoop(Node head1, Node head2) {
        int gap = 0;
        Node cur = head1;
        while (cur != null) {
            gap++;
            cur = cur.next;
        }
        cur = head2;
        while (cur != null) {
            gap--;
            cur = cur.next;
        }
        if (gap > 0) {
            for (int i = 0; i < gap; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < -gap; i++) {
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            head1 = head1.next;
            head2 = head2.next;
            if (head1 == head2) {
                return head1;
            }
        }

        return null;
    }

    public static Node bothLoop(Node n1, Node n2) {
        if (n1 == n2) {
            return n1;
        }
        Node cur = n1.next;
        while (cur != n1) {
            if (cur == n2) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slowNode = head.next;
        Node fastNode = head.next.next;
        while (slowNode != fastNode) {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        fastNode = head;
        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }

    public static void main(String[] args) {
        {
            Node head1 = new Node(1);
            head1.next = new Node(2);
            head1.next.next = new Node(3);
            head1.next.next.next = new Node(4);
            head1.next.next.next.next = new Node(5);
            head1.next.next.next.next.next = new Node(6);
            head1.next.next.next.next.next = head1.next.next;
            Node head2 = new Node(11);
            head2.next = new Node(22);
            head2.next.next = new Node(33);
            head2.next.next.next = head1.next.next;
            Node res = findFirstIntersectNode(head1, head2);
            System.out.println(res == null ? null : res.value);
        }

        {
            Node head1 = new Node(1);
            head1.next = new Node(2);
            head1.next.next = new Node(3);
            head1.next.next.next = new Node(4);
            head1.next.next.next.next = new Node(5);
            Node head2 = new Node(6);
            head2.next = new Node(7);
            head2.next.next = new Node(7);
            head2.next.next.next = new Node(8);
            head2.next.next.next.next = head1.next.next;
            Node res = findFirstIntersectNode(head1, head2);
            System.out.println(res == null ? null : res.value);
        }
    }
}

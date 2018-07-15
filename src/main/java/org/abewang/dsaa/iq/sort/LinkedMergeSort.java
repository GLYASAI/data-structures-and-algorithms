package org.abewang.dsaa.iq.sort;

/**
 * 链表的归并排序
 *
 * @Author Abe
 * @Date 2018/7/15.
 */
public class LinkedMergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        return mergeSort(sortList(head), sortList(midNext));
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        ListNode first = new ListNode(0);
        ListNode cur = first;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = left == null ? right : left;

        return first.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        LinkedMergeSort sort = new LinkedMergeSort();
        ListNode head = sort.sortList(node);
        System.out.println(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

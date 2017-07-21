package week2.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example :
 *
 * Input : 1 -> 5 -> 4 -> 3
 *
 * Returned list : 1 -> 3 -> 4 -> 5
 *
 * https://www.interviewbit.com/problems/sort-list/
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class MergeSortList {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        Deque<ListNode> queue = new ArrayDeque();
        ListNode cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            queue.addLast(cur);
            cur = next;
        }

        head = queue.pollFirst();

        while (!queue.isEmpty()) {
            queue.addLast(head);
            head = merge(queue.pollFirst(), queue.pollFirst());
        }

        return head;
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                cur = a;
                a = a.next;
            } else {
                cur.next = b;
                cur = b;
                b = b.next;
            }
        }
        cur.next = a == null ? b : a;
        return head.next;
    }
}

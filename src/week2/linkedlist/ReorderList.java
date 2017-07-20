package week2.linkedlist;

/**
 * Given a singly linked list
 *
 * L: L0 → L1 → … → Ln-1 → Ln,
 * reorder it to:
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * You must do this in-place without altering the nodes’ values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class ReorderList {

    public ListNode reorderList(ListNode head) {
        if (head == null) return head;

        ListNode mid = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

       //list2 - the head of the second part of the list
        ListNode list2 = mid.next;
        //form the first half of the list
        mid.next = null;

        // reverse the second part of the list
        ListNode next = null, prev = null;
        while (list2 != null) {
            next = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = next;
        }
        // pointed to the head of reversed list, i.e. L[n],L[n-1], etc.
        list2 = prev;

        ListNode next1, next2, list1 = head;
        while (list1 != null && list2 != null) {
            next1 = list1.next;
            next2 = list2.next;

            list1.next = list2;
            list2.next = next1;

            list1 = next1;
            list2 = next2;
        }
        return head;
    }
}

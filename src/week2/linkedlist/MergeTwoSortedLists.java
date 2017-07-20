package week2.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
 *
 * For example, given following linked lists :
 *
 * 5 -> 8 -> 20
 * 4 -> 11 -> 15
 * The merged list should be :
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode cur = null;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (cur != null) cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                if (cur != null) cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
            if (head == null) head = cur;
        }

        cur.next = l1 == null ? l2 : l1;
        return head;
    }
}
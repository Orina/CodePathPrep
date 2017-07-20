package week2.linkedlist;

/**
 * iven a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode cur = a;

        while (cur.next != null) {
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return a;
    }
}

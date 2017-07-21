package week2.linkedlist;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * remove all duplicates for a node and leave it alone with a boolean flag = to show if there were duplicates
     * /* if current node and next node is different, we need to check a boolean flag
     * /* if hasDuplicates flag set tto true => this means that current node need to be deleted, set prev pointer  to null
     * /* otherwise - current node does not have duplicates, set prev pointer  to current node
     */
    public ListNode deleteDuplicates(ListNode a) {
        if (a == null || a.next == null) return a;

        ListNode cur = a;
        ListNode head = new ListNode(0);
        ListNode prev = head;

        boolean hasDuplicates = false;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                hasDuplicates = true;
            } else {
                if (hasDuplicates) {
                    hasDuplicates = false;
                    prev.next = null;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
                cur = cur.next;
            }
        }
        //if the last element contains duplicates, set prev's next pointer  to null
        if (hasDuplicates) prev.next = null;
        return head.next;
    }
}

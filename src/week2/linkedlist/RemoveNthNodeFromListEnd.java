package week2.linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * If n is greater than the size of the list, remove the first node of the list.
 * Try doing it using constant additional space.
 *
 * https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class RemoveNthNodeFromListEnd {

    /**
     * We use two iterators to traverse the initial list:
     * 1) the first iterator is advanced by n steps
     * 2) the second iterator points to the beginning  of the list
     * 3) two iterators advance in tandem till the fast iterator next pointer is not null. In this case the slow (second) iterator point to the node (n+1)-th from the end
     * 4) remove the n-th node by modifying the second iterator: slow.next = slow.next.next;
     */
    public ListNode removeNthFromEnd(ListNode a, int n) {
        if (a == null || n == 0) return a;

        ListNode fast = a;

        ListNode head = new ListNode(0);
        head.next = fast;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        // this means that n is bigger than the size of original list, just remove the first element from the list
        if (fast == null) return a.next;

        ListNode slow = a;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head.next;
    }
}

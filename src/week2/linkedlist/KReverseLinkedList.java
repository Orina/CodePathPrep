package week2.linkedlist;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 *
 * list K at a time and returns modified linked list.
 *
 * NOTE : The length of the list is divisible by K
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 *
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 *
 * Try to solve the problem using constant extra space.
 *
 * Created by Elmira Andreeva on 7/26/17.
 */
public class KReverseLinkedList {

    public ListNode reverseList(ListNode A, int k) {
        if (A == null || A.next == null || k < 2) return A;

        ListNode newHead = new ListNode(0);
        ListNode cur = A, newTail = newHead;

        while (cur != null) {

            int i = 0;
            ListNode head2 = null, next = null, prev = null;

            while (i < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                if (head2 == null) head2 = cur;
                cur = next;
                i++;
            }
            newTail.next = prev;
            newTail = head2;
        }

        return newHead.next;
    }
}

package week2.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class ReverseLinkListII {

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if (a == null) return a;
        if (m >= n) return a;

        int i = 1;
        ListNode cur = a, head1 = a;
        ListNode prev = null, next = null;

        while (i < m) {
            prev = cur;
            cur = cur.next;
            i++;
        }

        //prev - points to the (m-1)th element in the original list
        ListNode tail1 = prev;
        //cur - points to the m-th element in the original list
        ListNode head2 = cur;

        // reverse list from m-th to n-th nodes
        prev = null;
        while (i <= n) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        // prev - points to the n-th element in the original list
        // if the first part is empty, new head has be equal to n-th node of the original list
        if (m == 1) {
            head1 = prev;
        }
        if (tail1 != null) {
            tail1.next = prev;
        }
        // next - points to the (n+1)th element in the original list
        if (head2 != null) {
            head2.next = next;
        }

        return head1;
    }
}

package week2.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class SwapListNodesInPairs {

    /**
     *  Maintain 2 pointers - one for odd nodes, second - for even nodes
     *  traverse through the initial list:
     *   odd pointer - will traverse only through odd nodes
     *   even pointer - will traverse only though even nodes
     *
     *   Maintain a lastTail pointer - the tail node of already reversed list
     *
     *   consider 2 cases - when even not null, and when even (the last node) is null
     *
     *   reverse 2 pointers odd and even. Make the lastTail point to correct end of reversed nodes
     */

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) return a;

        ListNode odd = a, even = a.next;

        ListNode newHead = new ListNode(0);
        ListNode lastTail = newHead;

        while (odd != null) {
            ListNode oddNext = null;

            if (even != null) {
                oddNext = even.next;
                even.next = odd;
                lastTail.next = even;
                odd.next = null;
                lastTail = odd;
            } else {
                lastTail.next = odd;
                odd.next = null;
                lastTail = odd;
            }

            odd = oddNext;
            even = oddNext == null ? null : oddNext.next;
        }

        return newHead.next;
    }
}

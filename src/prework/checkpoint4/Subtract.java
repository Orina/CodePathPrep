package prework.checkpoint4;

/**
 * Given a singly linked list, modify the value of first half nodes such that :
 *
 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 * and so on …
 *
 * NOTE :
 * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
 * Example :
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 * You should return 4 -> 2 -> 3 -> 4 -> 5
 *
 * SOLUTION:
 * 1. find the middle element (use slow and fast pointers)
 * 2. separate the first half of the list from the second part
 * 3. reverse the second part of the list
 * 4. iterate in tandem the first and reversed second parts, update the values in the first part of the list
 * 5. reverse again the second part back to it's initial state
 * 6. concat the first and second parts of the list.
 *
 * time: O(n), n - number of nodes in the list
 * space: O(1)
 *
 * Created by Elmira Andreeva on 6/28/2017.
 */
public class Subtract {
    public ListNode subtract(ListNode a) {
        if (a == null || a.next == null) return a;

        //find the mid element
        ListNode mid = a, fast = a, prev = null;
        while (fast != null && fast.next != null) {
            prev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }

        //separate the first half from the second half of the list
        if (prev != null) prev.next = null;

        //reverse the second part of the list
        ListNode listR = reverse(mid);
        ListNode cur = a, listRCopy = listR;

        //go in tandem for first half of the list with reversed second half of the list
        prev = null;
        while (cur != null) {
            cur.val = listR.val - cur.val;
            prev = cur;
            cur = cur.next;
            listR = listR.next;
        }

        //reverse back the second part of the list to it's initial state
        if (prev != null) prev.next = reverse(listRCopy);
        return a;
    }

    ListNode reverse(ListNode node) {
        ListNode cur = node, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

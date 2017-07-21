package week2.linkedlist;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 * - Expected solution is linear in time and constant in space.
 *
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 *
 * https://www.interviewbit.com/problems/palindrome-list/
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class PalindromeList {

    /**
     * To check palindrome, we just have to reverse the second half of linked list
     * and then we can in (n/2) steps total can compare if all elements are same or not.
     *
     * For finding mid point, first we can in O(N) traverse whole list using 2 pointers: slow and fast.
     * Reversing is again O(N).
     */
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;

        ListNode slow = A, fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHalf = reverse(slow.next);
        slow.next = null;

        ListNode firstHalf = A;
        while (firstHalf != null && revHalf != null) {

            if (firstHalf.val != revHalf.val) return 0;
            firstHalf = firstHalf.next;
            revHalf = revHalf.next;
        }
        return 1;
    }

    ListNode reverse(ListNode a) {
        if (a == null) return a;

        ListNode cur = a, next = null, prev = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 6, 4, 1};
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i = 1; i < a.length; i++) {
            ListNode newNode = new ListNode(a[i]);
            cur.next = newNode;
            cur = newNode;
        }

        new PalindromeList().lPalin(head);
    }
}

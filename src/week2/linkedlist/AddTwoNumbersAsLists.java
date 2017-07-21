package week2.linkedlist;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * 342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class AddTwoNumbersAsLists {

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        int carry = 0;
        while (a != null || b != null) {
            int value = carry;
            if (a != null) {
                value += a.val;
                a = a.next;
            }
            if (b != null) {
                value += b.val;
                b = b.next;
            }
            ListNode newNode = new ListNode(value % 10);
            carry = value / 10;
            cur.next = newNode;
            cur = newNode;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            cur.next = newNode;
        }
        return head.next;
    }
}

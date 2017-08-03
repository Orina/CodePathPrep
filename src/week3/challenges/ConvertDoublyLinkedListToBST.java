package week3.challenges;

import week2.linkedlist.DoublyListNode;
import week2.linkedlist.ListNode;
import week3.trees.TreeNode;

/**
 * Created by Elmira Andreeva on 7/26/17.
 */
public class ConvertDoublyLinkedListToBST {

    DoublyListNode head = null;

    public DoublyListNode sortedListToBST(DoublyListNode a) {
        if (a == null) return null;
        head = a;
        int n = size(a);
        return construct(n);
    }

    private DoublyListNode construct(int n) {
        if (n <= 0) return null;

        DoublyListNode left = construct(n / 2);

        DoublyListNode root = head;

        DoublyListNode next = head.next;

        root.prev = left;
        head = next;

        root.next = construct(n - n / 2 - 1);
        return root;
    }

    private int size(DoublyListNode a) {
        int size = 0;
        while (a != null) {
            size++;
            a = a.next;
        }
        return size;
    }
}

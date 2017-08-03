package week3.challenges;

import week2.linkedlist.ListNode;
import week3.trees.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example :
 *
 *
 * Given A : 1 -> 2 -> 3
 * A height balanced BST  :
 *
 * 2
 * /   \
 * 1     3
 *
 * https://www.interviewbit.com/courses/1/topics/16/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Created by Elmira Andreeva on 7/26/17.
 */
public class ConvertSinglyLinkedListToBST {


    public TreeNode sortedListToBST(ListNode list) {
        if (list == null) return null;

        int N = size(list);
        return convert(list, 1, N);
    }

    private TreeNode convert(ListNode node, int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + (hi - lo) / 2;
        ListNode cur = node;
        int i = lo;

        while (cur != null && i < mid) {
            cur = cur.next;
            i++;
        }

        TreeNode treeNode = new TreeNode(cur.val);
        treeNode.left = convert(node, lo, mid - 1);
        treeNode.right = convert(cur.next, mid + 1, hi);

        return treeNode;
    }



    private int size(ListNode a) {
        int size = 0;
        while (a != null) {
            size++;
            a = a.next;
        }
        return size;
    }
}

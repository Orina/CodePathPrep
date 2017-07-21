package week2.linkedlist;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->3->4->5.
 *
 * https://www.interviewbit.com/problems/partition-list/
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class PartitionList {

    /**
     * create 2 dummy heads - loHead -one point to a nodes with value < B,
     * - hiHead- the second will points to nodes with value >= B.
     *
     * create 2 current pointers to lower and higher lists: lo, hi
     *
     * traverse though every node of initial list and decide which pointer to update:
     * 1. if current node value < B - update lo's next pointer and lo pointer
     * 2. otherwise - update hi's next pointer and hi pointer
     *
     * Nullify next pointers of both lo and hi lists!!
     * lo.next=null and hi.next =null
     *
     * check if no element in loHead - > no element less than B - return the second list
     * check if no elements in hiHead - no elements greater or equals to B - return the first list
     * otherwise - merge the last element of first list with first element of second list
     * return the head of first list
     */

    public ListNode partition(ListNode a, int b) {
        if (a == null || a.next == null) return a;

        ListNode loHead = new ListNode(0);
        ListNode hiHead = new ListNode(0);

        ListNode lo = loHead, hi = hiHead;
        ListNode cur = a;

        while (cur != null) {
            if (cur.val < b) {
                lo.next = cur;
                lo = cur;
            } else {
                hi.next = cur;
                hi = cur;
            }
            cur = cur.next;
        }

        lo.next = null;
        hi.next = null;

        if (loHead.next == null) return hiHead.next;
        if (hiHead.next == null) return loHead.next;

        lo.next = hiHead.next;
        return loHead.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 4, 3};
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i = 1; i < a.length; i++) {
            ListNode newNode = new ListNode(a[i]);
            cur.next = newNode;
            cur = newNode;
        }

        int b = 3;
        ListNode l = new PartitionList().partition(head, b);
        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }
    }
}

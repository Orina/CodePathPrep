package week2.linkedlist;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * https://www.interviewbit.com/problems/rotate-list/
 *
 *
 * Created by Elmira Andreeva on 7/20/17.
 */
public class RotateList {

    /**
     *  1. compute the length of the list by traversing thought the list
     *  2. update k = k % N, in case if k > N
     *  3. if k == 0 -> no need to rotate, return a current head
     *  3. make a cycle by connecting the tail of the list to it's oldest head: cur.next = a
     *  (we calculate a length of the list in a manner that we know the tail pointer)
     *  4. count the number of steps we need to advance for a new list head: stepsToNewHead = N - k
     *  5. advance since the old head to stepsToNewHead
     *  6. make a newHead pointer, and prev node's next pointer set to null (i.e. make the correct tail pointer)
     *
     */
    public ListNode rotateRight(ListNode a, int k) {
        if (a == null || a.next == null || k <= 0) return a;

        int N = 1;
        ListNode cur = a;

        while (cur.next != null) {
            N++;
            cur = cur.next;
        }

        k = k % N;
        if (k == 0) return a;

        //make  a cycle by connecting the tail to a head of he list
        cur.next = a;

        int stepsToNewHead = N - k;
        cur = a;
        while (stepsToNewHead > 1) {
            cur = cur.next;
            stepsToNewHead--;
        }

        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}

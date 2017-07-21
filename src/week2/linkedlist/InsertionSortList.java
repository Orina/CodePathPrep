package week2.linkedlist;

/**
 * Sort a linked list using insertion sort.
 *
 * We have explained Insertion Sort at Slide 7 of Arrays
 *
 * Insertion Sort Wiki has some details on Insertion Sort as well.
 *
 * Example :
 *
 * Input : 1 -> 3 -> 2
 *
 * Return 1 -> 2 -> 3
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class InsertionSortList {

    /**
     *  Keep a separate reference to the head of sorted linked list: newHead
     *
     *  Traverse through the initial array and for every new node:
     *  set a reference "sorted" to the head of already sorted linked list
     *  traverse through the sorted linked list to find the appropriate place to insert current node:
     *
     *   1. put the already traversed sorted list's next pointer to current node
     *   2. put the next pointer of current node point to remaining sorted part
     *
     */
    public ListNode insertionSortList(ListNode a) {
        if(a==null || a.next==null) return a;

        ListNode cur = a.next, sorted = a;
        sorted.next = null;
        ListNode newHead = sorted;

        while(cur!=null){
            ListNode next = cur.next;
            ListNode prev = null;

            sorted = newHead;
            while(sorted!=null && sorted.val <= cur.val){
                prev = sorted;
                sorted = sorted.next;
            }
            if(prev != null) prev.next = cur;
            else newHead = cur;

            cur.next = sorted;
            cur = next;
        }

        return newHead;
    }
}
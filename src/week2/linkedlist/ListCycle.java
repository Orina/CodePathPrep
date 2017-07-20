package week2.linkedlist;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Try solving it using constant additional space.
 *
 * Example :
 * Input :
 *
 *           ______
 *          |     |
 *          \/    |
 * 1 -> 2 -> 3 -> 4
 *
 * Return the node corresponding to node 3.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class ListCycle {

    public ListNode detectCycle(ListNode a) {
        if (a == null) return null;

        ListNode speed = a, slow = a;

        while (slow != null && speed != null && speed.next != null) {
            slow = slow.next;
            speed = speed.next.next;
            if (slow == speed) break;
        }

        //no cycle detected
        if (speed == null || speed.next == null) return null;

        //set the second pointer to the head of the list
        speed = a;

        //traverse both pointers till they don't meet
        while (speed != slow) {
            speed = speed.next;
            slow = slow.next;
        }

        return slow;
    }
}
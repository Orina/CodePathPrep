package week3.heaps;

import week2.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example :
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class MergeKSortedLists {

    /**
     * Create a priority queue (min-heap) and insert all head's nodes of lists
     * do in a cycle while queue is not empty
     * 1) remove the node with min value from min-heap
     * 2) if node's next pointer is not null, add the next pointer to the min-heap
     * 3) add the removed node to the tail of newly formed linked list
     */
    public ListNode mergeKLists(ArrayList<ListNode> list) {
        if (list == null || list.size() == 0) return null;
        int N = list.size();

        ListNode head = new ListNode(0);
        ListNode cur = head;

        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode other) {
                if (o1 == other) return 0;
                if (o1.val < other.val) return -1;
                else if (o1.val > other.val) return 1;
                else return 0;
            }
        });

        for (ListNode node : list) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
            }

            cur.next = node;
            cur = node;
        }
        return head.next;
    }
}

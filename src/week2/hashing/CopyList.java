package week2.hashing;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
 *
 * Return a deep copy of the list.
 *
 * Example
 *
 * Given list
 *
 * 1 -> 2 -> 3
 * with random pointers going from
 *
 * 1 -> 3
 * 2 -> 1
 * 3 -> 1
 * You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            newNode.next = next;
            cur.next = newNode;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode newHead = cur.next;
        RandomListNode newCur = newHead;

        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (newCur.next != null) {
                newCur.next = newCur.next.next;
                newCur = newCur.next;
            }
        }

        return newHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}

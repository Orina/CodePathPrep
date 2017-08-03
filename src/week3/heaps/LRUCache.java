package week3.heaps;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
 *
 * NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * Example :
 *
 * Input :
 * capacity = 2
 * set(1, 10)
 * set(5, 12)
 * get(5)        returns 12
 * get(1)        returns 10
 * get(10)       returns -1
 * set(6, 14)    this pushes out key = 5 as LRU is full.
 * get(5)        returns -1
 *
 * https://www.interviewbit.com/problems/lru-cache/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class LRUCache {

    int N = 0;
    int capacity;
    HashMap<Integer, DoublyListNode> hashMap;

    DoublyListNode head, tail;

    public LRUCache(int capacity) {
        this.N = 0;
        this.capacity = capacity;
        hashMap = new HashMap();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;
        DoublyListNode node = hashMap.get(key);
        moveToFront(node);
        return node.value;
    }

    public void set(int key, int value) {
        if (hashMap.containsKey(key)) {
            DoublyListNode node = hashMap.get(key);
            moveToFront(node);
            node.value = value;
            hashMap.put(key, node);
        } else {
            if (N == capacity) {
                DoublyListNode last = removeLast();
                hashMap.remove(last.key);
            }

            DoublyListNode newNode = new DoublyListNode(key, value);
            addToFront(newNode);
            hashMap.put(key, newNode);
        }
    }

    private void addToFront(DoublyListNode node) {
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;

        N++;
    }

    private DoublyListNode removeLast() {
        if (tail == null) return null;

        DoublyListNode node = tail;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        if (tail == null) head = null;

        N--;
        return node;
    }

    private void moveToFront(DoublyListNode node) {
        //already in the front of the queue
        if (head == node) return;

        //remove from current place
        if (node.next != null) node.next.prev = node.prev;
        if (node.prev != null) node.prev.next = node.next;
        if (tail == node) tail = node.prev;

        // add to head
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;
    }

    static class DoublyListNode {
        int value;
        int key;
        DoublyListNode next = null;
        DoublyListNode prev = null;

        public DoublyListNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}

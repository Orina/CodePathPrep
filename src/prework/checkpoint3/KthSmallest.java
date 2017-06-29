package prework.checkpoint3;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find the kth smallest element in an unsorted array of non-negative integers.
 *
 * Definition of kth smallest element
 *
 * kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
 * In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
 * NOTE
 * You are not allowed to modify the array ( The array is read only ).
 * Try to do it using constant extra space.
 *
 * Example:
 * A : [2 1 4 3 2]
 * k : 3
 * answer : 2
 *
 * Solution:
 * Idea: As we can't modify the array, we can't do any sorting with it
 * Therefore we will use an additional space - heap of size k
 *
 * 1. Create an empty heap and add first k-elements to it.
 * 2. Traverse through the array from a[k]...a[n-1]
 * 3. each a[i] element compare with top heap element (max element in the heap),
 * if the top heap is greater than current element:
 * 3.1. remove the heap top
 * 3.2. add current element to the heap
 * 4. return the top heap element - it will be the k-th smallest element in the initial array
 *
 * time: O(n), n - number of elements in the array
 * space: O(k), k - given number
 *
 * Created by Elmira on 6/27/2017.
 */
public class KthSmallest {

    public int kthsmallest(final List<Integer> a, int k) {
        int N = a.size();

        // create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return -i1.compareTo(i2);
            }
        });

        for (int i = 0; i < k; i++) maxHeap.add(a.get(i));

        for (int i = k; i < N; i++) {
            if (maxHeap.peek() > a.get(i)) {
                maxHeap.poll();
                maxHeap.add(a.get(i));
            }
        }
        return maxHeap.poll();
    }
}

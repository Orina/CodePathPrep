package week1.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Examples:
 *
 * 1,2,3 → 1,3,2
 *
 * 3,2,1 → 1,2,3
 *
 * 1,1,5 → 1,5,1
 *
 * 20, 50, 113 → 20, 113, 50
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class NextPermutation {

    public void nextPermutation(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return;

        int N = a.size();
        if (N == 1) return;

        //start scanning from the end of array and find out the index where first a[j] < a[j+1]
        int j = N - 2;
        while (j >= 0) {
            if (j == 0 || a.get(j) < a.get(j + 1)) break;
            j--;
        }
        //if j==0 means that array is in descending order, reverse it and return
        if (j == 0) {
            Collections.reverse(a);
            return;
        }
        //start scanning from the end of array and find out the first index where a[i] > a[j], then swap i and j indexes
        for (int i = N - 1; i > j; i--) {
            if (a.get(i) > a.get(j)) {
                Collections.swap(a, i, j);
                break;
            }
        }

        //reverse the tail of the list starting from index a[j+1]...a[N-1]
        //so the tail will be in increasing order
        int lo = j + 1, hi = N - 1;
        while (lo < hi) {
            Collections.swap(a, lo, hi);
            lo++;
            hi--;
        }
    }
}

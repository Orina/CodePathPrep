package week1.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class FirstMissingInteger {

    /**
     * Main idea: re-arrange the elements in such way: a[i]==i+1, if possible
     * Than scan through the array and return first index where this condition a[i]==i+1 is violated
     */
    public int firstMissingPositive(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return 1;
        int N = a.size();

        int i = 0;
        while (i < N) {
            if (a.get(i) <= 0 || a.get(i) > N || a.get(i) == i + 1 || a.get(a.get(i) - 1).equals(a.get(i))) {
                i++;
            } else {
                Collections.swap(a, i, a.get(i) - 1);
            }
        }
        for (i = 0; i < N; i++) {
            if (a.get(i) != i + 1) return i + 1;
        }
        return N + 1;
    }
}

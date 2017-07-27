package week3.binary_search;

import java.util.ArrayList;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 *
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class SortedInsertPosition {

    /**
     * Do a binary search
     * 1) if we find the target, return the middle index
     * 2) otherwise return the value of left pointer after we return from the while cycle.
     */
    public int searchInsert(ArrayList<Integer> a, int b) {
        if (a == null || a.size() == 0) return 0;
        int N = a.size();
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) == b) return mid;
            else if (a.get(mid) < b) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

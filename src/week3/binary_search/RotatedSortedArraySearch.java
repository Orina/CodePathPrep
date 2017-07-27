package week3.binary_search;

import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value to search. If found in the array, return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 *
 * NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class RotatedSortedArraySearch {

    /**
     * Do a modified binary search
     * 1) find the middle element
     * 2) check it a[mid]==target?
     * 3) if not equals, one part a[lo..mid] or a[mid..hi] will be sorted!
     * 4) find the sorted part
     * 5) check if the target is between the sorted part -> then investigate a[lo.. mid-1]
     * 6) otherwise check in a[mid+1...hi]
     */
    public int search(final List<Integer> a, int target) {
        if (a == null || a.size() == 0) return -1;

        int N = a.size();
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) == target) return mid;

            //sorted first part a[lo] < a[mid]
            if (a.get(lo) < a.get(mid)) {
                if (a.get(lo) <= target && a.get(mid) > target) hi = mid - 1;
                else lo = mid + 1;
            }
            //sorted second part a[mid] < a[hi]
            else {
                if (a.get(mid) < target && a.get(hi) >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return a.get(lo) == target ? lo : -1;
    }
}
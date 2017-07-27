package week3.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example:
 *
 * Given [5, 7, 7, 8, 8, 10]
 *
 * and target value 8,
 *
 * return [3, 4].
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class SearchForARange {

    /**
     * Use 2 modified binary searches to find the left and right bounds:
     *
     * 1) to find the lowest bound
     * In this case we find the middle element closed to the left pointer: mid = lo + (hi - lo) / 2;
     * if the middle element is smaller than target, then we change the left pointer to mid+1, otherwise we change the right pointer to middle(!!!), as middle is also a candidate
     *
     * 2) to find the right most bound of the range.
     * In this case we find the middle element closed to the right pointer: mid = lo + (hi - lo + 1) / 2;
     * if the middle element is greater than target, then we change the right pointer to mid-1, otherwise we change the left pointer to middle(!!!), as middle is also a candidate
     */
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        if (a == null || a.size() == 0) return null;
        int start = -1, end = -1;

        int N = a.size();
        int lo = 0, hi = N - 1;

        //find the leftmost range: lo
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (a.get(mid) < b) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        //if the range doe not exist in the array
        if (a.get(lo) != b) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(-1);
            res.add(-1);
            return res;

        }
        //find the rightmost bound of the range
        start = lo;
        hi = N - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (a.get(mid) > b) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(hi);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        int target = 10;

        new SearchForARange().searchRange(list, target);
    }
}

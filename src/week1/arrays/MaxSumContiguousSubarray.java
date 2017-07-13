package week1.arrays;

import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example:
 *
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 *
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * For this problem, return the maximum sum.
 *
 * Created by Elmira Andreeva on 7/11/17.
 */
public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> a) {

        if (a == null || a.size() == 0) return 0;

        int N = a.size();

        int maxSum = a.get(0);
        int maxSumEndingHere = a.get(0);

        for (int i = 1; i < N; i++) {
            maxSumEndingHere = Math.max(a.get(i), a.get(i) + maxSumEndingHere);
            maxSum = Math.max(maxSum, maxSumEndingHere);
        }

        return maxSum;
    }
}

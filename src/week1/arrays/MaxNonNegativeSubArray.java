package week1.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 *
 * Example:
 *
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 *
 * Created by Elmira Andreeva on 7/17/17.
 */
public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return a;

        int N = a.size();

        long maxSum = Integer.MIN_VALUE;
        long curMaxSum = 0;

        int startIndex = -1, endIndex = -1;

        for (int i = 0, j = -1; i < N; i++) {
            if (a.get(i) >= 0) {
                //update the start sequence index
                if (j == -1) j = i;
                //nullify the curMaxSum if it was previously set to -1
                if (curMaxSum == -1) curMaxSum = 0;
                //increment the current max sum
                curMaxSum += a.get(i);
            } else {
                //make curMaxSum as negative
                curMaxSum = -1;
                //nullify start sequence index
                j = -1;
            }
            //if the curSum is greater than global max sum or if it's the same continues sum, update the start and end indices of the continues sequence
            if (curMaxSum >= 0 && curMaxSum > maxSum || (curMaxSum == maxSum && endIndex == i - 1)) {
                maxSum = curMaxSum;
                startIndex = j;
                endIndex = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (startIndex == -1 || endIndex == -1) return res;

        while (startIndex <= endIndex) {
            res.add(a.get(startIndex++));
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{0, 0, -1, 0};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(ar));

        ArrayList<Integer> maxSet = new MaxNonNegativeSubArray().maxset(list);
        if (maxSet == null || maxSet.size() == 0) System.out.print("Max set is empty");
        else {
            for (int i : maxSet) System.out.print(i + ", ");
        }
    }
}

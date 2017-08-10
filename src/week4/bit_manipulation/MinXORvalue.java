package week4.bit_manipulation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 *
 * Examples :
 * Input
 * 0 2 5 7
 * Output
 * 2 (0 XOR 2)
 * Input
 * 0 4 7 9
 * Output
 * 3 (4 XOR 7)
 *
 * Constraints:
 * 2 <= N <= 100 000
 * 0 <= A[i] <= 1 000 000 000
 *
 * https://www.interviewbit.com/problems/min-xor-value/
 *
 * Created by Elmira Andreeva on 8/9/17.
 */
public class MinXORvalue {

    /**
     * 1)Sort the given array
     * 2)Traverse and check XOR for every consecutive pair
     **/
    public int findMinXor(ArrayList<Integer> nums) {
        Collections.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            int value = nums.get(i) ^ nums.get(i - 1);
            min = Math.min(min, value);
        }
        return min;
    }
}

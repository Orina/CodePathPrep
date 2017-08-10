package week4.bit_manipulation;

import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1 2 2 3 1]
 * Output : 3
 *
 * https://www.interviewbit.com/problems/single-number/
 *
 * Created by Elmira Andreeva on 8/9/17.
 */
public class SingleNumber {
    public int singleNumber(final List<Integer> a) {
        int missing = 0;
        for (int v : a) {
            missing ^= v;
        }
        return missing;
    }
}

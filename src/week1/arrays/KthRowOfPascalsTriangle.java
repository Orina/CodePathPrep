package week1.arrays;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Input : k = 3
 *
 * Return : [1,3,3,1]
 * NOTE : k is 0 based. k = 0, corresponds to the row [1].
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class KthRowOfPascalsTriangle {

    public ArrayList<Integer> getRow(int k) {
        ArrayList<Integer> res = new ArrayList();

        //store the calculation of last row only
        int[] pascal = new int[k + 1];
        int prev;
        pascal[0] = 1;

        for (int i = 1; i <= k; i++) {
            prev = pascal[0];
            for (int j = 1; j <= i; j++) {
                int tmp = pascal[j];
                pascal[j] = prev + pascal[j];
                prev = tmp;
            }
        }
        for (int val : pascal) res.add(val);
        return res;
    }
}

package prework.checkpoint3;

import java.util.ArrayList;

/**
 * Given an array of non negative integers A, and a range (B, C),
 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
 *
 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 * where 0 <= i <= j < size(A)
 *
 * Example :
 *
 * A : [10, 5, 1, 0, 2]
 * (B, C) : (6, 8)
 * ans = 3
 * as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
 *
 * Solution: brute-force with 2 loops
 * Has to be a better solution, but don't know how to do.
 *
 * Time: O(N^2)
 * Space: O(1)
 *
 * Created by Elmira Andreeva on 6/27/2017.
 */
public class NumRange {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[]{80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90};
        for (int i = 0; i < arr.length; i++) list.add(arr[i]);

        int b = 99, c = 269;
        int count = new NumRange().numRange(list, b, c);
        println(count);
    }

    static void println(Object o) {
        System.out.println(o);
    }

    public int numRange(ArrayList<Integer> a, int min, int max) {
        if (a == null || a.size() == 0) return 0;

        int N = a.size();
        int count = 0;

        int curSum = 0;
        for (int i = 0; i < N; i++) {
            curSum = 0;
            for (int j = i; j < N; j++) {
                curSum += a.get(j);
                if (curSum > max) break;
                else if (curSum < min) continue;
                else count++;
            }
        }
        return count;
    }

}

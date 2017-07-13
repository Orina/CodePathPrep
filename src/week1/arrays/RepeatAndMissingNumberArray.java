package week1.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a read only array of n integers from 1 to n.
 *
 * Each integer appears exactly once except A which appears twice and B which is missing.
 *
 * Return A and B.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Note that in your output A should precede B.
 *
 * Example:
 *
 * Input:[3 1 2 5 3]
 * Output:[3, 4]
 * A = 3, B = 4
 *
 * Created by Elmira Andreeva on 7/11/17.
 */
public class RepeatAndMissingNumberArray {

    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        if (a == null || a.size() == 0) return new ArrayList<Integer>();

        // A - repeating, B - missing,
        // (1+ 2+ ..+ A + B) + A - B = sum
        // (1^2 + 2^2 +...+ A^2 + B^2) + A^2 - B^2 = sum2
        //  S1 = 1 + 2 + 3 + .. + N = N*(N+1)/2;
        //  S2 = 1^2 + 2^2 + ... + N^2 = (N*(N+1)*(2*N +1))/6;
        // =>
        // A-B = sum - S1
        // A^2-B^2 = sum2 - S2
        // as
        // A^2 - B^2 = (A-B)*(A+B)
        //=>
        // A+B = (sum2 - S2)/(sum-S1)
        // A-B = sum - S1
        // =>
        // A = ((sum2 - S2)/(sum-S1) + (sum - S1))/2
        // B = ((sum2 - S2)/(sum-S1) - (sum - S1))/2

        long sum = 0, sum2 = 0;
        long N = a.size();

        for (int i = 0; i < N; i++) {
            long c = (long) a.get(i);
            sum += c;
            sum2 += c * c;
        }

        long S1 = N * (N + 1) / 2l;
        long S2 = (N * (N + 1) * (2l * N + 1)) / 6l;

        long tmpS1 = (sum2 - S2) / (sum - S1);
        long tmpS2 = sum - S1;

        long A = (tmpS1 + tmpS2) >> 1;
        long B = (tmpS1 - tmpS2) >> 1;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add((int) A);
        list.add((int) B);
        return list;
    }
}
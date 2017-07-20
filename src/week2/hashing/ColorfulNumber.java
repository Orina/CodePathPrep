package week2.hashing;

import java.util.*;

/**
 * For Given Number N find if its COLORFUL number or not
 *
 * Return 0/1
 *
 * COLORFUL number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 * Example:
 *
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of every digit of a sub-sequence are different.
 *
 * Output : 1
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class ColorfulNumber {

    public int colorful(int a) {
        if (a < 0) return 0;
        else if (a == 0) return 1;

        Set<Long> set = new HashSet<Long>();
        List<Integer> digits = new ArrayList<Integer>();
        while (a > 0) {
            digits.add(a % 10);
            a = a / 10;
        }
        Collections.reverse(digits);

        int N = digits.size();

        for (int size = 1; size <= N; size++) {
            for (int i = 0; i <= N - size; i++) {
                long prod = digits.get(i);
                int curSize = 1;
                int j = i + 1;
                while (curSize < size && j < N) {
                    prod *= digits.get(j);
                    j++;
                    curSize++;
                }
                if (set.contains(prod)) return 0;
                set.add(prod);
            }
        }
        return 1;
    }
}
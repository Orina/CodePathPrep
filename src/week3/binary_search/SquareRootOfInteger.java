package week3.binary_search;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * If x is not a perfect square, return floor(sqrt(x))
 *
 * Example :
 *
 * Input : 11
 * Output : 3
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class SquareRootOfInteger {

    public int sqrt(int a) {
        if (a <= 1) return a;

        long lo = 0, hi = a;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long midSq = mid * mid;

            if (midSq == a) return (int) mid;
            else if (midSq < a) {
                lo = mid + 1;
            } else if (midSq > a) {
                hi = mid - 1;
            }
        }
        return (int) lo - 1;
    }
}

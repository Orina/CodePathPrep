package week3.binary_search;

/**
 * Implement pow(x, n) % d.
 *
 * In other words, given x, n and d,
 *
 * find (xn % d)
 *
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 *
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 *
 * 2^3 % 3 = 8 % 3 = 2.
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class ImplementPowerFunction {

    public int pow(int a, int n, int d) {
        if (a == 0) return 0;
        if (a == 1) return 1;

        if (n < 0) {
            a = 1 / a;
            n = -n;
        }
        if (n == 0) return 1;
        if (n == 1) return a >= 0 ? a % d : (a + d) % d;

        long y = 1;
        long x = a;

        while (n > 1) {
            if (n % 2 == 0) {
                x = (x * x) % d;
                n = n / 2;
            } else {
                y = (y * x) % d;
                x = (x * x) % d;
                n = (n - 1) / 2;
            }
        }
        long res = y * x;
        return res >= 0 ? (int) (res % d) : (int) (d - (-res) % d);
    }
}

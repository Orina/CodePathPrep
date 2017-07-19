package week1.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a number N, find all prime numbers upto N ( N included ).
 *
 * Example:
 *
 * if N = 7,
 *
 * all primes till 7 = {2, 3, 5, 7}
 *
 * Make sure the returned array is sorted.
 *
 * Created by Elmira Andreeva on 7/13/17.
 */
public class EnumerateAllPrimes {

    public ArrayList<Integer> sieve(int n) {
        if (n <= 1) return new ArrayList<Integer>();

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) continue;
            int j = i + i;
            while (j <= n) {
                primes[j] = false;
                j += i;
            }
        }
        ArrayList<Integer> result = new ArrayList();
        for (int i = 2; i <= n; i++) {
            if (primes[i]) result.add(i);
        }
        return result;
    }
}
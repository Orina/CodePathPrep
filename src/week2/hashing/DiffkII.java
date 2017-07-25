package week2.hashing;

import java.util.HashMap;
import java.util.List;

/**
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * Example :
 *
 * Input :
 *
 * A : [1 5 3]
 * k : 2
 * Output :
 *
 * 1
 * as 3 - 1 = 2
 *
 * Return 0 / 1 for this problem.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class DiffkII {

    public int diffPossible(final List<Integer> a, int k) {
        if (a == null || a.size() < 2) return 0;

        int N = a.size();
        HashMap<Integer, Integer> hash = new HashMap();

        hash.put(a.get(0), 0);
        for (int i = 1; i < N; i++) {
            int x = k + a.get(i);
            int y = a.get(i) - k;
            if (hash.containsKey(x)) return 1;
            if (hash.containsKey(y)) return 1;
            hash.put(a.get(i), i);
        }
        return 0;
    }
}
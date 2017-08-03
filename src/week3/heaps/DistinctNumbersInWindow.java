package week3.heaps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 * - If K > N, return empty array.
 *
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 *
 * Created by Elmira Andreeva on 7/27/17.
 */
public class DistinctNumbersInWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int k) {
        ArrayList<Integer> result = new ArrayList();
        if (A == null) return result;

        int N = A.size();
        if (k > N || N == 0) return result;

        HashMap<Integer, Integer> hash = new HashMap();
        for (int i = 0; i < k; i++) {
            if (!hash.containsKey(A.get(i))) hash.put(A.get(i), 1);
            else hash.put(A.get(i), hash.get(A.get(i)) + 1);
        }
        result.add(hash.size());

        for (int i = k; i < N; i++) {
            //remove the last element in the window
            int count = hash.get(A.get(i - k));
            count--;
            if (count > 0) hash.put(A.get(i - k), count);
            else hash.remove(A.get(i - k));

            //add new element to the window
            if (!hash.containsKey(A.get(i))) hash.put(A.get(i), 1);
            else hash.put(A.get(i), hash.get(A.get(i)) + 1);

            //update the result
            result.add(hash.size());
        }
        return result;
    }
}
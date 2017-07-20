package week2.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
 *
 * Note:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 * A[A1] + A[B1] = A[C1] + A[D1]
 * A1 < B1, C1 < D1
 * A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 * then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 iff
 * A1 < A2 OR
 * A1 = A2 AND B1 < B2 OR
 * A1 = A2 AND B1 = B2 AND C1 < C2 OR
 * A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 * Example:
 *
 * Input: [3, 4, 7, 1, 2, 9, 8]
 * Output: [0, 2, 3, 5] (O index)
 * If no solution is possible, return an empty list.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class Equal {

    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return new ArrayList();
        int N = a.size();

        HashMap<Integer, Indices> hash = new HashMap();
        ArrayList candidate = null;

        for (int i = 0; i < N; i++) {
            int s = a.get(i);
            for (int j = i + 1; j < N; j++) {
                int sum = s + a.get(j);
                if (!hash.containsKey(sum)) {
                    hash.put(sum, new Indices(i, j));
                } else {
                    Indices indices = hash.get(sum);
                    if (indices.i >= i || indices.j == i || indices.j == j) continue;
                    ArrayList<Integer> list = new ArrayList();
                    list.add(indices.i);
                    list.add(indices.j);
                    list.add(i);
                    list.add(j);
                    candidate = getLexicographicalSmallest(list, candidate);
                }
            }
        }
        return candidate;
    }

    private ArrayList<Integer> getLexicographicalSmallest(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null) return b;
        if (b == null) return a;

        for (int i = 0; i < 4; i++) {
            if (a.get(i) < b.get(i)) return a;
            else if (a.get(i) > b.get(i)) return b;
        }

        return a;
    }

    class Indices {
        int i, j;

        public Indices(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

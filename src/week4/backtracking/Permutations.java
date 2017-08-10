package week4.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * Example:
 *
 * [1,2,3] will have the following permutations:
 *
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 * NOTE
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 * https://www.interviewbit.com/problems/permutations/
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class Permutations {

    /**
     * At each step you want to reduce the problem to a smaller set.
     * Lets say we carry a set of remaining integers with us.
     * At any position, we try to put every integer from the set of remaining integer onto the current position,
     * remove that integer from the set of integers, and call the function for next position.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        permute(0, a.size(), a, res);
        return res;
    }

    private void permute(int offset, int n, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (offset == n) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = offset; i < n; i++) {
            Collections.swap(list, offset, i);
            permute(offset + 1, n, list, res);
            Collections.swap(list, offset, i);
        }
    }
}

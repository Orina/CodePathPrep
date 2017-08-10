package week4.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Example :
 *
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * https://www.interviewbit.com/problems/combination-sum-ii/
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class CombinationSumII {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        combination(0, 0, b, new ArrayList(), a, result);
        return result;
    }

    private void combination(int offset, int curSum, int target, ArrayList<Integer> curList,
                             ArrayList<Integer> src, ArrayList<ArrayList<Integer>> result) {
        if (curSum > target) return;
        if (curSum == target) {
            result.add(new ArrayList(curList));
            return;
        }
        for (int i = offset; i < src.size(); i++) {
            //skip duplicates
            if (i > offset && src.get(i - 1) == src.get(i)) continue;
            curList.add(src.get(i));
            //  offset = i + 1  - because we can not reuse same elements
            combination(i + 1, curSum + src.get(i), target, curList, src, result);
            curList.remove(curList.size() - 1);
        }
    }
}

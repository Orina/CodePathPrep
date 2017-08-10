package week4.backtracking;

import common.Base;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example,
 * Given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 *
 * [2, 2, 3]
 * [7]
 *
 * https://www.interviewbit.com/problems/combination-sum/
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class CombinationSum extends Base {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int target) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        combination(0, new ArrayList(), 0, target, a, result);
        return result;
    }

    private void combination(int offset, ArrayList<Integer> curList, int curSum, int target, ArrayList<Integer> src,
                             ArrayList<ArrayList<Integer>> result) {
        if (curSum > target) return;
        if (curSum == target) {
            result.add(new ArrayList(curList));
            return;
        }
        for (int i = offset; i < src.size(); i++) {
            if (i > 0 && src.get(i - 1) == src.get(i)) continue;
            curList.add(src.get(i));
            // offset = i, not i + 1 because we can reuse the same elements
            combination(i, curList, curSum + src.get(i), target, src, result);
            curList.remove(curList.size() - 1);
        }
    }
}

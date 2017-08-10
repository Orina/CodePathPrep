package week4.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 * [],
 * [1],
 * [1, 2],
 * [1, 2, 3],
 * [1, 3],
 * [2],
 * [2, 3],
 * [3],
 * ]
 *
 * https://www.interviewbit.com/problems/subset/
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        Set<ArrayList<Integer>> result = new LinkedHashSet();
        generate(0, a.size(), new ArrayList(), a, result);
        return new ArrayList(result);
    }

    private void generate(int offset, int n, ArrayList<Integer> curList, ArrayList<Integer> src,
                          Set<ArrayList<Integer>> result) {

        ArrayList<Integer> list = new ArrayList(curList);
        if (!result.contains(list)) result.add(list);

        if (offset == n) {
            return;
        }

        //generate all subsets that contain src[offset]
        curList.add(src.get(offset));
        generate(offset + 1, n, curList, src, result);

        //generate all subsets that do not contain src[offset]
        curList.remove(curList.size() - 1);
        generate(offset + 1, n, curList, src, result);
    }
}

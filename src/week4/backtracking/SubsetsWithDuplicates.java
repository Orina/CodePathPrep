package week4.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 * Example :
 * If S = [1,2,2], the solution is:
 *
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,2],
 * [2],
 * [2, 2]
 * ]
 *
 * https://www.interviewbit.com/problems/subsets-ii/
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class SubsetsWithDuplicates {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        generate(0, new ArrayList(), a, result);
        return result;
    }

    private void generate(int offset, ArrayList<Integer> curList, ArrayList<Integer> src,
                          ArrayList<ArrayList<Integer>> result) {

        result.add(new ArrayList(curList));

        for (int i = offset; i < src.size(); i++) {
            if (i > offset && src.get(i - 1) == src.get(i)) continue;
            curList.add(src.get(i));
            generate(i + 1, curList, src, result);
            curList.remove(curList.size() - 1);
        }
    }
}

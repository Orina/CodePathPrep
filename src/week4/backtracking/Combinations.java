package week4.backtracking;

import common.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 * 1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * 2. Entries should be sorted within themselves.
 *
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 * [1,2],
 * [1,3],
 * [1,4],
 * [2,3],
 * [2,4],
 * [3,4],
 * ]
 *
 * Created by Elmira Andreeva on 8/8/17.
 *
 * https://www.interviewbit.com/problems/combinations/
 */
public class Combinations extends Base {

    public static List<List> combine(int n, int k) {
        ArrayList<List> result = new ArrayList();
        generate(1, n, k, new ArrayList(), result);
        return result;
    }

    private static void generate(int offset, int n, int k, ArrayList<Integer> curList,
                                 ArrayList<List> result) {
        if (curList.size() == k) {
            result.add(new ArrayList(curList));
            return;
        }
        println("offset: " + offset);
        for (int i = offset; i <= n; i++) {
            curList.add(i);
            generate(i + 1, n, k, curList, result);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 1;
        println("n: " + n);
        println("k: " + k);

        printListList(combine(n, k));
    }
}

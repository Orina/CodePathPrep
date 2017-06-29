package prework.checkpoint5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example : [1,1,2] have the following unique permutations:
 *
 * [1,1,2]
 * [1,2,1]
 * [2,1,1]
 * NOTE : No 2 entries in the permutation sequence should be the same.
 *
 * Solution:
 * Idea: 1. use recursion
 * 2. use hash map with key = distinct value
 * value = count of frequences of that value in the array
 *
 * time: O(n!)
 * space: O(n)
 *
 * Created by Elmira Andreeva on 6/28/2017.
 */
public class AllUniquePermutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (a == null || a.size() == 0) return result;

        HashMap<Integer, Integer> countHash = countFrequences(a);
        permute(a.size(), new ArrayList<Integer>(), result, countHash);
        return result;
    }

    private void permute(int remaining, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> result,
                         HashMap<Integer, Integer> countHash) {
        if (remaining == 0) {
            result.add(new ArrayList(curList));
            return;
        }
        for (int key : countHash.keySet()) {
            int count = countHash.get(key);
            if (count > 0) {
                curList.add(key);
                countHash.put(key, count - 1);
                permute(remaining - 1, curList, result, countHash);
                countHash.put(key, count);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private HashMap<Integer, Integer> countFrequences(ArrayList<Integer> a) {
        HashMap<Integer, Integer> hash = new HashMap();
        for (int i = 0; i < a.size(); i++) {
            if (hash.containsKey(a.get(i))) hash.put(a.get(i), hash.get(a.get(i)) + 1);
            else hash.put(a.get(i), 1);
        }
        return hash;
    }
}

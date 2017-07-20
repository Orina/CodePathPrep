package week2.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
 *
 * Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 * Note: All inputs will be in lower-case.
 * Example :
 *
 * Input : cat dog god tca
 * Output : [[1, 4], [2, 3]]
 * cat and tca are anagrams which correspond to index 1 and 4.
 * dog and god are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 *
 * Ordering of the result : You should not change the relative ordering of the words / phrases w
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        if (a == null || a.size() == 0) return new ArrayList();

        LinkedHashMap<String, ArrayList<Integer>> hash = new LinkedHashMap<String, ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        int N = a.size();
        for (int i = 0; i < N; i++) {
            char[] chars = a.get(i).toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            ArrayList list = null;
            if (hash.containsKey(sorted)) {
                list = hash.get(sorted);
            } else {
                list = new ArrayList();
            }
            list.add(i + 1);
            hash.put(sorted, list);
        }
        for (ArrayList<Integer> list : hash.values()) {
            result.add(list);
        }
        return result;
    }
}

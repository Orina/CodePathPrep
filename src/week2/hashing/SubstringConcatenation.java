package week2.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 *
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 * Example :
 *
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * https://www.interviewbit.com/problems/substring-concatenation/
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstringBruteForce(String s, final List<String> words) {
        ArrayList<Integer> result = new ArrayList<>();
        int unitSize = words.get(0).length();
        int concatLength = words.size() * unitSize;

        Map<String, Integer> dictionary = new HashMap<>();
        for (String word : words) addToDictionary(word, dictionary);

        for (int i = 0; i + concatLength <= s.length(); i++) {
            if (matchAllWordsInDictionary(s, dictionary, i, words.size(), unitSize)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean matchAllWordsInDictionary(String s, Map<String, Integer> dictionary, int start, int numWords, int unitSize) {
        Map<String, Integer> currDictionary = new HashMap<>();
        for (int i = 0; i < numWords; i++) {
            String curWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            if (!dictionary.containsKey(curWord)) return false;
            addToDictionary(curWord, currDictionary);
            if (currDictionary.get(curWord) > dictionary.get(curWord)) return false;
        }
        return true;
    }

    private void addToDictionary(String word, Map<String, Integer> dictionary) {
        if (dictionary.containsKey(word)) {
            dictionary.put(word, dictionary.get(word) + 1);
        } else dictionary.put(word, 1);
    }
}
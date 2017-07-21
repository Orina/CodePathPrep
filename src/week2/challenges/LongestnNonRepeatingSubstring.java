package week2.challenges;

import java.util.HashMap;

/**
 * Write a program which takes as its input a String and returns the length of the longest substring that does not contain any repeated characters.
 *
 * Example: Given the string "abcabcbb", the longest substring with no repeated characters is "abc", so the program would return a value of 3.
 *
 * Given the string "aaaaaaaa", the longest non-repeating substring is "a" and thus the output would be 1.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class LongestnNonRepeatingSubstring {

    public int lengthOfLongestSubstring(String a) {
        if (a == null || a.length() == 0) return 0;
        int curLength = 0, maxLength = 0;
        int N = a.length();
        char[] chars = a.toCharArray();

        HashMap<Character, Integer> hash = new HashMap();
        for (int i = 0; i < N; i++) {
            //if current character does not exist in hash table OR it places BEFORE the length of current substring
            // i - curLength - the start index of the current substring
            if (!hash.containsKey(chars[i]) || (i - curLength) > hash.get(chars[i])) {
                curLength++;
                hash.put(chars[i], i);
            } else {
                maxLength = Math.max(curLength, maxLength);
                //start the new candidate substring from the next character after repeating
                curLength = i - hash.get(chars[i]);
                hash.put(chars[i], i);
            }
        }
        maxLength = Math.max(curLength, maxLength);
        return maxLength;
    }
}

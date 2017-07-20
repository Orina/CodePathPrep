package week2.hashing;

import java.util.HashMap;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class LongestSubstringWithoutRepeat {

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
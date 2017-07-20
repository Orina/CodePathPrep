package week2.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
 * Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
 *
 * Example :
 *
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class WindowString {

    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int left = 0, right = 0, start = -1, end = -1;
        Map<Character, Integer> keys = new HashMap();
        for (char tChar : tChars) {
            keys.put(tChar, (keys.containsKey(tChar) ? keys.get(tChar) + 1 : 1));
        }

        Map<Character, Integer> curKeys = new HashMap<Character, Integer>();
        int counter = 0;

        while (right < sChars.length) {
            // do in a cycle till we find the first full coverage starting from the "left" index in initial s string
            while (right < sChars.length && counter < tChars.length) {
                if (keys.containsKey(sChars[right])) {
                    if (curKeys.containsKey(sChars[right])) {
                        if (curKeys.get(sChars[right]) < keys.get(sChars[right])) {
                            counter++;
                        }
                        curKeys.put(sChars[right], curKeys.get(sChars[right]) + 1);
                    } else {
                        curKeys.put(sChars[right], 1);
                        counter++;
                    }
                }
                right++;
            }
            // check if we cover all characters in T and (this is our first coverage or this coverage is minimal)
            if (counter == tChars.length && ((start == -1 && end == -1) || (right - left - 1 < end - start))) {
                start = left;
                end = right - 1;
            }
            // do in a cycle till we find the first character which breaks the current coverage of all characters in t:
            // from [left] to [right] indexes in initial s string, this coverage is a candidate for minimum
            while (left < right && counter == tChars.length) {
                if (keys.containsKey(sChars[left])) {
                    curKeys.put(sChars[left], curKeys.get(sChars[left]) - 1);
                    if (curKeys.get(sChars[left]) < keys.get(sChars[left])) {
                        counter--;
                        if ((start == -1 && end == -1) || (right - left - 1 < end - start)) {
                            start = left;
                            end = right - 1;
                        }
                    }
                }
                left++;
            }
        }
        return (start == -1 || end == -1) ? "" : s.substring(start, end + 1);
    }
}
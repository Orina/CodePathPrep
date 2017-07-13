package week1.strings;

import java.util.ArrayList;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 *
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 *
 * Example:
 *
 * Given the array as:
 *
 * ["abcdefgh",
 *
 * "aefghijk",
 *
 * "abcefgh"]
 *
 * The answer would be “a”.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> a) {
        if (a == null || a.size() == 0) return "";
        int N = a.size();

        // find the min - minimum length among all strings
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) min = Math.min(min, a.get(i).length());

        //iterate though 0 to min - minimum length of all strings
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            //take the character at position i at first string
            char ch = a.get(0).charAt(i);
            for (int j = 1; j < N; j++) {
                //make sure that all other strings have the same character at position i, otherwise return string builder
                if (a.get(j).charAt(i) != ch) return sb.toString();
            }
            // add common character to string builder
            sb.append(ch);
        }
        return sb.toString();
    }
}
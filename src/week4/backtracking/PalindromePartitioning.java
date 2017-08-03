package week4.backtracking;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 * [
 * ["a","a","b"]
 * ["aa","b"],
 * ]
 * Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 * In the given example,
 * ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 *
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList();
        partition(s, 0, s.length(), new ArrayList<String>(), result);
        return result;
    }

    public void partition(String str, int start, int end, ArrayList<String> curList, ArrayList<ArrayList<String>> result) {
        if (start == end) {
            result.add(new ArrayList(curList));
            return;
        }
        for (int i = start; i < end; i++) {
            if (isPalindrome(str, start, i)) {
                curList.add(str.substring(start, i + 1));
                partition(str, i + 1, end, curList, result);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        if (end < start) return false;
        if (end == start) return true;
        int i = start, j = end;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
package week1.strings;

/**
 * Given a string S, find the longest palindromic substring in S.
 *
 * Substring of string S:
 *
 * S[i...j] where 0 <= i <= j < len(S)
 *
 * Palindrome string:
 *
 * A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 *
 * Incase of conflict, return the substring which occurs first ( with the least starting index ).
 *
 * Example :
 *
 * Input : "aaaabaaa"
 * Output : "aaabaaa"
 *
 * Created by Elmira Andreeva on 7/13/17.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String str) {
        if (str == null) return null;

        int N = str.length();
        if (N < 2) return str;

        boolean[][] palindrome = new boolean[N][N];

        //all substrings of length=1 is palindrome
        for (int i = 0; i < N; i++) {
            palindrome[i][i] = true;
        }

        int maxLength = 1;
        int startIndex = 0;

        //check the length greater than 1, i -starting index, j - ending index
        for (int len = 2; len <= N; len++) {

            //fix the starting index - i
            for (int i = 0; i < N - len + 1; i++) {
                //j - ending index of substring
                int j = i + len - 1;

                if (len == 2) {
                    if (str.charAt(i) == str.charAt(j)) {
                        palindrome[i][j] = true;
                        maxLength = 2;
                        startIndex = i;
                    }
                }
                // when length of substring is greater than 2, we need the previously result of palindromic substring of smaller length
                else {
                    if (str.charAt(i) == str.charAt(j) && palindrome[i + 1][j - 1]) {
                        palindrome[i][j] = true;
                        if (len > maxLength) {
                            maxLength = len;
                            startIndex = i;
                        }
                    }
                }
            }
        }
        return str.substring(startIndex, startIndex + maxLength);
    }
}
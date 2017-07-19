package week1.strings;

/**
 * You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string
 *
 * Example:
 * Input: ABC
 * Output: 2
 * Input: AACECAAAA
 * Output: 2
 *
 * Created by Elmira Andreeva on 7/14/17.
 */
public class MinCharsReqToMakeStrPalindromic {

    public int solve(String A) {
        int N = A.length();
        if (N <= 1) return 0;

        for (int j = N - 1; j >= 0; j--) {
            if (isPalindrome(A, j)) {
                return N - j - 1;
            }
        }

        return N - 1;
    }

    private boolean isPalindrome(String A, int len) {
        int i = 0, j = len;
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

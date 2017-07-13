package week1.strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class PalindromeString {

    public int isPalindrome(String a) {
        if (a == null || a.length() == 0) return 0;
        int N = a.length();
        int i = 0, j = N - 1;
        while (i < j) {
            while (i < N && !Character.isLetterOrDigit(a.charAt(i))) i++;
            while (j >= 0 && !Character.isLetterOrDigit(a.charAt(j))) j--;
            if (i < N && j >= 0 &&
                    Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(a.charAt(j))) return 0;
            i++;
            j--;
        }
        return 1;
    }
}

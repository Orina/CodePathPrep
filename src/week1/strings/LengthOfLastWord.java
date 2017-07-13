package week1.strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(final String a) {
        if (a == null || a.length() == 0) return 0;
        int N = a.length();
        int end = N - 1;

        while (end >= 0 && a.charAt(end) == ' ') end--;

        int start = end;
        while (start >= 0 && a.charAt(start) != ' ') start--;

        return end - start;
    }
}

package week1.strings;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Given s = "the sky is blue",
 *
 * return "blue is sky the".
 *
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class ReverseString {

    public String reverseWords(String a) {
        if (a == null || a.length() == 0) return a;
        char[] chArray = a.toCharArray();

        int N = a.length();
        swap(chArray, 0, N - 1);

        int start = -1;
        for (int i = 0; i < N; i++) {
            if (i == N - 1 || chArray[i] == ' ') {
                if (start != -1) {
                    int end = chArray[i] == ' ' ? i - 1 : i;
                    swap(chArray, start, end);
                    start = -1;
                }
            } else if (start == -1) start = i;
        }
        return new String(chArray);
    }

    private void swap(char[] arr, int lo, int hi) {
        if (lo >= hi) return;
        while (lo < hi) {
            char tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++;
            hi--;
        }
    }
}

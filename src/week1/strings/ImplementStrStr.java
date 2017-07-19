package week1.strings;

import java.util.Arrays;

/**
 * Created by Elmira Andreeva on 7/14/17.
 */
public class ImplementStrStr {

    /**
     * Boyer–Moore string search algorithm
     */
    public int strStr(final String txt, final String pattern) {
        if (txt == null || txt.length() == 0 || pattern == null || pattern.length() == 0) return -1;

        int R = 256;
        int[] right = new int[R];

        int N = txt.length(), M = pattern.length();

        Arrays.fill(right, -1);
        for (int i = 0; i < M; i++) {
            right[pattern.charAt(i)] = i;
        }

        int skip = 0;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (txt.charAt(i + j) != pattern.charAt(j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }
}
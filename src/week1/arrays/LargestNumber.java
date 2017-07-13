package week1.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example:
 *
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class LargestNumber {

    public static String largestNumber(final List<Integer> a) {
        if (a == null || a.size() == 0) return "";

        //sort in "special" descending order
        Collections.sort(a, new NumberComparator());

        if (a.get(0) == 0) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.size(); i++) {
            sb.append(a.get(i));
        }
        return sb.toString();
    }

    /**
     * Given two numbers a and b, how should compare(a, b) decide which number to put first?
     * we compare two numbers AB (b appended at the end of a) and BA (a appended at the end of b).
     */
    public static class NumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a.intValue() == b.intValue()) return 0;

            long ab = combine(a, b);
            long ba = combine(b, a);

            if (ab < ba) return 1;
            else if (ab > ba) return -1;
            else return 0;
        }

        private long combine(int a, int b) {
            long res = a;
            String strB = Integer.toString(b);
            for (int i = 0; i < strB.length(); i++) {
                res = res * 10 + (strB.charAt(i) - '0');
            }
            return res;
        }
    }
}

package week1.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 * Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
 * For example,
 * given strings "12", "10", your answer should be “120”.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        int N1 = num1.length(), N2 = num2.length();
        if (N1 == 0 || N2 == 0) return "0";
        if (num1.equals("0") || num2.equals("0")) return "0";

        char ch1 = num1.charAt(0);
        char ch2 = num2.charAt(0);
        boolean isNegative = (ch1 == '-' && ch2 != '-') || (ch1 != '-' && ch2 == '-');

        if (ch1 == '-') num1 = num1.replace("-", "");
        if (ch2 == '-') num2 = num2.replace("-", "");

        List<Integer> mult = new ArrayList();
        for (int i = 0; i < N1 + N2; i++) mult.add(0);

        for (int i = 0; i < N1; i++) {
            int a = Integer.parseInt(num1.charAt(N1 - i - 1) + "");
            for (int j = 0; j < N2; j++) {
                int b = Integer.parseInt(num2.charAt(N2 - j - 1) + "");
                mult.set(i + j, mult.get(i + j) + a * b);
                mult.set(i + j + 1, mult.get(i + j + 1) + mult.get(i + j) / 10);
                mult.set(i + j, mult.get(i + j) % 10);
            }
        }

        Collections.reverse(mult);

        int i = 0;
        while (i < N1 + N2 && mult.get(i) == 0) i++;

        StringBuilder sb = new StringBuilder();
        if (isNegative) sb.append("-");
        for (; i < N1 + N2; i++) sb.append(mult.get(i));

        return sb.toString();
    }
}

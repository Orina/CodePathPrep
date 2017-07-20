package week2.hashing;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example :
 *
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 *
 * https://www.interviewbit.com/problems/fraction/
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class Fraction {

    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";
        if (den == 0) return "";

        StringBuilder sb = new StringBuilder();
        if ((num < 0 && den > 0) || (num > 0 && den < 0)) sb.append("-");

        long numerator = Math.abs((long) num);
        long denominator = Math.abs((long) den);
        sb.append(numerator / denominator);

        long remain = numerator % denominator;
        if (remain == 0) return sb.toString();

        sb.append(".");

        HashMap<Long, Integer> hash = new HashMap();
        hash.put(remain, sb.length());

        while (remain != 0) {
            remain = remain * 10;
            sb.append(remain / denominator);
            remain = remain % denominator;
            if (hash.containsKey(remain)) {
                int index = hash.get(remain);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                hash.put(remain, sb.length());
            }
        }
        return sb.toString();
    }
}

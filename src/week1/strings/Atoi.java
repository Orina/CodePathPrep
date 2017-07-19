package week1.strings;

/**
 * There are certain questions where the interviewer would intentionally frame the question vague.
 * The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.
 *
 * Implement atoi to convert a string to an integer.
 *
 * Example :
 *
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
 *
 * Questions:
 * Q1. Does string contain whitespace characters before the number?
 * A. Yes
 *
 * Q2. Can the string have garbage characters after the number?
 * A. Yes. Ignore it.
 *
 * Q3. If no numeric character is found before encountering garbage characters, what should I do?
 * A. Return 0.
 *
 * Q4. What if the integer overflows?
 * A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 *
 * Created by Elmira Andreeva on 7/14/17.
 */
public class Atoi {

    public int atoi(final String a) {
        int N = a.length();
        int i = 0;

        //white spaces characters before the number
        while (i < N && a.charAt(i) == ' ') i++;

        //consider a sign
        boolean sign = false;
        if (a.charAt(i) == '-') {
            sign = true;
            i++;
        } else if (a.charAt(i) == '+') i++;

        long res = 0;
        //consider the main place for a number
        while (i < N && Character.isDigit(a.charAt(i))) {
            int value = a.charAt(i) - '0';
            if ((res * 10 + value) > Integer.MAX_VALUE) return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + value;
            i++;
        }

        return (int) (sign ? -res : res);
    }
}

package week1.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 *
 * Created by elmira on 7/11/17.
 */
public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> sum = new ArrayList<Integer>();
        if (a == null || a.size() == 0) {
            sum.add(1);
            return sum;
        }

        int N = a.size();
        int carry = 1;

        for (int i = N - 1; i >= 0; i--) {
            int digit = a.get(i) + carry;
            sum.add(digit % 10);
            carry = digit / 10;
        }

        if (carry > 0) sum.add(carry);

        Collections.reverse(sum);

        Iterator<Integer> it = sum.iterator();
        while (it.hasNext() && it.next() == 0) {
            it.remove();
        }
        return sum;
    }
}
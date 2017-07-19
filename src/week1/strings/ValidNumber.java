package week1.strings;

/**
 * Validate if a given string is numeric.
 *
 * Examples:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Clarify the question using “See Expected Output”
 *
 * Is 1u ( which may be a representation for unsigned integers valid?
 * For this problem, no.
 * Is 0.1e10 valid?
 * Yes
 * -01.1e-10?
 * Yes
 * Hexadecimal numbers like 0xFF?
 * Not for the purpose of this problem
 * 3. (. not followed by a digit)?
 * No
 * Can exponent have decimal numbers? 3e0.1?
 * Not for this problem.
 * Is 1f ( floating point number with f as prefix ) valid?
 * Not for this problem.
 * How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
 * Not for this problem.
 * How about integers preceded by 00 or 0? like 008?
 * Yes for this problem
 *
 * Created by Elmira Andreeva on 7/14/17.
 */
public class ValidNumber {

    public int isNumber(final String A) {
        String a = A.trim();
        int N = a.length();

        if (N == 0) return 0;

        boolean hasDigit = false;
        boolean hasE = false;

        for (int i = 0; i < N; i++) {
            char ch = a.charAt(i);
            //check the sigh and verify that this character is not alone
            if ((ch == '-' || ch == '+') && i == 0 && i < N - 1) {
                continue;
            }
            //if '-' sign is following right after the 'e'
            else if (ch == '-' && i > 0 && a.charAt(i - 1) == 'e') continue;
            else if (Character.isDigit(ch)) continue;
            else if (ch == '.') {
                //'.' can't follow after the 'e' character seen before
                if (hasE) return 0;
                //'.' is the last character or we already met a '.' character before
                if (hasDigit || i == N - 1) return 0;
                //next character after the '.' has to be a digit
                if (!Character.isDigit(a.charAt(i + 1))) return 0;
                //set flag
                hasDigit = true;
            } else if (ch == 'e') {
                //if  we already seen 'e' character before
                if (hasE) return 0;
                //set flag to true
                hasE = true;
            } else return 0;
        }
        return 1;
    }
}

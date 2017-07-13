package week1.strings;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Read more details about roman numerals at Roman Numeric System
 *
 * Example :
 *
 * Input : "XIV"
 * Return : 14
 * Input : "XX"
 * Output : 20
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class RomanToInteger {

    public int romanToInt(String a) {
        if (a == null || a.length() == 0) return 0;
        HashMap<Character, Integer> hash = new HashMap();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);

        int N = a.length();
        int count = hash.get(a.charAt(N - 1));

        for (int i = N - 2; i >= 0; i--) {
            int curValue = hash.get(a.charAt(i));
            int prevValue = hash.get(a.charAt(i + 1));

            if (curValue < prevValue) count -= curValue;
            else count += curValue;
        }

        return count;
    }
}

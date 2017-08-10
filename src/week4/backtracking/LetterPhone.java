package week4.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Elmira Andreeva on 8/8/17.
 */
public class LetterPhone {

    public ArrayList<String> letterCombinations(String a) {
        HashMap<Integer, String> hashDigits = new HashMap();
        hashDigits.put(0, "0");
        hashDigits.put(1, "1");
        hashDigits.put(2, "abc");
        hashDigits.put(3, "def");
        hashDigits.put(4, "ghi");
        hashDigits.put(5, "jkl");
        hashDigits.put(6, "mno");
        hashDigits.put(7, "pqrs");
        hashDigits.put(8, "tuv");
        hashDigits.put(9, "wxyz");

        ArrayList<String> result = new ArrayList();
        generate(0, a, "", result, hashDigits);
        return result;
    }

    private void generate(int pos, String src, String prefix, ArrayList<String> result,
                          HashMap<Integer, String> hashDigits) {
        if (prefix.length() == src.length()) {
            result.add(prefix);
            return;
        }
        int digit = src.charAt(pos) - '0';
        String chars = hashDigits.get(digit);
        for (int i = 0; i < chars.length(); i++) {
            generate(pos + 1, src, prefix + chars.charAt(i), result, hashDigits);
        }
    }
}
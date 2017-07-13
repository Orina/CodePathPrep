package week1.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 *
 * Example:
 *
 * Given “25525511135”,
 *
 * return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class ValidIpAddresses {

    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> res = new ArrayList<String>();
        restore(0, a, new ArrayList(), res);
        return res;
    }

    private void restore(int offset, String a, List<Integer> curList, ArrayList<String> result) {
        if (curList.size() == 4 && offset == a.length()) {
            result.add(generateString(curList));
            return;
        }
        if (curList.size() >= 4 || offset == a.length()) return;

        int value = 0;
        for (int i = offset; i < a.length() && i < offset + 3; i++) {
            int c = a.charAt(i) - '0';

            if (i > offset && value == 0) return;

            value = value * 10 + c;

            if (value < 256) {
                curList.add(value);
                restore(i + 1, a, curList, result);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private String generateString(List<Integer> curList) {
        int N = curList.size();
        StringBuilder sb = new StringBuilder();
        for (int value : curList) {
            sb.append(value).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

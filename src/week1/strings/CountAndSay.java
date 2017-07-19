package week1.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 *
 * 21 is read off as one 2, then one 1 or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Example:
 *
 * if n = 2,
 * the sequence is 11.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        if (n == 2) return "11";

        StringBuilder sb = new StringBuilder();

        List<Integer> seq = new ArrayList();
        List<Integer> newSeq = new ArrayList();

        seq.add(1);
        seq.add(1);

        for (int i = 3; i <= n; i++) {
            int count = 1;
            int value = seq.get(0);

            for (int j = 1; j < seq.size(); j++) {
                if (j == seq.size() - 1) {
                    if (seq.get(j) == value) {
                        newSeq.add(count + 1);
                        newSeq.add(value);
                    } else {
                        newSeq.add(count);
                        newSeq.add(value);

                        newSeq.add(1);
                        newSeq.add(seq.get(j));
                    }
                } else if (value == seq.get(j)) {
                    count++;
                } else {
                    newSeq.add(count);
                    newSeq.add(value);

                    value = seq.get(j);
                    count = 1;
                }
            }

            seq = new ArrayList(newSeq);
            newSeq.clear();
        }
        for (int v : seq) {
            sb.append(v);
        }
        return sb.toString();
    }
}
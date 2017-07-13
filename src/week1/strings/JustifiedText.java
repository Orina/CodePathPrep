package week1.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 *
 * Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Your program should return a list of strings, where each string represents a single line.
 *
 * Example:
 *
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 *
 * L: 16.
 *
 * Return the formatted lines as:
 *
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class JustifiedText {

    public ArrayList<String> fullJustify(ArrayList<String> a, int L) {
        ArrayList<String> result = new ArrayList();
        int N = a.size();
        int charCount = 0;
        List<Integer> indexes = new ArrayList();

        for (int i = 0; i < N; i++) {
            if (charCount + a.get(i).length() > L) {
                result.add(justifyString(a, indexes, L));
                charCount = 0;
                indexes.clear();
            }
            charCount += a.get(i).length() + 1;
            indexes.add(i);
        }
        if (charCount > 0) {
            result.add(justifyLeft(a, indexes, L));
        }
        return result;
    }

    private String justifyLeft(ArrayList<String> a, List<Integer> indexes, int L) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indexes.size(); i++) {
            sb.append(a.get(indexes.get(i)));
            if (i < indexes.size() - 1) sb.append(' ');
        }

        int spacesToAppend = Math.max(0, L - sb.length());
        for (int j = 0; j < spacesToAppend; j++) sb.append(' ');

        return sb.toString();
    }

    private String justifyString(ArrayList<String> a, List<Integer> indexes, int L) {
        if (indexes.size() == 1) {
            return justifyLeft(a, indexes, L);
        }
        StringBuilder sb = new StringBuilder();
        int spaces = indexes.size() - 1;

        int totalChars = 0;
        for (int index : indexes) totalChars += a.get(index).length();

        int remainSpaces = L - totalChars;

        int[] spacesCount = new int[spaces];
        Arrays.fill(spacesCount, 1);
        remainSpaces -= spaces;

        int j = 0;
        while (remainSpaces > 0) {
            spacesCount[j]++;
            j++;
            if (j == spacesCount.length) j = 0;
            remainSpaces--;
        }

        int medianSpaces = Math.min(1, (int) Math.round((L - totalChars) / spaces));

        for (int i = 0; i < indexes.size(); i++) {
            sb.append(a.get(indexes.get(i)));
            int spacesToAppend = 0;
            if (i < spacesCount.length) {
                spacesToAppend = spacesCount[i];
            }
            for (int k = 0; k < spacesToAppend; k++) sb.append(' ');

        }
        return sb.toString();
    }
}

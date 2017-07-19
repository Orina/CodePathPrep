package week1.strings;

import java.util.ArrayList;

/**
 * Pretty print a json object using proper indentation.
 *
 * Every inner brace should increase one indentation to the following lines.
 * Every close brace should decrease one indentation to the same line and the following lines.
 * The indents can be increased with an additional ‘\t’
 * Example 1:
 *
 * Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
 * Output :
 * {
 * A:"B",
 * C:
 * {
 * D:"E",
 * F:
 * {
 * G:"H",
 * I:"J"
 * }
 * }
 * }
 * Example 2:
 *
 * Input : ["foo", {"bar":["baz",null,1.0,2]}]
 * Output :
 * [
 * "foo",
 * {
 * "bar":
 * [
 * "baz",
 * null,
 * 1.0,
 * 2
 * ]
 * }
 * ]
 * [] and {} are only acceptable braces in this case.
 *
 * Assume for this problem that space characters can be done away with.
 *
 * Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
 *
 * Created by Elmira Andreeva on 7/17/17.
 */
public class PrettyJson {

    public ArrayList<String> prettyJSON(String a) {

        int N = a.length();
        ArrayList<String> result = new ArrayList();

        int level = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char ch = a.charAt(i);
            if (ch == '{' || ch == '[') {
                sb.append(ch);
                result.add(sb.toString());

                level++;
                sb.delete(0, sb.length());
                appendTabs(sb, level);
            } else if (ch == '}' || ch == ']') {
                if (sb.length() > 0) {
                    result.add(sb.toString());
                    sb.delete(0, sb.length());
                }

                level--;
                appendTabs(sb, level);
                sb.append(ch);

                if (i == N - 1) result.add(sb.toString());
            } else if (ch == ',') {
                sb.append(ch);
                result.add(sb.toString());

                sb.delete(0, sb.length());
                appendTabs(sb, level);
            } else if (ch == ':') {
                if (a.charAt(i + 1) == '{' || a.charAt(i + 1) == '[') {
                    sb.append(ch);
                    result.add(sb.toString());

                    sb.delete(0, sb.length());
                    appendTabs(sb, level);
                } else sb.append(ch);
            } else {
                sb.append(ch);
            }
        }

        return result;
    }

    private void appendTabs(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) sb.append("\t");
    }
}

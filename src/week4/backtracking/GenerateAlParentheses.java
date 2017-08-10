package week4.backtracking;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Make sure the returned list of strings are sorted.
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class GenerateAlParentheses {

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList();
        generate(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void generate(int open, int close, int n, StringBuilder sb, ArrayList<String> res) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            generate(open + 1, close, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        // we can't add "(" if there is no enough ")" before it
        if (close < open && close < n) {
            sb.append(")");
            generate(open, close + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

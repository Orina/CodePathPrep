package week4.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * N Queens: Example 1
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * https://www.interviewbit.com/problems/nqueens/
 *
 * Created by Elmira Andreeva on 8/8/17.
 */
public class NQueens {

    private StringBuilder sb = new StringBuilder();

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void solveNQueens(int n, int row, List<Integer> columns, ArrayList<ArrayList<String>> result) {
        if (row == n) {
            ArrayList<String> placements = new ArrayList();
            for (int i = 0; i < n; i++) {
                placements.add(generateQueenPlacement(columns.get(i), n));
            }
            result.add(placements);
        }
        for (int col = 0; col < n; col++) {
            columns.add(col);
            if (isNotAttackingPlacement(columns)) {
                solveNQueens(n, row + 1, columns, result);
            }
            columns.remove(columns.size() - 1);
        }
    }

    private boolean isNotAttackingPlacement(List<Integer> columns) {
        int rowAdded = columns.size() - 1;
        for (int row = 0; row < rowAdded; row++) {
            int diff = Math.abs(columns.get(row) - columns.get(rowAdded));
            //same column
            if (diff == 0) return false;
            //on the same diagonal
            if (diff == rowAdded - row) return false;
        }
        return true;
    }

    private String generateQueenPlacement(int k, int n) {
        sb.delete(0, sb.length());
        for (int i = 0; i < n; i++) {
            if (i == k) sb.append("Q");
            else sb.append(".");
        }
        return sb.toString();
    }
}

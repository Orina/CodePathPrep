package week2.hashing;

import java.util.List;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 *
 * The input corresponding to the above configuration :
 *
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 * A partially filled sudoku which is valid.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * https://www.interviewbit.com/problems/valid-sudoku/
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class ValidSudoku {

    public int isValidSudoku(final List<String> a) {

        int N = a.size();
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = a.get(i);
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // check every row
        for (int row = 0; row < N; row++) {
            if (hasDuplicates(board, row, row + 1, 0, N, N)) return 0;
        }

        //check every column
        for (int col = 0; col < N; col++) {
            if (hasDuplicates(board, 0, N, col, col + 1, N)) return 0;
        }

        // check sub-grids
        int n = (int) Math.sqrt(N);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(board, i * n, (i + 1) * n, j * n, (j + 1) * n, N)) return 0;
            }
        }

        return 1;
    }

    private boolean hasDuplicates(char[][] board, int startRow, int endRow, int startCol, int endCol, int num) {
        boolean[] marked = new boolean[num];

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] == '.') continue;
                int index = board[i][j] - '1';
                if (marked[index]) return true;
                marked[index] = true;
            }
        }
        return false;
    }
}

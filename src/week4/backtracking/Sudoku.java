package week4.backtracking;

import java.util.ArrayList;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'
 * You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 * Example :
 *
 * For the above given diagrams, the corresponding input to your program will be
 *
 * [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 * and we would expect your program to modify the above array of array of characters to
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 * https://www.interviewbit.com/problems/sudoku/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class Sudoku {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudoku(0, 0, a, a.size());
    }

    private boolean solveSudoku(int i, int j, ArrayList<ArrayList<Character>> partialAssignment, int N) {
        if (i == N) {
            //start new row
            i = 0;
            j++;
            //entire board has been filled without a conflict
            if (j == N) return true;
        }
        // skip not empty entries
        if (partialAssignment.get(i).get(j) != '.') {
            return solveSudoku(i + 1, j, partialAssignment, N);
        }

        for (char value = '1'; value <= '9'; value++) {
            if (canAddValue(i, j, value, partialAssignment, N)) {
                partialAssignment.get(i).set(j, value);
                if (solveSudoku(i + 1, j, partialAssignment, N)) {
                    return true;
                }
            }
        }
        partialAssignment.get(i).set(j, '.');
        return false;
    }

    private boolean canAddValue(int i, int j, char value, ArrayList<ArrayList<Character>> partialAssignment, int N) {
        //check row constraints
        for (int row = 0; row < N; row++) {
            if (partialAssignment.get(row).get(j) == value) return false;
        }
        //check column constraints
        for (int col = 0; col < N; col++) {
            if (partialAssignment.get(i).get(col) == value) return false;
        }
        //check region constraints
        int regionSize = (int) Math.sqrt(N);
        int regionI = i / regionSize;
        int regionJ = j / regionSize;

        for (int a = 0; a < regionSize; a++) {
            for (int b = 0; b < regionSize; b++) {
                if (partialAssignment.get(regionI * regionSize + a).get(regionJ * regionSize + b) == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
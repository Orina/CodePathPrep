package week3.binary_search;

import java.util.ArrayList;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return 1 ( 1 corresponds to true )
 *
 * Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class MatrixSearch {

    /**
     * Main idea is to calculate the difference between distances of 2 cells: lo and hi
     * than calculate the middle cell:
     * midX = loX + (loY + diff) / M;
     * midY = (loY + diff) % M;
     */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int b) {
        if (matrix == null || matrix.size() == 0) return 0;

        int N = matrix.size();
        int M = matrix.get(0).size();

        int loX = 0, loY = 0;
        int hiX = N - 1, hiY = M - 1;

        while (dist(hiX, hiY, M) >= dist(loX, loY, M)) {

            int diff = (dist(hiX, hiY, M) - dist(loX, loY, M)) / 2;

            int midX = loX + (loY + diff) / M;
            int midY = (loY + diff) % M;

            if (matrix.get(midX).get(midY) == b) return 1;

            else if (matrix.get(midX).get(midY) < b) {
                if (midY == M - 1) {
                    loY = 0;
                    loX = midX + 1;
                } else {
                    loY = midY + 1;
                    loX = midX;
                }
            } else {
                if (midY == 0) {
                    hiY = M - 1;
                    hiX = midX - 1;
                } else {
                    hiY = midY - 1;
                    hiX = midX;
                }
            }
        }
        return 0;
    }

    private int dist(int x, int y, int M) {
        return x * M + y;
    }
}

package week1.arrays;

import java.util.ArrayList;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Given n = 3,
 *
 * You should return the following matrix:
 * [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class SpiralOrderMatrixII {

    int currentValue = 1;

    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        currentValue = 1;

        //generate empty matrix with 0-s
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> subList = new ArrayList();
            for (int j = 0; j < n; j++) {
                subList.add(0);
            }
            result.add(subList);
        }

        //print matrix by layers starting from the most outer layer
        for (int offset = 0; offset < (n + 1) / 2; offset++) {
            printLayer(offset, n, result);
        }

        return result;
    }

    private void printLayer(int offset, int n, ArrayList<ArrayList<Integer>> a) {
        //only one element per current layer
        if (offset == n - offset - 1) {
            a.get(offset).set(offset, currentValue++);
            return;
        }
        //print top horizontal
        for (int cols = offset; cols < n - offset - 1; cols++) {
            a.get(offset).set(cols, currentValue++);
        }

        //print right vertical
        for (int rows = offset; rows < n - offset - 1; rows++) {
            a.get(rows).set(n - offset - 1, currentValue++);
        }

        // print bottom horizontal
        for (int cols = n - offset - 1; cols > offset; cols--) {
            a.get(n - offset - 1).set(cols, currentValue++);
        }

        //print left vertical
        for (int rows = n - offset - 1; rows > offset; rows--) {
            a.get(rows).set(offset, currentValue++);
        }
    }
}

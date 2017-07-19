package week1.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example:
 *
 * Given the following matrix:
 *
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return
 *
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class SpiralOrderMatrixI {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int m = a.size();
        int n = a.get(0).size();

        for (int offset = 0; offset < Math.min((m + 1) / 2, (n + 1) / 2); offset++) {
            printLayer(offset, m, n, a, result);
        }

        return result;
    }

    private void printLayer(int offset, int m, int n, List<ArrayList<Integer>> a, ArrayList<Integer> result) {
        if (offset == m - offset - 1 && offset == n - offset - 1) {
            result.add(a.get(offset).get(offset));
            return;
        } else if (offset == m - offset - 1) {
            //print horizontal line
            for (int cols = offset; cols < n - offset; cols++) {
                result.add(a.get(offset).get(cols));
            }
        } else if (offset == n - offset - 1) {
            //print vertical line
            for (int rows = offset; rows < m - offset; rows++) {
                result.add(a.get(rows).get(n - offset - 1));
            }
        } else {
            //print top horizontal
            for (int cols = offset; cols < n - offset - 1; cols++) {
                result.add(a.get(offset).get(cols));
            }

            //print right vertical
            for (int rows = offset; rows < m - offset - 1; rows++) {
                result.add(a.get(rows).get(n - offset - 1));
            }

            // print bottom horizontal
            for (int cols = n - offset - 1; cols > offset; cols--) {
                result.add(a.get(m - offset - 1).get(cols));
            }

            //print left vertical
            for (int rows = m - offset - 1; rows > offset; rows--) {
                result.add(a.get(rows).get(offset));
            }
        }
    }
}

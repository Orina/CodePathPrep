package prework.checkpoint2;

import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 * Let us show you some examples to clarify what we mean.
 *
 * Example 1:
 *
 * Input: A = 4.
 * Output:
 *
 * 4 4 4 4 4 4 4
 * 4 3 3 3 3 3 4
 * 4 3 2 2 2 3 4
 * 4 3 2 1 2 3 4
 * 4 3 2 2 2 3 4
 * 4 3 3 3 3 3 4
 * 4 4 4 4 4 4 4
 *
 * Solution:
 *
 * 1. calculate the number of rows/cols as N = 2*a - 1
 * 2. create an empty matrix (List of List) and populate it with zeroes
 * 3. print by layer from offset = 0 to a
 * 3.1. print top horizontal line
 * 3.2 print right vertical line
 * 3.3. print bottom horizontal line
 * 3.4. print left vertical line.
 * 4. return matrix
 *
 *
 * time: O(N^2)
 * space: O(N^2)
 *
 * Created by Elmira Andreeva on 6/28/2017.
 */
public class Prettyprint {

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        int N = a + (a - 1);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                list.add(0);
            }
            result.add(list);
        }

        int value = a;
        for (int offset = 0; offset < a; offset++) {
            printLayer(offset, N, result, value--);
        }
        return result;
    }

    void printLayer(int offset, int N, ArrayList<ArrayList<Integer>> a, int value) {
        // top horizontal
        for (int col = offset; col < N - offset - 1; col++) a.get(offset).set(col, value);

        // right vertical
        for (int row = offset; row < N - offset - 1; row++) a.get(row).set(N - offset - 1, value);

        //bottom horizontal
        for (int col = N - offset - 1; col >= offset; col--) a.get(N - offset - 1).set(col, value);

        // left vertical
        for (int row = N - offset - 1; row >= offset; row--) a.get(row).set(offset, value);
    }
}

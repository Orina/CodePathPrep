package week1.arrays;

import java.util.ArrayList;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * [
 * [1, 2],
 * [3, 4]
 * ]
 * Then the rotated array becomes:
 *
 * [
 * [3, 1],
 * [4, 2]
 * ]
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int offset = 0; offset < n / 2; offset++) {
            rotateLayer(offset, n, a);
        }
    }

    private void rotateLayer(int offset, int n, ArrayList<ArrayList<Integer>> a) {
        for (int i = offset; i < n - offset - 1; i++) {
            int tmp = a.get(offset).get(i);
            a.get(offset).set(i, a.get(n - i - 1).get(offset));
            a.get(n - i - 1).set(offset, a.get(n - offset - 1).get(n - i - 1));
            a.get(n - offset - 1).set(n - i - 1, a.get(i).get(n - offset - 1));
            a.get(i).set(n - offset - 1, tmp);
        }
    }
}

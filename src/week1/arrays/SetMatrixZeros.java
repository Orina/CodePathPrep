package week1.arrays;

import java.util.ArrayList;

/**
 * Created by Elmira Andreeva on 7/12/17.
 */
public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        if (m == 0) return;
        int n = a.get(0).size();

        boolean clearFirstRow = false, clearFirstCol = false;
        for (int row = 0; row < m; row++) {
            if (a.get(row).get(0) == 0) {
                clearFirstCol = true;
                break;
            }
        }
        for (int col = 0; col < n; col++) {
            if (a.get(0).get(col) == 0) {
                clearFirstRow = true;
                break;
            }
        }
        // if a[row][col]=="0", then set "0" to first row (a[0][col]) and first columns (a[row][0])
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (a.get(row).get(col) == 0) {
                    a.get(0).set(col, 0);
                    a.get(row).set(0, 0);
                }
            }
        }
        //update the matrix with zeroes based on first rows and first columns zero-values
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (a.get(row).get(0) == 0 || a.get(0).get(col) == 0) {
                    a.get(row).set(col, 0);
                }
            }
        }
        //clear first row if needed (if there were zeros before we start process the matrix)
        if (clearFirstRow) {
            for (int col = 0; col < n; col++) {
                a.get(0).set(col, 0);
            }
        }
        //clear first column if needed (if there were zeros before we start process the matrix)
        if (clearFirstCol) {
            for (int row = 0; row < m; row++) {
                a.get(row).set(0, 0);
            }
        }
    }
}

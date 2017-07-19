package week1.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 *
 * Created by Elmira Andreeva on 7/17/17.
 */
public class NobleInteger {

    /**
     * idea: do not need to sort the full array.
     * do a 3Way partition (as the initial array may contains duplicates),
     *
     * then decide if the pivot is the required element, return true
     * otherwise choose what part to sort/proceed:
     *
     * as if a[lt] > k, then no sense to look up the the right sub-array, go to the left
     * otherwise, got ot the right
     */
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            List<Integer> res = partition3Way(A, lo, hi);
            int lt = res.get(0);
            int gt = res.get(1);

            int count = N - gt - 1;

            if (A.get(lt) == count) return 1;
            else if (A.get(lt) > count) hi = lt - 1;
            else lo = gt + 1;

        }
        return -1;
    }

    List<Integer> partition3Way(ArrayList<Integer> A, int lo, int hi) {
        if (lo == hi) {
            ArrayList res = new ArrayList();
            res.add(lo);
            res.add(hi);
            return res;
        }
        int pivot = A.get(lo);
        int lt = lo;
        int gt = hi;
        int i = lo + 1;

        while (i <= gt) {
            if (A.get(i) == pivot) {
                i++;
            } else if (A.get(i) < pivot) {
                Collections.swap(A, lt, i);
                i++;
                lt++;
            } else {
                Collections.swap(A, i, gt);
                gt--;
            }
        }

        ArrayList res = new ArrayList();
        res.add(lt);
        res.add(gt);
        return res;
    }

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{5, 6, 2};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(ar));
        System.out.print("result: " + new NobleInteger().solve(list));
    }
}
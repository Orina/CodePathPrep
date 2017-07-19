package week1.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
 * Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
 * If A is already sorted, output -1.
 *
 * Example :
 *
 * Input 1:
 *
 * A = [1, 3, 2, 4, 5]
 *
 * Return: [1, 2]
 *
 * Input 2:
 *
 * A = [1, 2, 3, 4, 5]
 *
 * Return: [-1]
 * In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class MaximumUnsortedSubarray {

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList();

        if (A == null || A.size() == 0) {
            result.add(-1);
            return result;
        }
        int N = A.size();
        int startIndex = -1, endIndex = -1;

        for (int i = 1; i < N; i++) {
            if (A.get(i) < A.get(i - 1)) {
                if (startIndex == -1) startIndex = i - 1;
                endIndex = i;
            }
        }
        System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);

        if (startIndex == -1) {
            result.add(-1);
            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = startIndex; i <= endIndex; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        //go backward to find the start index
        int j = 0;
        while (j < endIndex && A.get(j) <= min) {
            j++;
        }
        startIndex = j;

        //go forward to find the end index
        j = N - 1;
        while (j >= endIndex && A.get(j) >= max) {
            j--;
        }
        endIndex = j;

        result.add(startIndex);
        result.add(endIndex);

        return result;
    }

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{1, 3, 2, 4, 5};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(ar));
        new MaximumUnsortedSubarray().subUnsort(list);
    }
}

package week3.binary_search;

import common.Base;

import java.util.Arrays;
import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Sample Input
 *
 * A : [1 4 5]
 * B : [2 3]
 *
 * Sample Output
 *
 * 3
 * NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
 * For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 *
 * Created by Elmira Andreeva on 8/1/17.
 */
public class MedianOfArray extends Base {

    public static double findMedianSortedArrays(List<Integer> a, List<Integer> b) {
        if (a.size() == 0 && b.size() == 0) return 0;
        if (a.size() == 0) return getMedian(b);
        if (b.size() == 0) return getMedian(a);

        if (a.size() < b.size()) {
            List<Integer> tmp = a;
            a = b;
            b = tmp;
        }

        int N = a.size() + b.size();
        int k = N / 2;
        println("k: " + k);

        //lower bounds of elements we will choose in A
        int lo = Math.max(0, k - b.size());

        //upper bounds of elements we will choose in A
        int hi = Math.min(k, a.size());

        while (lo < hi) {
            int x = lo + (hi - lo) / 2;
            println("lo: " + lo + ", hi: " + hi + ", x: " + x);

            if (x >= a.size() || k - x - 1 < 0 || a.get(x) < b.get(k - x - 1)) {
                //a[x] must be in the first k-1 elements of the union
                lo = x + 1;
            } else if (x <= 0 || k - x >= b.size() || a.get(x - 1) > b.get(k - x)) {
                //a[x-1] can not be in the first k elements
                hi = x - 1;
            } else {
                //b[k-x-1] <=a[x] && a[x-1] <=b[k-x]
                if (N % 2 == 0) {
                    int max = Math.max(a.get(x - 1), b.get(k - x - 1));
                    return (max + Math.min(a.get(x), b.get(k - x))) / 2.0;
                } else {
                    return Math.min(a.get(x), b.get(k - x));
                }
            }
        }
        println("AFTER lo: " + lo + ", hi: " + hi);
        int x = lo;

        if (x == 0 || x == a.size()) return b.get(k);

        if (N % 2 == 0) {
            if (k - x == 0) return (a.get(x - 1) + Math.min(a.get(x), b.get(k - x))) / 2.0;
            int max = Math.max(a.get(x - 1), b.get(k - x - 1));
            if (k - x >= b.size()) return (max + a.get(x)) / 2.0;
            else if (x >= a.size()) return (max + b.get(k - x)) / 2.0;
            else return (max + Math.min(a.get(x), b.get(k - x))) / 2.0;
        } else {
            if (k - x - 1 < 0) return Math.min(a.get(x), b.get(k - x));
            if (k - x == b.size()) return a.get(x);
            else return Math.min(a.get(x), b.get(k - x));
        }
    }

    private static double getMedian(List<Integer> a) {
        int n = a.size();
        if (n == 0) return 0;
        if (n == 1) return a.get(0);
        return n % 2 == 0 ? (a.get(n / 2 - 1) + a.get(n / 2)) / 2.0 : a.get(n / 2);
    }

    public static void main(String[] args) {
        List a = Arrays.asList(-1);
        List b = Arrays.asList(-1, 0, 4, 11, 18);

        printList(a);
        printList(b);

        println("median: " + findMedianSortedArrays(a, b));
    }
}

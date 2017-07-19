package week1.arrays;

import java.util.Collections;
import java.util.List;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * Example :
 *
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 *
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 *
 * Created by Elmira Andreeva on 7/17/17.
 */
public class MaximumConsecutiveGap {

    public int maximumGap(final List<Integer> a) {

        int N = a.size();
        if (N == 1) return 0;

        int min = Collections.min(a);
        int max = Collections.max(a);

        if (N == 2) {
            return max - min;
        }

        int gap = Math.max(1, (max - min) / (N - 1));
        Bucket[] buckets = new Bucket[N - 1];

        for (int i = 0; i < N; i++) {
            int bucketNumber = (a.get(i) - min) / gap;
            if (bucketNumber > (N - 2)) bucketNumber = N - 2;

            if (buckets[bucketNumber] != null) {
                buckets[bucketNumber].add(a.get(i));
            } else {
                buckets[bucketNumber] = new Bucket(a.get(i));
            }
        }


        Bucket prev = null;
        int i = 0;

        while (prev == null && i < N - 1) prev = buckets[i++];
        if (prev == null) return 0;

        int maxGap = prev.max - prev.min;

        while (i < N - 1) {
            Bucket cur = buckets[i++];
            if (cur == null) continue;

            maxGap = Math.max(maxGap, cur.min - prev.max);

            prev = cur;
        }

        return maxGap;
    }

    static class Bucket {
        int min, max;

        public Bucket(int v) {
            this.min = max = v;
        }

        public void add(int v) {
            if (v < min) min = v;
            else if (v > max) max = v;
        }
    }
}

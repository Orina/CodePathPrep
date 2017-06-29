package prework.checkpoint5;

import java.util.HashMap;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Example:
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Solution:
 * Idea: create a hash map with key = value of elements in the array
 * value = boolean indicates did we already we count the consecutive sequence with that number or not
 *
 * 1. create a hash map and put all elements with false values, as we did not process any element yet
 * 2. maintain a global maxCount
 * 3. traverse through the array and check every element a[i]
 * 3.1. if element a[i] has "true" value in hash map, this means that we already
 * calculate the count of that consecutive sequence, ignore it
 * 3.2. go to the left side: check if there exists values = a[i]-1, a[i]-2, etc in the hash map,
 * if so, increment the local count and update the hash map for that values
 * 3.3. do the same for the right side.
 * 3.4. compare local max with global max.
 * 4. return global max.
 *
 * time: O(n)?
 * space: O(n)
 *
 * Created by Elmira Andreeva on 6/28/2017.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> a) {
        if (a == null || a.size() == 0) return 0;

        HashMap<Integer, Boolean> hashMap = new HashMap();
        for (int i = 0; i < a.size(); i++) hashMap.put(a.get(i), false);

        int maxCount = 0;
        for (int i = 0; i < a.size(); i++) {

            if (hashMap.get(a.get(i))) continue;
            int count = 1;

            int lessValue = a.get(i) - 1;
            while (hashMap.containsKey(lessValue)) {
                count++;
                hashMap.put(lessValue, true);
                lessValue--;
            }

            int moreValue = a.get(i) + 1;
            while (hashMap.containsKey(moreValue)) {
                count++;
                hashMap.put(moreValue, true);
                moreValue++;
            }

            hashMap.put(a.get(i), true);
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }
}

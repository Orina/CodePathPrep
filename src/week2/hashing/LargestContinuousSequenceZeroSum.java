package week2.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 *
 * Example:
 *
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 *
 * Created by Elmira Andreeva on 7/19/17.
 */
public class LargestContinuousSequenceZeroSum {

    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a == null || a.size() == 0) return result;

        HashMap<Integer, Integer> hash = new HashMap();
        hash.put(0, -1);
        int start = -1, end = -1, max = -1;

        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            // this means that we have a continues sum equal to 0 from index=hash.get(sum)+1
            // ex, 1+ 2 + (-2), hash keys: (0, 1, 3) and we encounter an aggregated sum=1. we has a "1" key in the hash table,
            // so since hash.get(1)+1 till current value  there is a continues sequence equal to zero
            // i.e. starting from some aggregated sum we have a continues sum = 0, as aggregated number already exists in the hash table!
            if (hash.containsKey(sum)) {
                int prevIndex = hash.get(sum);
                if (max < i - prevIndex) {
                    start = prevIndex + 1;
                    end = i + 1;
                    max = i - prevIndex;
                }
            } else {
                //save aggregated sum in the hash table
                hash.put(sum, i);
            }
        }
        if (start != -1 && end != -1) return new ArrayList<Integer>(a.subList(start, end));
        else return new ArrayList<Integer>();
    }
}
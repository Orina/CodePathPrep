package week2.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Sample Input :
 *
 * (1, 1)
 * (2, 2)
 * Sample Output :
 *
 * 2
 * You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])
 *
 * Created by Elmira Andreeva on 7/26/17.
 */
public class PointsOnStraightLine {

    /**
     * Base idea: if 2 points are on the same line (y = ax+b), then a = (y2-y1)/(x2-x1) this is a slot for 2 points. If 3rd point on the same line, then a=(y3-y1)/(x3-x1)==(y2-y1)/(x2-x1)
     * compare every point i with other points j, where j = i+1 to N
     * compute a slot for every points j and store the count in hashMap<key==slot, value=counts of points with corresponding slot>
     * calculate a local max and global max
     */
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {

        HashMap<Double, Integer> hash = new HashMap();

        int N = a.size();
        if (N == 0) return 0;
        if (N == 1) return 1;
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            hash.clear();
            int localMax = 0;
            int samePoints = 1;
            for (int j = i + 1; j < N; j++) {
                if (a.get(i) == a.get(j) && b.get(i) == b.get(j)) {
                    samePoints++;
                } else {
                    double ratio = Double.MAX_VALUE;
                    if (a.get(i) != a.get(j)) {
                        ratio = Math.abs(((double) (b.get(i) - b.get(j))) / (a.get(i) - a.get(j)));
                        ratio = ((int) (ratio * 1000.0)) / 1000.0;
                    }
                    int count = 1;
                    if (hash.containsKey(ratio)) {
                        count = hash.get(ratio) + 1;
                    }
                    hash.put(ratio, count);
                    localMax = Math.max(localMax, count);
                }
            }
            maxCount = Math.max(maxCount, localMax + samePoints);
        }
        return maxCount;
    }
}
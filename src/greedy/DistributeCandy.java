package greedy;

import java.util.ArrayList;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Sample Input :
 *
 * Ratings : [1 2]
 * Sample Output :
 *
 * 3
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
 *
 * Created by Elmira Andreeva on 7/13/17.
 */
public class DistributeCandy {

    public int candy(ArrayList<Integer> rating) {
        int N = rating.size();
        if (N == 0) return 0;
        if (N == 1) return 1;

        int[] candies = new int[N];

        for (int i = 0; i < N; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (rating.get(i) > rating.get(i - 1) && candies[i] <= candies[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            if (rating.get(i) > rating.get(i + 1) && candies[i] <= candies[i + 1]) candies[i] = candies[i + 1] + 1;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max += candies[i];
        }
        return max;
    }
}

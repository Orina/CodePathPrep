package week1.challenges;

import java.util.ArrayList;

/**
 * Interview Question 1 - Gold Stars
 * Alice is a teacher with a class of n children, each of whom has been assigned a numeric rating.
 * The classroom is seated in a circular arrangement, with Alice at the top of the circle.
 * She has a number of gold stars to give out based on each child's rating, but with the following conditions:
 *
 * Each child must receive at least one gold star
 * Any child with a higher rating than his or her immediate neighbor should get more stars than that neighbor
 * Assuming n >= 3, what is the minimum total number of stars Alice will need to give out?
 *
 * Write a program which takes as its input an int[] containing the ratings of each child, ordered by seating position, and returns an int value for the minimum total number of stars that Alice will need to give out.
 *
 * Hint: this problem can be solved with an algorithm that runs in O(n) time.
 *
 * For example:
 *
 * In a class of three children with ordered ratings of {1, 2, 2}, Alice will need to give out {1, 2, 1} stars accordingly, for a total number of 4 stars overall.
 *
 * NOTE: You should be able to implement this in pure Java using no imports, helper functions, or collections classes!
 *
 * Bonus 1
 *
 * In the above example, child #3 has the same rating as child #2 but gets fewer stars. To be equitable, the number of stars should be {1, 2, 2}, resulting in a total number of 5 stars overall.
 *
 * Modify the algorithm so that any child with fewer stars than an immediate neighbor with an equal rating gets at least as many stars as that neighbor.
 *
 * Created by Elmira Andreeva on 7/13/17.
 */
public class GoldStars {

    public int distributeGoldStars(ArrayList<Integer> rating) {
        int N = rating.size();
        if (N == 0) return 0;
        if (N == 1) return 1;

        int[] stars = new int[N];

        for (int i = 0; i < N; i++) {
            stars[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (rating.get(i) > rating.get(i - 1) && stars[i] <= stars[i - 1]) stars[i] = stars[i - 1] + 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            if (rating.get(i) > rating.get(i + 1) && stars[i] <= stars[i + 1]) stars[i] = stars[i + 1] + 1;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max += stars[i];
        }
        return max;
    }
}
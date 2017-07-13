package week1.arrays;

import java.util.ArrayList;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * <p>
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * <p>
 * Example :
 * <p>
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * <p>
 * Created by elmira on 7/11/17.
 */
public class MinStepsInInfiniteGrid {

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int N = X.size();
        if (N == 0) return 0;
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            count += Math.max(Math.abs(X.get(i) - X.get(i + 1)), Math.abs(Y.get(i) - Y.get(i + 1)));
        }
        return count;
    }
}

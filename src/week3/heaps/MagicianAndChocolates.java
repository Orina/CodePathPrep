package week3.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.
 *
 * Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.
 *
 * For example,
 *
 * K = 3
 * N = 2
 * A = 6 5
 *
 * Return: 14
 * At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
 * At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
 * At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
 * so, total number of chocolates eaten: 6 + 5 + 3 = 14
 *
 * Note: Return your answer modulo 10^9+7
 *
 * Created by Elmira Andreeva on 7/27/17.
 */
public class MagicianAndChocolates {

    /**
     * The solution to this problem can be found greedily. At any time t, the kid will always choose the bag with the maximum number of chocolates and consume all it’s chocolates.
     * So we need to maintain the current maximum size among all bags for every time t = 1, … , K and also updating the sizes of the bags.
     * This can be done using a max heap
     */
    public int nchoc(int K, ArrayList<Integer> B) {
        int kMod = (int) Math.pow(10, 9) + 7;
        long result = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        int N = B.size();

        for (int i = 0; i < N; i++) {
            maxHeap.add(B.get(i));
        }

        for (int i = 0; i < K && !maxHeap.isEmpty(); i++) {
            int top = maxHeap.poll();
            result = (result + top) % kMod;
            top = top / 2;
            if (top > 0) maxHeap.add(top);
        }

        return (int) result;
    }
}
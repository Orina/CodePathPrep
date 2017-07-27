package week2.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Elmira Andreeva on 7/24/17.
 */
public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int target) {
        int N = a.size();

        Collections.sort(a);

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (N == 0) return res;

        // keep only indices in the hashMap
        HashMap<Integer, List<Pair>> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = a.get(i) + a.get(j);
                if (!hashMap.containsKey(sum)) {
                    hashMap.put(sum, new ArrayList<Pair>());
                }
                hashMap.get(sum).add(new Pair(i, j));
            }
        }

        for (int i = 0; i < N; i++) {
            if (i > 0 && a.get(i).equals(a.get(i - 1))) continue;

            for (int j = i + 1; j < N; j++) {
                if (j > i + 1 && a.get(j).equals(a.get(j - 1))) continue;

                int sum = a.get(i) + a.get(j);
                int targetSum = target - sum;

                if (hashMap.containsKey(targetSum)) {
                    for (Pair p : hashMap.get(targetSum)) {

                        int k = p.i, l = p.j;
                        // k>j make sure that the second pair has bigger values than the first pair.
                        if (k > j) {
                            ArrayList<Integer> prevList = null;
                            if (res.size() > 0) prevList = res.get(res.size() - 1);

                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(a.get(i));
                            list.add(a.get(j));
                            list.add(a.get(k));
                            list.add(a.get(l));

                            boolean equals = true;
                            if (prevList != null) {
                                for (int ii = 0; ii < list.size(); ii++) {
                                    if (list.get(ii) != prevList.get(ii)) {
                                        equals = false;
                                        break;
                                    }
                                }
                            }
                            if (prevList == null || !equals) res.add(list);
                        }
                    }
                }
            }
        }

        return res;
    }

    public static class Pair {
        int i;
        int j;

        public Pair(int a, int b) {
            this.i = a;
            this.j = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum2(ArrayList<Integer> a, int target) {
        int N = a.size();

        Collections.sort(a);

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (N == 0) return res;

        for (int i = 0; i < N - 3; i++) {
            if (a.get(i) + a.get(i + 1) + a.get(i + 2) + a.get(i + 3) > target) break;

            if (a.get(i) + a.get(N - 1) + a.get(N - 2) + a.get(N - 3) < target) continue;

            //prevent duplicates in the result
            if (i > 0 && a.get(i) == a.get(i - 1)) continue;

            for (int j = i + 1; j < N - 2; j++) {
                if (j > i + 1 && a.get(j) == a.get(j - 1)) continue;
                int targetSum = target - (a.get(i) + a.get(j));

                int lo = j + 1;
                int hi = N - 1;

                while (lo < hi) {
                    int curSum = a.get(hi) + a.get(lo);
                    if (curSum == targetSum) {
                        ArrayList list = new ArrayList();
                        list.add(a.get(i));
                        list.add(a.get(j));
                        list.add(a.get(lo));
                        list.add(a.get(hi));
                        res.add(list);

                        while (lo < hi && a.get(lo) == a.get(lo + 1)) lo++;
                        while (lo < hi && a.get(hi - 1) == a.get(hi)) hi--;
                        lo++;
                        hi--;
                    } else if (curSum < targetSum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}

package company_boots.instacart;

import common.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * The FDA recommends that for a healthy, balanced diet, a person on average needs around 2,000 Kcal a day to maintain their weight. As a result, Instacart is set to release a new feature that will help customers control their daily intake of calories. Given a list of items in a customer's cart, it will show the items that can be consumed in one day such that their total caloric value is as close to 2000 as possible.
 *
 * Knowing the caloricValue of each bought item, return the 0-based indices of the items to be consumed in one day. If there is more than one option, return the lexicographically smallest one.
 *
 * Example
 *
 * For caloricValue = [400, 800, 400, 500, 350, 350], the output should be
 * dailyIntake(caloricValue) = [0, 2, 3, 4, 5].
 *
 * Caloric value of items [1, 3, 4, 5] and [0, 2, 3, 4, 5] both sum up to 2000 but since [0, 2, 3, 4, 5] is lexicographically smaller than [1, 3, 4, 5], the answer is [0, 2, 3, 4, 5].
 *
 * For caloricValue = [150, 900, 1000], the output should be
 * dailyIntake(caloricValue) = [0, 1, 2].
 *
 * The total sum of all items (i.e. 2050) is 50 Kcal larger than 2000, so the answer is [0, 1, 2].
 *
 * Input/Output
 *
 * [time limit] 3000ms (java)
 * [input] array.integer caloricValue
 *
 * Caloric value of each item in the cart. The total sum of all items is not greater than 104.
 *
 * Guaranteed constraints:
 * 1 ≤ caloricValue.length ≤ 30,
 * 2 ≤ caloricValue[i] ≤ 104.
 *
 * [output] array.integer
 *
 * The items to consume in a day.
 *
 * Created by Elmira Andreeva on 8/18/17.
 */
public class DailyIntake extends Base {

    static int[] dailyIntake(int[] caloricValue) {

        TreeMap<Integer, List<Integer>> hash = new TreeMap();
        dailyIntake(0, caloricValue, 2000, 0, new ArrayList<Integer>(), hash);

        if (hash.isEmpty()) return new int[]{};

        List<Integer> list = hash.get(hash.firstKey());
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    static void dailyIntake(int offset, int[] cal, int targetSum, int curSum, List<Integer> curList,
                            TreeMap<Integer, List<Integer>> hash) {

        if (hash.containsKey(0)) return;

        if (offset == cal.length || targetSum <= curSum) {
            int diff = Math.abs(curSum - targetSum);
            if (hash.containsKey(diff) || diff > 1500) return;

            if (hash.isEmpty()) hash.put(diff, new ArrayList<>(curList));
            else if (hash.firstKey() > diff) {
                //hash.remove(hash.firstEntry());
                hash.put(diff, new ArrayList<>(curList));
            }

            return;
        }
        for (int i = offset; i < cal.length && !hash.containsKey(0); i++) {
            curList.add(i);
            dailyIntake(i + 1, cal, targetSum, curSum + cal[i], curList, hash);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{400, 800, 400, 500, 350, 350};
        printArray(ar);

        println("\nresult");
        printArray(dailyIntake(ar));

    }
}

package prework.checkpoint4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Given an array, find the next greater element G[i] for every element A[i] in the array.
 * The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
 * More formally,
 *
 * G[i] for an element A[i] = an element A[j] such that
 * j is minimum possible AND
 * j > i AND
 * A[j] > A[i]
 * Elements for which no greater element exist, consider next greater element as -1.
 *
 * Example:
 * Input : A : [4, 5, 2, 10]
 * Output : [5, 10, 10, -1]
 *
 * Example 2:
 * Input : A : [3, 2, 1]
 * Output : [-1, -1, -1]
 *
 * Solution:
 * Main idea: traverse the array from right to left
 * and if we meet a number A[i] bigger than already seen numbers A[i+1], A[i+2], ..A[N-1],
 * than we are no longer needed for that numbers A[i+1], etc.
 *
 * 1. Create an empty stack
 * 2. Traverse initial array from right to left
 * 3. Remove from the stack elements which are smaller or equal to the current element
 * 4. Add top stack element to the result list (or -1 if stack is empty)
 * 5. Push to the stack current element.
 * 6. Reverse the result list (as we go backward)
 *
 * time: O(N), as we push/pop one element in stack only once
 * space: O(N)
 *
 * Created by Elmira Andreeva on 6/28/2017.
 */
public class NextGreater {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList();
        int N = a.size();

        Stack<Integer> stack = new Stack();
        for (int i = N - 1; i >= 0; i--) {
            //remove from the stack previous values which are lower or equal to current value
            while (!stack.isEmpty() && stack.peek() <= a.get(i)) stack.pop();

            //add top element to the result list
            result.add(stack.isEmpty() ? -1 : stack.peek());

            //add current value to the stack
            stack.push(a.get(i));
        }

        Collections.reverse(result);
        return result;
    }
}

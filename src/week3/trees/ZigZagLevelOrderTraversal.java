package week3.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Example :
 * Given binary tree
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return
 *
 * [
 * [3],
 * [20, 9],
 * [15, 7]
 * ]
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class ZigZagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        TreeNode separator = new TreeNode(0);
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.addLast(a);
        queue.addLast(separator);

        ArrayList<Integer> curList = new ArrayList();
        boolean left = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();

            if (node == separator) {
                if (!left) Collections.reverse(curList);
                result.add(curList);

                if (queue.isEmpty()) break;

                left = !left;
                curList = new ArrayList();
                queue.addLast(separator);
            } else {
                curList.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return result;
    }
}
package week3.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 *
 * Example :
 * Given binary tree
 *
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 *
 * Using recursion is not allowed.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        if (a == null) return null;
        ArrayList<Integer> result = new ArrayList();

        Deque<TreeNode> stack = new ArrayDeque();
        stack.addFirst(a);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            result.add(node.val);

            if (node.right != null) stack.addFirst(node.right);
            if (node.left != null) stack.addFirst(node.left);

        }
        return result;
    }
}

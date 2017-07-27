package week3.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 *
 * Example :
 * Given binary tree
 *
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 *
 * Using recursion is not allowed.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class InorderTraversal {

    /**
     * Maintain  a reference to the current node - node
     * Maintain a stack of nodes - stack
     * Do in a cycle while current node is not null or stack is not empty:
     * while (node != null || !stack.isEmpty())
     * If current node is not null, add it to the stack and go to the left subtree
     * Else (if stack is not empty), pop the node from the stack, visit it, and go to the right subtree.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> result = new ArrayList();

        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
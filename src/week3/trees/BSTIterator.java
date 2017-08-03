package week3.trees;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Try to optimize the additional space complexity apart from the amortized time complexity.
 *
 * https://www.interviewbit.com/problems/bst-iterator/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack();
        putLeftNodesToStack(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        putLeftNodesToStack(node.right);
        return node.val;
    }

    private void putLeftNodesToStack(TreeNode node) {
        if (node == null) return;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

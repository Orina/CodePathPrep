package week3.challenges;

import week3.trees.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Example :
 *
 * Input :
 * 1
 * /  \
 * 2    3
 *
 * Output : 0 or False
 *
 *
 * Input :
 * 2
 * / \
 * 1   3
 *
 * Output : 1 or True
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class ValidBinarySearchTree {

    public int isValidBST(TreeNode a) {
        return isValidBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBST(TreeNode node, int leftValue, int rightValue) {
        if (node == null) return true;
        if (node.val < leftValue || node.val > rightValue) return false;
        return isValidBST(node.left, leftValue, node.val - 1)
                && isValidBST(node.right, node.val + 1, rightValue);
    }
}

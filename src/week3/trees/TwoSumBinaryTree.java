package week3.trees;

import java.util.Stack;

/**
 * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 * Notes
 * - Your solution should run in linear time and not take memory more than O(height of T).
 * - Assume all values in BST are distinct.
 *
 * Example :
 *
 * Input 1:
 *
 * T :       10
 * / \
 * 9   20
 *
 * K = 19
 *
 * Return: 1
 *
 * Input 2:
 *
 * T:        10
 * / \
 * 9   20
 *
 * K = 40
 *
 * Return: 0
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class TwoSumBinaryTree {

    /**
     *  Maintain 2 stacks - leftStack and rightStack
     *  leftStack - for inorder traversal in increasing order
     *  rightStack - inorder traversal in decreasing order
     *
     *  push left most nodes to leftStack
     *  push  rightmost nodes to rightStack
     *
     *  let left = pop the top node from leftStack
     *      right = pop the top node from rightStack
     *
     *  while (left node is not equal to right node){
     *      calculate the sum of left and right nodes
     *      if (sum==target) we are done, return true
     *      else if (sum less than target) -> we need to go to the next node from left (in-order traversal):
     *          - push to stack the left nodes from left.right
     *          - left node = pop the top from leftStack
     *      else if (sum is larger than target) -> we need to go to the previous node from right node:
     *          - push to stack the right nodes from right.left
     *          - right node = pop the top from rightStack
     *  }
     */
    public int t2Sum(TreeNode root, int target) {
        if (root == null) return 0;

        Stack<TreeNode> leftStack = new Stack();
        Stack<TreeNode> rightStack = new Stack();

        pushLeftSubtree(root, leftStack);
        pushRightSubtree(root, rightStack);

        TreeNode left = leftStack.pop();
        TreeNode right = rightStack.pop();

        while (left != right && left != null && right != null) {
            int sum = left.val + right.val;
            if (sum == target) return 1;
            else if (sum < target) {
                pushLeftSubtree(left.right, leftStack);
                left = leftStack.pop();
            } else {
                pushRightSubtree(right.left, rightStack);
                right = rightStack.pop();
            }
        }
        return 0;
    }

    private void pushLeftSubtree(TreeNode left, Stack<TreeNode> leftStack) {
        while (left != null) {
            leftStack.push(left);
            left = left.left;
        }
    }

    private void pushRightSubtree(TreeNode right, Stack<TreeNode> rightStack) {
        while (right != null) {
            rightStack.push(right);
            right = right.right;
        }
    }
}
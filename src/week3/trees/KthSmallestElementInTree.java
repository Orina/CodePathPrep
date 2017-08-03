package week3.trees;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 * Example :
 *
 * Input :
 * 2
 * / \
 * 1   3
 *
 * and k = 2
 *
 * Return : 2
 *
 * As 2 is the second smallest element in the tree.
 * NOTE : You may assume 1 <= k <= Total number of nodes in BST
 *
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class KthSmallestElementInTree {

    /**
     *  1. count the size of left subtree
     *  2. if leftSize +1 == k - we are done, return the value of current node
     *  3. else if leftSize >=k - explore the left subtree
     *  4  else (k > leftSubtree+1) - explore the right subtree AND decrement the k = k - (leftSubtree+1)
     */
    public int kthsmallest(TreeNode root, int k) {
        if (root == null) return -1;

        TreeNode cur = root;
        while (cur != null) {
            int leftSize = size(cur.left);
            if (leftSize + 1 == k) return cur.val;
            else if (leftSize >= k) {
                cur = cur.left;
            } else {
                cur = cur.right;
                k -= (leftSize + 1);
            }
        }
        return -1;
    }

    private int size(TreeNode node) {
        if (node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }
}

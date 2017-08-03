package week3.trees;

/**
 * Given a binary tree, invert the binary tree and return it.
 * Look at the example for more details.
 *
 * Example :
 * Given binary tree
 *
 * 1
 * /   \
 * 2     3
 * / \   / \
 * 4   5 6   7
 * invert and return
 *
 * 1
 * /   \
 * 3     2
 * / \   / \
 * 7   6 5   4
 *
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class InvertBinaryTree {

    /**
     * Use a post-order traversal for inverting nodes
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTreeNode(root);
        return root;
    }

    private void invertTreeNode(TreeNode node) {
        if (node == null) return;

        invertTreeNode(node.left);
        invertTreeNode(node.right);

        if (isLeaf(node)) return;

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

package week3.trees;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 *
 * 1       1
 * / \     / \
 * 2   3   2   3
 *
 * Output :
 * 1 or True
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode a, TreeNode b) {
        return isSameTree2(a, b) ? 1 : 0;
    }

    public boolean isSameTree2(TreeNode a, TreeNode b) {
        if (a == null) return b == null;
        else if (b == null) return false;
        else if (a.val != b.val) return false;
        return isSameTree2(a.left, b.left) && isSameTree2(a.right, b.right);
    }
}
package week3.trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Example :
 *
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * The above binary tree is symmetric.
 * But the following is not:
 *
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode a) {
        if (a == null) return 1;
        return isSymmetric(a.left, a.right) ? 1 : 0;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        else if (right == null) return false;
        else if (left.val != right.val) return false;
        else return isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
    }
}

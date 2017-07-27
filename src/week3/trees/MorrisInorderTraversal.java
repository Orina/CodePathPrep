package week3.trees;

import java.util.ArrayList;

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
public class MorrisInorderTraversal {

    /**
     * Do in a cycle while current is not null (cur != null)
     * If current does not have left child (cur.left == null):
     *  Visit current node
     *  Go to the right, i.e. cur = cur.right
     * Else if current has left child (cur.left != null):
     *      Find predecessor of current: the rightmost node of current left subtree (condition pre.right != cur  to avoid cycling)
     *      If predecessor right subtree is null (pre.right == null): (this means that we have not explored that node yet)
     *          Assign predecessor right subtree to current:  pre.right = cur
     *          Go to left: cur = cur.left
     *      Else if predecessor right subtree is not null (pre.right != null): (this means that we have already explored that node)
     *          Visit current node
     *          Nullify the predecessor right subtree:  pre.right = null (i.e. removed previously created right link)
     *          Go to right: cur = cur.right
     */
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        if (a == null) return null;
        ArrayList<Integer> result = new ArrayList();

        TreeNode cur = a;
        TreeNode pre = null;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}

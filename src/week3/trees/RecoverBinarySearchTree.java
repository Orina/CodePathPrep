package week3.trees;

import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Tell us the 2 values swapping which the tree will be restored.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * Example :
 *
 *
 * Input :
 * 1
 * / \
 * 2   3
 *
 * Output :
 * [1, 2]
 *
 * Explanation : Swapping 1 and 2 will change the BST to be
 * 2
 * / \
 * 1   3
 * which is a valid BST
 *
 * https://www.interviewbit.com/problems/recover-binary-search-tree/
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class RecoverBinarySearchTree {

    /**
     *  For in-order traversal use Morris Inorder traversal
     *
     *  Basic idea:
     *  1. Find max node:
     *          find the node for which the  last seen node is bigger than current
     *          min node = current node
     *  2. continue traverse the tree and find the min possible node
     *
     *  Result: min and max nodes (if not null) are swapped
     */
    public ArrayList<Integer> recoverTree(TreeNode a) {
        if (a == null) return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();

        TreeNode cur = a, lastSeen = null, maxNode = null, minNode = null;

        while (cur != null) {

            if (cur.left == null) {
                //visit node: cur
                if (maxNode == null && lastSeen != null && lastSeen.val > cur.val) {
                    maxNode = lastSeen;
                    minNode = cur;
                }
                if (minNode != null && cur.val < minNode.val) minNode = cur;

                lastSeen = cur;
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    //visit node: cur
                    if (maxNode == null && lastSeen != null && lastSeen.val > cur.val) {
                        maxNode = lastSeen;
                        minNode = cur;
                    }
                    if (minNode != null && cur.val < minNode.val) minNode = cur;

                    //restore the tree
                    lastSeen = cur;
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        if (minNode != null) {
            result.add(minNode.val);
            result.add(maxNode.val);
        }
        return result;
    }
}

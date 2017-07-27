package week3.trees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input :
 * Preorder : [1, 2, 3]
 * Inorder  : [2, 1, 3]
 *
 * Return :
 * 1
 * / \
 * 2   3
 *
 *
 * Created by Elmira Andreeva on 7/26/17.
 */
public class ConstructBinaryTreeFromInorderAndPreorder {

    /**
     * Root of every subtree: preorder[lo], where lo  - the lowest index of preorder traversal array
     * Hash all inorder value-index for speed up the inorder index look up: inorderHash
     * Find index in preorder traversal which is greater than rootInorderIndex: i - this index indicate the border of left|right subtrees.
     * Left subtree indexes in preorder traversal:  preorder[lo+1]...preorder[i-1]
     * Right subtree indexes in preorder traversal:  preorder[i]...preorder[hi]
     */

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preorder == null || preorder.size() == 0 ||
                inorder == null || inorder.size() == 0 || preorder.size() != inorder.size()) return null;
        int N = preorder.size();

        HashMap<Integer, Integer> inHash = new HashMap();

        for (int i = 0; i < N; i++) {
            inHash.put(inorder.get(i), i);
        }
        return reconstruct(0, N - 1, preorder, inHash);
    }

    private TreeNode reconstruct(int lo, int hi, ArrayList<Integer> preorder,
                                 HashMap<Integer, Integer> inHash) {
        if (lo > hi) return null;

        int rootValue = preorder.get(lo);
        TreeNode node = new TreeNode(rootValue);

        int rootInorderIdx = inHash.get(rootValue);
        int preorderIndex = lo + 1;

        while (preorderIndex <= hi && inHash.get(preorder.get(preorderIndex)) < rootInorderIdx) {
            preorderIndex++;
        }

        node.left = reconstruct(lo + 1, preorderIndex - 1, preorder, inHash);
        node.right = reconstruct(preorderIndex, hi, preorder, inHash);

        return node;
    }
}
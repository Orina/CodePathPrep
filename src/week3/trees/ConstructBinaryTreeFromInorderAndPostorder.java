package week3.trees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input :
 * Inorder : [2, 1, 3]
 * Postorder : [2, 3, 1]
 *
 * Return :
 * 1
 * / \
 * 2   3
 *
 * Created by Elmira Andreeva on 7/26/17.
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

    /**
     * Root of every subtree: postorder[hi], where hi  - the highest index of postorder traversal array
     * Hash all inorder value-index for speed up the inorder index look up: inorderHash
     * Find index in postorder traversal which is greater than rootInorderIndex: i - this index indicate the border of left|right subtrees.
     * Left subtree indexes in postorder traversal:  postorder[lo]...postorder[i-1]
     * Right subtree indexes in postorder traversal:  postorder[i]...postorder[hi-1]
     */
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (postorder == null || postorder.size() == 0 ||
                inorder == null || inorder.size() == 0 || postorder.size() != inorder.size()) return null;
        int N = postorder.size();

        HashMap<Integer, Integer> inHash = new HashMap();

        for (int i = 0; i < N; i++) {
            inHash.put(inorder.get(i), i);
        }
        return reconstruct(0, N - 1, postorder, inorder, inHash);
    }

    private TreeNode reconstruct(int lo, int hi, ArrayList<Integer> postorder, ArrayList<Integer> inorder,
                                 HashMap<Integer, Integer> inHash) {
        if (lo > hi) return null;

        int rootValue = postorder.get(hi);
        TreeNode node = new TreeNode(rootValue);

        int rootInorderIndex = inHash.get(rootValue);
        int postIndex = lo;

        while (postIndex < hi && inHash.get(postorder.get(postIndex)) < rootInorderIndex) {
            postIndex++;
        }

        node.left = reconstruct(lo, postIndex - 1, postorder, inorder, inHash);
        node.right = reconstruct(postIndex, hi - 1, postorder, inorder, inHash);

        return node;
    }
}
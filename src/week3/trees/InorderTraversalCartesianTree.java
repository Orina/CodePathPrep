package week3.trees;

import java.util.ArrayList;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 *
 * Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 * Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input : [1 2 3]
 *
 * Return :
 * 3
 * /
 * 2
 * /
 * 1
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class InorderTraversalCartesianTree {

    /**
     *  start build a tree from ar[0..N-1]:
     *
     *  1) the max element in between low and high bounds is a root
     *  2) left subtree is placed the array from low and maxIdx-1
     *  3) right subtree is placed between maxIdx+1..hi indices
     *
     *  So construct a current node with max value, then recursively construct the left and right subtrees.
     *  Return the node.
     *
     */
    public TreeNode buildTree(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return null;
        int N = a.size();
        return buildTree(0, N - 1, a);
    }

    private TreeNode buildTree(int lo, int hi, ArrayList<Integer> a) {
        if (lo > hi) return null;

        int maxIndex = maxElement(lo, hi, a);
        TreeNode node = new TreeNode(a.get(maxIndex));

        node.left = buildTree(lo, maxIndex - 1, a);
        node.right = buildTree(maxIndex + 1, hi, a);

        return node;
    }

    private int maxElement(int lo, int hi, ArrayList<Integer> array) {
        int maxIndex = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (array.get(i) > array.get(maxIndex)) maxIndex = i;
        }
        return maxIndex;
    }
}

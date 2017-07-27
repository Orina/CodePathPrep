package week3.trees;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : [1, 2, 3]
 A height balanced BST  :

   2
 /   \
 1     3


 * Created by Elmira Andreeva on 7/26/17.
 */
public class SortedArrayToBalancedBST {

    /**
     *  root is a middle element
     *  left subtree construct recursively - from low to middle -1
     *  right subtree construct recursively - from middle +1 to high
     */
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if(a==null || a.size()==0) return null;
        return process(0, a.size()-1, a);
    }

    private TreeNode process(int lo, int hi, List<Integer> a){
        if(lo > hi) return null;

        int mid = lo + (hi-lo)/2;
        TreeNode node = new TreeNode(a.get(mid));

        node.left = process(lo, mid-1, a);
        node.right = process(mid+1, hi, a);

        return node;
    }
}

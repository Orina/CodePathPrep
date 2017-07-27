package week3.trees;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * Note that the left child of all nodes should be NULL.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     *  1) If current node's left subtree is null - go to the right, nothing to do
     *  2) otherwise do following:
     *     2.1. find the rightmost node of current.left - pred
     *     2.2. copy current node's right subtree to pred's right subtree
     *     2.3. copy left subtree of current node to it's right subtree
     *     2.4. nullify current node's left subtree
     *     2.5 go left
     */
    public TreeNode flatten(TreeNode root) {
        if(root==null) return root;

        TreeNode newHead = new TreeNode(0);
        TreeNode cur = root;
        newHead.right = cur;

        while(cur!=null){
            if(cur.left==null){
                cur = cur.right;
            }
            else{
                TreeNode pred = cur.left;
                while(pred.right!=null){
                    pred = pred.right;
                }

                TreeNode left = cur.left;
                pred.right = cur.right;

                cur.left=null;
                cur.right = left;
                cur = left;
            }
        }

        return newHead.right;
    }
}

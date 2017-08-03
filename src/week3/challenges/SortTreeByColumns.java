package week3.challenges;

import week3.trees.TreeNode;
import week3.trees.VerticalOrderTraversalOfBinaryTree;

import java.util.*;

/** Interview Question 2 - Sort tree by columns
 Write an algorithm which takes as its input a binary tree of chars and outputs a singly-linked list of its values ordered by column first and row second.

 The root node is in row 0
 Any node that is a child of another node will be in the row immediately following that of its parent
 Any node that is a left child will be in the column immediately preceding that of its parent
 Any node that is a right child will be in the column immediately following that of its parent
 Any node that is a left child with a parent that is a right child will be in the same column as its grandparent
 Any node that is a right child with a parent that is a left child will be in the same column as its grandparent
 If two nodes share the same row and column, the node whose parent is a left child comes first
 Example:

 Input tree:
 5
 / \
 4   8
 /   / \
 9   6   4
 / \     / \
 7   2   5   1
 In the above tree, there are 7 columns, three of which have two nodes: [4, 2], [5, 6], and [8,5]. Therefore the algorithm would return a linked list with the following characters: 7→9→4→2→5→6→8→5→4→1.

 * Created by Elmira Andreeva on 8/2/17.
 */
public class SortTreeByColumns {

    /**
     * maintain a hash-table, where key = vertical level, values - list of nodes for that vertical level
     * - when explore the left subtree: vertical level is current vertical level - 1
     * - when explore the right subtree: vertical level is current vertical level + 1
     *
     * Do a level order traversal (BFS!!)
     */
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap();

        traverse(root, hashMap);

        ArrayList<ArrayList<Integer>> res = new ArrayList();
        List<Integer> keys = new ArrayList(hashMap.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            res.add(hashMap.get(key));
        }
        return res;
    }

    void traverse(TreeNode root, Map<Integer, ArrayList<Integer>> hashMap) {
        Deque<VerticalOrderTraversalOfBinaryTree.TreeNodeWrap> queue = new ArrayDeque();
        queue.add(new VerticalOrderTraversalOfBinaryTree.TreeNodeWrap(0, root));

        while (!queue.isEmpty()) {
            VerticalOrderTraversalOfBinaryTree.TreeNodeWrap wr = queue.poll();

            if (!hashMap.containsKey(wr.level)) {
                hashMap.put(wr.level, new ArrayList<Integer>());
            }
            hashMap.get(wr.level).add(wr.node.val);

            if (wr.node.left != null) queue.add(new VerticalOrderTraversalOfBinaryTree.TreeNodeWrap(wr.level - 1, wr.node.left));
            if (wr.node.right != null) queue.add(new VerticalOrderTraversalOfBinaryTree.TreeNodeWrap(wr.level + 1, wr.node.right));
        }
    }

    public static class TreeNodeWrap {
        public int level;
        public TreeNode node;

        public TreeNodeWrap(int l, TreeNode node) {
            this.level = l;
            this.node = node;
        }
    }
}

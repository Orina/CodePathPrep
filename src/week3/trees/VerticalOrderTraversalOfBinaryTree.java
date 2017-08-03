package week3.trees;

import java.util.*;

/**
 * Given a binary tree, print a vertical order traversal of it.
 *
 * Example :
 * Given binary tree:
 *
 * 6
 * /   \
 * 3     7
 * / \     \
 * 2   5     9
 * returns
 *
 * [
 * [2],
 * [3],
 * [6 5],
 * [7],
 * [9]
 * ]
 *
 *
 * Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class VerticalOrderTraversalOfBinaryTree {

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
        Deque<TreeNodeWrap> queue = new ArrayDeque();
        queue.add(new TreeNodeWrap(0, root));

        while (!queue.isEmpty()) {
            TreeNodeWrap wr = queue.poll();

            if (!hashMap.containsKey(wr.level)) {
                hashMap.put(wr.level, new ArrayList<Integer>());
            }
            hashMap.get(wr.level).add(wr.node.val);

            if (wr.node.left != null) queue.add(new TreeNodeWrap(wr.level - 1, wr.node.left));
            if (wr.node.right != null) queue.add(new TreeNodeWrap(wr.level + 1, wr.node.right));
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

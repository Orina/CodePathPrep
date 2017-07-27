package week3.trees;

/**
 * Given a binary tree
 *
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 * You may only use constant extra space.
 * Example :
 *
 * Given the following binary tree,
 *
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 *
 * Note 1: that using recursion has memory overhead and does not qualify for constant space.
 * Note 2: The tree need not be a perfect binary tree.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class PopulateNextRightPointersTree {

    /**
     * 1. for a current node populate the lower level nodes in the following way:
     * 1.1. current left node point its next to current right node
     * 1.2. if curr.next is not null, set current right node, next pointer to current next left node.
     * 1.3. go to the next
     * 2. go to the left
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode next = getNextLevelNode(cur);
            if (next != null) {
                processNextLevel(cur, next);
            }
            cur = next;
        }
    }

    private void processNextLevel(TreeLinkNode cur, TreeLinkNode next) {
        while (cur != null) {
            //skip all leaves
            if (cur.left == null && cur.right == null) {
                cur = cur.next;
                continue;
            }
            TreeLinkNode node = null;
            if (cur.left != null && cur.left != next) {
                node = cur.left;
                next.next = node;
                next = node;
            }
            if (cur.right != null && cur.right != next) {
                node = cur.right;
                next.next = node;
                next = node;
            }
            cur = cur.next;
        }
    }

    private TreeLinkNode getNextLevelNode(TreeLinkNode cur) {
        while (cur != null) {
            if (cur.left == null && cur.right == null) {
                cur = cur.next;
                continue;
            }
            return cur.left == null ? cur.right : cur.left;
        }
        return null;
    }
}

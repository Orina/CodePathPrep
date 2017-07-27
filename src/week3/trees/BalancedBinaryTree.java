package week3.trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 * 1
 * / \
 * 2   3
 *
 * Return : True or 1
 *
 * Input 2 :
 * 3
 * /
 * 2
 * /
 * 1
 *
 * Return : False or 0
 * Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 * Difference = 2 > 1.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class BalancedBinaryTree {

    public int isBalanced(TreeNode a) {
        if (a == null) return 1;
        return isBalancedNode(a).balanced ? 1 : 0;
    }

    private NodeStatus isBalancedNode(TreeNode node) {
        if (node == null) return new NodeStatus(true, 0);

        NodeStatus leftStatus = isBalancedNode(node.left);
        if (!leftStatus.balanced) return leftStatus;

        NodeStatus rightStatus = isBalancedNode(node.right);
        if (!rightStatus.balanced) return rightStatus;

        int height = Math.max(leftStatus.height, rightStatus.height) + 1;
        return new NodeStatus(Math.abs(leftStatus.height - rightStatus.height) <= 1, height);
    }

    class NodeStatus {
        boolean balanced;
        int height;

        NodeStatus(boolean b, int h) {
            this.balanced = b;
            this.height = h;
        }
    }
}

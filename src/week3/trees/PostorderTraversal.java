package week3.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 *
 * Example :
 *
 * Given binary tree
 *
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 *
 * Using recursion is not allowed.
 *
 * Created by Elmira Andreeva on 7/25/17.
 */
public class PostorderTraversal {

    /**
     *  Keep the references to a current and last visited nodes
     *  Maintain a stack
     *  while current node is defined or stack is not empty
     *      1) if current node is not null, add it to a stack and go left
     *      2) peek a top element from the stack
     *         2.1) if peek element does not have right subtree OR right node of peek is last visited node:
     *              - visit peek node
     *              - remove it from the stack
     *              - update last visited node to the peek node
     *         2.2) else current node = peek right's node
     */
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        if(a==null) return null;
        ArrayList<Integer> result = new ArrayList();

        TreeNode cur = a, lastVisited = null;
        Deque<TreeNode> stack = new ArrayDeque();

        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.addFirst(cur);
                cur = cur.left;
            }
            else if(!stack.isEmpty()){
                TreeNode top = stack.peekFirst();
                if(top.right == null || top.right==lastVisited){
                    result.add(top.val);
                    lastVisited = stack.pollFirst();
                }
                else{
                    cur = top.right;
                }
            }
        }
        return result;
    }
}

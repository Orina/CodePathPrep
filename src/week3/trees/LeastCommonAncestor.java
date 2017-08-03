package week3.trees;

/**
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 Example :


 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2_     0        8
 /   \
 7    4
 For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
 Please note that LCA for nodes 5 and 4 is 5.

 You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 There are no duplicate values.
 You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.

 * Created by Elmira Andreeva on 8/2/17.
 */
public class LeastCommonAncestor {

    public int lca(TreeNode a, int val1, int val2) {
        Status status =  getLCA(a, val1, val2);
        return status.lca ==null? -1: status.lca.val;
    }

    private Status getLCA(TreeNode node, int val1, int val2){
        if(node==null) return new Status(0, null);

        Status left = getLCA(node.left, val1, val2);
        if(left.count == 2) return left;

        Status right = getLCA(node.right, val1, val2);
        if(right.count==2) return right;

        if(left.count == 1 && right.count == 1){
            return new Status(2, node);
        }

        boolean equal = (node.val== val1 || node.val==val2);
        Status status = new Status(0, null);

        if(left.count == 0 && right.count == 0){
            if(equal){
                if(val1==val2){
                    status.count = 2;
                    status.lca = node;
                }
                else {
                    status.count = 1;
                }
            }
        }
        else{
            if(equal){
                status.count = 2;
                status.lca = node;
            }
            else{
                status.count = 1;
            }
        }
        return status;
    }

    class Status{
        int count =0;
        TreeNode lca;

        public Status(int count, TreeNode lca){
            this.count = 0;
            this.lca = lca;
        }
    }
}

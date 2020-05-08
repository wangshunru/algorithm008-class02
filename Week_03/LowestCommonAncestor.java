//二叉树的最近公共祖先
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //private TreeNode res ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
        
        
        /*res = null;
        isContains(root,p,q);
        return res;*/
    }
    /*private boolean isContains(TreeNode x,TreeNode p,TreeNode q){
        if(x == null) return false;
        boolean leftCon = isContains(x.left,p,q);
        boolean rightCon = isContains(x.right,p,q);
        if((x == p && leftCon) || (x == p && rightCon) || (x == q && leftCon) || (x ==q && rightCon) || (leftCon && rightCon)){
            res = x;
            return true;
        }
        return (x == p) || (x == q) || leftCon || rightCon;
    }*/
}

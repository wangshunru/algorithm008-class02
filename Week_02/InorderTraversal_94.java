/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root,List<Integer> res){
        if (root != null){
            if (root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null){
                helper(root.right,res);
            }
        }
    }
}

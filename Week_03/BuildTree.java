//从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorder_map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) inorder_map.put(inorder[i], i);

        return helper(preorder, 0, n, inorder, 0, n, inorder_map);


    }

    private TreeNode helper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end, Map<Integer, Integer> inorder_map) {
        if (pre_start == pre_end) return null;
        TreeNode root = new TreeNode(preorder[pre_start]);
        int loc = inorder_map.get(preorder[pre_start]);
        root.left = helper(preorder, pre_start + 1, pre_start + 1 + loc - in_start, inorder, in_start, loc, inorder_map);
        root.right = helper(preorder, pre_start + 1 + loc - in_start, pre_end, inorder, loc + 1, in_end, inorder_map);
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int helper(TreeNode root, int limit, int sum){
        if(root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right == null) return sum + root.val;
        int left = helper(root.left, limit, sum + root.val);
        int right = helper(root.right, limit, sum + root.val);
        if(left < limit) root.left = null;
        if(right < limit) root.right = null;
        return Math.max(left, right);
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(helper(root, limit, 0) < limit) return null;
        return root;
    }
}

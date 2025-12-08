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
    public int dfs(TreeNode root, int[] height) {
        if(root.left == null && root.right == null){
            height[0] = Math.max(height[0], root.val);
            return root.val;
        }
        int lh = 0, rh = 0;
        if(root.left != null) {lh = Math.max(0,dfs(root.left, height));};
        if(root.right != null) {rh = Math.max(0,dfs(root.right, height));};

        height[0] = Math.max(height[0], lh + rh + root.val);
        return Math.max(lh,rh) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int[] height = {Integer.MIN_VALUE};
        height[0] = Math.max(dfs(root, height),height[0]);
        return height[0];
    }
}

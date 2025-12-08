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
    public void dfs(TreeNode root, int[] height, int curr) {
        if(root == null){
            height[0] = Math.max(height[0],curr);
            return;
        }
        dfs(root.left, height, curr+1);
        dfs(root.right, height, curr+1);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int[] height = new int[]{0};
        dfs(root, height, 0);
        return height[0];
    }
}

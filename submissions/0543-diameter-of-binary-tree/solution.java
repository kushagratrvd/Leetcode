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
        if(root == null){
            return 0;
        }
        int lh = dfs(root.left,height);
        int rh = dfs(root.right,height);
        height[0] = Math.max(lh+rh,height[0]);
        return Math.max(lh,rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] height = new int[]{0};
        int lh = dfs(root.left,height);
        int rh = dfs(root.right,height);
        height[0] = Math.max(lh+rh,height[0]);
        return height[0];
    }
}

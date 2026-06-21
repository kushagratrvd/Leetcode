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
    public int helper(TreeNode node, int[] max){
        if(node == null) return 0;
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        max[0] = Math.max(max[0], node.val);
        max[0] = Math.max(max[0], node.val + left);
        max[0] = Math.max(max[0], node.val + right);
        max[0] = Math.max(max[0], node.val + left + right);
        return Math.max(node.val, node.val + Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int max[] = new int[]{-1001};
        helper(root, max);
        return max[0];
    }
}

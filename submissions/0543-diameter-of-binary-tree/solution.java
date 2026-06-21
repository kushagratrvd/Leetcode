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
        int left = 1 + helper(node.left, max);
        int right = 1 + helper(node.right, max); 
        max[0] = Math.max(max[0], left+right-1);
        return Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[]{0};
        helper(root, max);
        return max[0]-1;
    }
}

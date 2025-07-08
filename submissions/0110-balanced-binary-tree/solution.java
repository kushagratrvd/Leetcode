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
    public boolean isBalanced(TreeNode root) {
        int ans = recursion(root);
        if(ans == -1) return false;
        return true;
    }

    public int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = recursion(node.left);
        if(leftDepth == -1) return -1;
        int rightDepth = recursion(node.right);
        if(rightDepth == -1) return -1;

        if(Math.abs(leftDepth-rightDepth) > 1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

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
    public int maxPathSum(TreeNode root) {
        int[] pathSum = {-2160};
        recursion(root, pathSum);
        return pathSum[0];
    }

    public int recursion(TreeNode root, int[] pathSum){
        if(root == null) return 0;

        int lh = Math.max(0, recursion(root.left, pathSum));
        int rh = Math.max(0,recursion(root.right, pathSum));
        pathSum[0] = Math.max(pathSum[0], root.val + lh + rh);
        return root.val + Math.max(lh,rh);
    }
}

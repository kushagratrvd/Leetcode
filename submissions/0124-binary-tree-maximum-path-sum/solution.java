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
    public int sum(TreeNode root, int[] max){
        if(root == null) return 0;
        int left = sum(root.left, max);
        int right = sum(root.right, max);
        if(root.left != null) max[0] = Math.max(max[0], left);
        if(root.right != null) max[0] = Math.max(max[0], right);
        max[0] = Math.max(max[0], root.val);
        max[0] = Math.max(max[0], left + right + root.val);
        if(left < 0 && right < 0){
            max[0] = Math.max(max[0], root.val);
            return root.val;
        }
        if(left > right){
            max[0] = Math.max(max[0], left + root.val);
            return left + root.val;
        }
        else{
            max[0] = Math.max(max[0], right + root.val);
            return right + root.val;
        }
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        sum(root, max);
        return max[0];
    }
}

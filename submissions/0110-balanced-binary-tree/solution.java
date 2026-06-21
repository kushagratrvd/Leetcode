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
        if(root == null) return true;
        //boolean[] flag = new boolean[]{false};
        if(helper(root) > 5000) return false;
        return true;
    }
    public int helper(TreeNode node){
        if(node == null) return 0;

        int left = 1 + helper(node.left);
        if(left >= 5000) return 5001;
        int right = 1 + helper(node.right);
        if(right >= 5000) return 5001;
        //System.out.println(Math.abs(left-right));
        if(Math.abs(left-right) > 1){
            //flag[0] = true;
            return 5001;
        }
        return Math.max(left,right);
    }
}

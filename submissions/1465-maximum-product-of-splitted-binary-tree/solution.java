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
    public int postOrder(TreeNode root){
        if(root == null) return 0;
        root.val += postOrder(root.left) + postOrder(root.right);
        return root.val;
    }
    public int maxProduct(TreeNode root) {
        int total = postOrder(root);
        long max = Long.MIN_VALUE;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            max = Math.max(max, (long)(total-curr.val) * curr.val);
            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null){
                q.offer(curr.right);
            }
        }
        return (int)(max % 1000000007);
    }
}

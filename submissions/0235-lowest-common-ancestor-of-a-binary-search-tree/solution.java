/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[1];
        helper(root,p,q,ans);
        return ans[0];
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q, TreeNode[] ans){
        if(root == null) return false;
        boolean Left = helper(root.left,p,q,ans);
        boolean Right = helper(root.right,p,q,ans);
        if(Left == true && Right == true){
            ans[0] = root;
            return true;
        }
        if(Left == true || Right == true){
            if(root.val == p.val || root.val == q.val){
                ans[0] = root;
            }
                return true;
            
        }
        if(root == p || root == q) return true;
        return false;
    }
}

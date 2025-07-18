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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        LeafNode(root ,ans ,"");
        return ans;
    }
    public void LeafNode(TreeNode node, List<String> ans, String temp){
        if(node == null) return;
        temp += node.val;

        if(node.left == null && node.right == null){
            ans.add(temp);
        }
        else{
            temp += "->";
            LeafNode(node.left,ans,temp);
            LeafNode(node.right,ans,temp);
        }
        
        
    }
}

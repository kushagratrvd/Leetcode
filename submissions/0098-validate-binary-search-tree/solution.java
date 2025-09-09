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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(Inorder(root,arr)) return false;
        return true;
    }
    public boolean Inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return false;
        if(Inorder(root.left,arr)) return true;
        if(arr.size() > 0 && arr.get(arr.size()-1) >= root.val) return true;
        arr.add(root.val);
        
        if(Inorder(root.right,arr)) return true;
        return false;
    }
}

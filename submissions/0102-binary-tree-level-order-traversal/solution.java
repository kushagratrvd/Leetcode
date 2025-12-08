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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> children = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                children.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            } 
            if(!children.isEmpty()) ans.add(children);
        }
        return ans;
    }
}

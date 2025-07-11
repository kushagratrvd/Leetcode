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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return ans;
        queue.offer(root);
        boolean left = true;
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(left) temp.addLast(node.val);
                else temp.addFirst(node.val);
            }
            left = !left;
            ans.add(temp);
        }
        return ans;
    }
}

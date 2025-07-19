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
class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode _node, int _num){
        node = _node;
        num = _num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int mmin = q.peek().num;
            int n = q.size();
            int first = 0;
            int last = 0;
            for(int i=0; i<n; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int cur_id = p.num-mmin;
                if(i==0) first = cur_id;
                if(i==n-1) last = cur_id;
                if(node.left != null) q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null) q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last+1);
        }
        return ans;
    }
    
}

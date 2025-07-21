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
    public void parent_track(Map parent, Queue<TreeNode> q){
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                    parent.put(node.left,node);
                }
                if(node.right != null){
                    q.offer(node.right);
                    parent.put(node.right,node);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> ParentQueue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        ParentQueue.offer(root);
        parent_track(parent, ParentQueue);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target, true);
        int dis = 0;
        while(!q.isEmpty()){
            int n = q.size();
            if(dis == k) break;
            dis++;
            for(int i=0; i<n; i++){
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left, true);
                } 
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent.get(current) != null && visited.get(parent.get(current)) == null){
                    q.offer(parent.get(current)); 
                    visited.put(parent.get(current), true);  
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            ans.add(current.val);
        }
        return ans;
    }
}

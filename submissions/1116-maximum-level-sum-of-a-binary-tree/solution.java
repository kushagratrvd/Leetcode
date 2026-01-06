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
    public class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int maxLevelSum(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,1));
        ArrayList<Integer> sums = new ArrayList<>();
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.index > sums.size()){
                sums.add(curr.node.val);
            }
            else sums.set(curr.index-1, curr.node.val + sums.get(curr.index-1));
            TreeNode node = curr.node;
            if(node.left != null) q.offer(new Pair(node.left,curr.index+1));
            if(node.right != null) q.offer(new Pair(node.right,curr.index+1));
        }
        int[] maxIndex = new int[]{Integer.MIN_VALUE,0};
        for(int i = 0; i < sums.size(); i++){
            int curr = sums.get(i);
            if(curr > maxIndex[0]){
                maxIndex[0] = curr;
                maxIndex[1] = i;
            } 
        }
        return maxIndex[1]+1;
    }
}

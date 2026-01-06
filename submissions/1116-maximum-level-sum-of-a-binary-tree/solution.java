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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int[] maxSum = new int[]{root.val,1};
        int index = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            boolean flag = false;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                    sum += node.left.val;
                    flag = true;
                } 
                if(node.right != null){
                    sum += node.right.val;
                    q.offer(node.right);
                    flag = true;
                } 
            }
            index++;
            if(flag && sum > maxSum[0]){
                maxSum[0] = sum;
                maxSum[1] = index;
            }
        }
        return maxSum[1];
    }
}

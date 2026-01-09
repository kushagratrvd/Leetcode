
class Solution {
    public int dfs(TreeNode node, int height, TreeNode[] subtree, int[] max){
        if(node == null) return height;
        int n1 = dfs(node.left,height+1,subtree,max);
        int n2 = dfs(node.right,height+1,subtree,max);
        if(n1 == n2 && n1 >= max[0]){
            subtree[0] = node;
            max[0] = n1;
        }
        return Math.max(n1,n2); 
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode[] subtree = new TreeNode[1];
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, 0, subtree, max);
        return subtree[0];
    }
}

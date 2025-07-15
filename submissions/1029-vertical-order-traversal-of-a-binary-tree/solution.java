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

class Tuple{
    TreeNode node;
    int x;
    int y;
    public Tuple(TreeNode _node, int _x, int _y){
        node = _node;
        x = _x;
        y = _y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int row = tuple.x;
            int col = tuple.y;

            if(!map.containsKey(row)){
                map.put(row, new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col, new PriorityQueue<>());
            }

            map.get(row).get(col).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, row-1, col+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, row+1, col+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}

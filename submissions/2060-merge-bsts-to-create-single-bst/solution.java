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
    // Map to hold leaves
    // It will help to query if any given root not is part of leaves node in any of the BST
    Map<Integer, TreeNode > leaves = new HashMap<>();
    
    // Map to hold roots
    // It will help to query - give me any root node which matches given node 
    // Mostly used for querying for left node matches with any root and right node matches any root
    Map<Integer, TreeNode> roots = new HashMap<>();

    //Function to check if it can be merged or not
    public TreeNode canMerge(List<TreeNode> trees) {
    
        // To queries nodes mulitple times in constant operation we will put them into Map
         for(TreeNode node: trees){
             // append to root map
            roots.put(node.val, node);
             
             // append to leaves map
            if(node.left != null){
                leaves.put(node.left.val, new TreeNode(node.val));
            }
            if(node.right != null){
                leaves.put(node.right.val, new TreeNode(node.val));
            }     
        }

        // find a node which will become root of bst
        TreeNode bstRoot = null;
        for(TreeNode n: trees){
            if(!leaves.containsKey(n.val)){
                bstRoot = n;
                break;
            }
        }
        
        // if no unique root found we cannot merge it
        if(bstRoot == null)
            return null;
        
        // invoke merge operation
        merge(bstRoot);
        
        // at the end we will check only 1 tree should be remaining and it should be BST
        if (roots.size() == 1 && isValidBST(bstRoot, Integer.MIN_VALUE, Integer.MAX_VALUE) )
            return bstRoot;
        
        return null;
            
    }
    
    void merge(TreeNode node){
        if(node == null) return;
        if(node.left != null){
            if(roots.containsKey(node.left.val)){
                TreeNode rootNode = roots.remove(node.left.val);
                node.left = rootNode;
            }
            
        }
        if(node.right != null){
            if(roots.containsKey(node.right.val)){
                TreeNode rootNode = roots.remove(node.right.val);
                node.right = rootNode;
            }
        }

        merge(node.left);
        merge(node.right);
    }
    
    boolean isValidBST(TreeNode n, int min, int max){
        if(n.val < min || n.val > max)
            return false;
        
        boolean l =true, r= true;
        
        if(n.left != null)
             l = isValidBST(n.left, min, n.val);
        if(n.right != null)
             r = isValidBST(n.right, n.val, max);
        
        return n.val>min && n.val < max & l && r;
    }
}

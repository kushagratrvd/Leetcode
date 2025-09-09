
class Solution{
public TreeNode deleteNode(TreeNode root, int key) {
//if null i.e. empty tree, return null

    if(root == null){
        return null;
    }

//keep moving left/right until you don't find the key

    if(key < root.val){
        root.left = deleteNode(root.left, key);
    }else if(key > root.val){
        root.right = deleteNode(root.right, key);
    }else{
//if key is found, check if it's left/right is empty

        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }
        //otherwise find min in right subtree, replace with cureent value and delete that min node in right subtree
        TreeNode minNode = findMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}

private TreeNode findMin(TreeNode node){
    while(node.left != null){
        node = node.left;
    }
    return node;
}
}

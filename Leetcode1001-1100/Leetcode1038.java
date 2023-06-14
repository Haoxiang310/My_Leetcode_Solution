class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){
        if(root==null) return;
        
        traverse(root.right);
        root.val = (sum+=root.val);
        traverse(root.left);
    }
}

class Solution {

    public TreeNode invertTree(TreeNode root) {
        // traverse(root);
        // return root;
        if(root==null) return null;

        TreeNode leftChild = invertTree(root.left);
        TreeNode rightChild = invertTree(root.right);
        root.left = rightChild;
        root.right = leftChild;
        return root;
    }
}

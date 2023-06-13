class Solution {


    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

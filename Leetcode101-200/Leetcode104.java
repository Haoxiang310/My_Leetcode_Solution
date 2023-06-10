class Solution {

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int curDepth = Math.max(leftDepth,rightDepth)+1;
        return curDepth;
    }
}
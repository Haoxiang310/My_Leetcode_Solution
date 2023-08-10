lass Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxValue = Math.max(left + right + root.val, maxValue);
        return Math.max(left,right) + root.val;
    }   
}

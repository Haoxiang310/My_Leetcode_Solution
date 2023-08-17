class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max == 0 ? 0 : max - 1;
    }

    //{leftSum, rightSum}
    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int leftSubRight = left[1];
        int rightSubLeft = right[0];
        max = Math.max(max, Math.max(leftSubRight + 1, rightSubLeft + 1));
        return new int[]{leftSubRight + 1, rightSubLeft + 1};
    }
}

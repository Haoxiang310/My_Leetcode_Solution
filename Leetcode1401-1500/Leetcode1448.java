class Solution {
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return cnt;
    }

    public void dfs(TreeNode root, int curMax){
        if(root == null) return;
        if(curMax <= root.val) cnt++;
        dfs(root.left, Math.max(curMax, root.val));
        dfs(root.right, Math.max(curMax, root.val));
    }
}

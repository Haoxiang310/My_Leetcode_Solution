class Solution {

    int res = 0;
    double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, double target){
        if(root == null) return;
        if(Math.abs(root.val - target) < diff){
            res = root.val;
            diff = Math.abs(root.val - target);
        }
        else if(Math.abs(root.val - target) == diff) res = Math.min(res, root.val);
        if(target > root.val) dfs(root.right,target);
        else dfs(root.left, target);
    }
}

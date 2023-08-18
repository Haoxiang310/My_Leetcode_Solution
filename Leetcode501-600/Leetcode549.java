class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    //return {longest increasing, longest decreasing}
    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int icr = 1, dcr = 1;
        if(root.left != null){
            if(root.val == root.left.val + 1) dcr = Math.max(dcr, 1 + left[1]);
            else if(root.val == root.left.val - 1) icr = Math.max(icr, 1 + left[0]);
        }
        if(root.right != null){
            if(root.val == root.right.val + 1) dcr = Math.max(dcr, 1 + right[1]);
            else if(root.val == root.right.val - 1) icr = Math.max(icr, 1 + right[0]);
        }
        res = Math.max(res, icr + dcr - 1);
        return new int[]{icr, dcr};
    }
}

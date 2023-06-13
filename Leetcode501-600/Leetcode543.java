class Solution {
    int res = 0;
    int depth=0;
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        getMaxDepth(root);
        return res;

    }

    int getMaxDepth(TreeNode root){
        if(root==null) return 0;
        int leftMaxDepth = getMaxDepth(root.left);
        int rightMaxDepth = getMaxDepth(root.right);
        res=Math.max(res,leftMaxDepth+rightMaxDepth);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}

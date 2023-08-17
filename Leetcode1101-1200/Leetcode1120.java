class Solution {
    double max = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        getSum(root);
        return max;
    }

    //(sum of subtree, size of subtree)
    public int[] getSum(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = getSum(root.left);
        int[] right = getSum(root.right);
        int currSum = left[0] + right[0] + root.val;
        int size = left[1] + right[1] + 1;
        double avg = (double)currSum / (double) size;
        max = Math.max(avg, max);
        return new int[]{currSum ,size};
    }
}

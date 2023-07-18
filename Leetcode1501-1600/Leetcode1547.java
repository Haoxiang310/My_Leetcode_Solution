class Solution {
    int N, M;
    public int minCost(int n, int[] cuts) {
        N = n;
        M = cuts.length-1;
        int[][] memo = new int[cuts.length][cuts.length];
        Arrays.sort(cuts);
        return dfs(cuts,0,cuts.length-1,memo);
    }

    public int dfs(int[] cuts, int i, int j, int[][] memo){
        if(i > j) return 0;
        if(memo[i][j]!=0) return memo[i][j];
        //因为右区间产生时，右区间的左边界为k+1，而上一次切割位置为cuts[k]，所以计算切割右侧的cost时，应该以原先的cuts[k]为参照
        //也可以改成现在这样，左右均为闭区间。由于for循环中每次需要缩减搜索范围，但下一次dfs时，木棍的长度并不是都由新的左右index确定，木棍的长度的左右边界都是由上一次切割确定的。而每次dfs时，左边界都被+1，右边界都被-1.
        int cost = (j==cuts.length-1?N:cuts[j+1]) - (i==0?0:cuts[i-1]);
        int res = Integer.MAX_VALUE;

        //维持左闭右开区间[i,j)
        //现在是左右闭区间[i,j]
        for(int k = i;k<=j;k++){
            int left = dfs(cuts,i,k-1,memo);
            int right = dfs(cuts,k+1,j,memo);
            res = Math.min(res, left+right+cost);
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}

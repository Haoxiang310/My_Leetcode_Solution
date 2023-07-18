class Solution {
    //Recursive
    public int maxCoins(int[] nums) {
        //dp[i][j]指代在[i,j]区间上，最后引爆某个气球时，带来的最大收益。
        int[][] memo = new int[nums.length][nums.length];
        return dfs(0,nums.length-1,memo,nums);
    }

    public int dfs(int i, int j, int[][] memo, int[] nums){
        if(i>j) return 0;
        if(memo[i][j]!=0) return memo[i][j];
        int res = 0;
        for(int k=i;k<=j;k++){
            int left = dfs(i,k-1,memo,nums);
            int right = dfs(k+1,j,memo,nums);
            //由于我们引爆的是[i,j]闭区间上的某一个气球，并且这个气球是在该区间上最后一个被引爆的
            //因此，我们引爆这个气球时，他的两边应该是i-1和j+1处的气球
            //相当于我们在[i,j]这个位置上找一个地方k放一个气球，确定了下一轮的新边界[i,k-1]和[k+1,j]
            //如果i==j，说明i-1和j+1处都被放好了气球，位置i==j处是最后一个需要被确定的。
            int curr =  (i==0?1:nums[i-1])*nums[k]*(j==nums.length-1?1:nums[j+1]);
            res = Math.max(res, left + right + curr);
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}

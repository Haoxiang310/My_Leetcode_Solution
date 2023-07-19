class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();
        if(sum<Math.abs(target) || (sum+target)%2==1) return 0;
        int[][] dp = new int[nums.length+1][(sum+target)/2+1];
        dp[0][0]=1;
        for(int i = 1; i <= nums.length; i++){
            for(int t = 0; t <= (sum+target)/2; t++){
                if(t>=nums[i-1])
                    dp[i][t] = dp[i-1][t-nums[i-1]]+dp[i-1][t];
                else dp[i][t] = dp[i-1][t];
            }
        }
        return dp[nums.length][(sum+target)/2];
    }
}

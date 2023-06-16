class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0]=grid[0][0];
        int rowSum = grid[0][0];
        int colSum = grid[0][0];
        for(int i=1;i<m;i++){
            colSum+=grid[i][0];
            dp[i][0]+=colSum;
        }
        for(int j=1;j<n;j++){
            rowSum+=grid[0][j];
            dp[0][j]+=rowSum;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}

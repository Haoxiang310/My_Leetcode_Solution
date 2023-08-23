class Solution {
    public int countPalindromicSubsequences(String s) {
        int N = s.length();
        long[][] dp = new long[N][N];
        long MOD = 1_000_000_007;
        for(int j=0;j<N;j++) dp[j][j] = 1;
        for(int j=1;j<N;j++){
            for(int i=j-1;i>=0;i--){
                if(s.charAt(i)!=s.charAt(j))
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                else {
                    dp[i][j] = 2 * dp[i+1][j-1];
                    int left = i+1, right = j-1;
                    while(left <= right && s.charAt(left)!=s.charAt(i)) left++;
                    while(left <= right && s.charAt(right)!=s.charAt(j)) right--;
                    if(left > right) dp[i][j] += 2;
                    else if(left == right) dp[i][j] += 1;
                    else dp[i][j] -= dp[left+1][right-1];
                }
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }
        return (int)dp[0][N-1];
    }
}

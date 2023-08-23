//expand from center
class Solution {
    public int countSubstrings(String s) {
        int N = s.length();
        int res = 0;
        for(int i=0;i<2 * N - 1;i++){
            int left = i / 2, right = left + i % 2;
            while(left>=0 && right <N && s.charAt(left) == s.charAt(right)){
                res += 1;
                left--;
                right++;
            }
        }
        return res;
    }
}
//dp solution
class Solution {
    public int countSubstrings(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        int ans = 0;
        for(int i= N-1;i>=0;i--){
            for(int j=i;j<N;j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i+1][j-1]);
                ans += dp[i][j] ? 1 : 0;
            }
        }
        return ans;
    }
}

class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return s.length()-longestPalindromeSubseq(s)<=k?true:false;
    }
    public int longestPalindromeSubseq(String s) {
                String t = new StringBuilder(s).reverse().toString();
                return LCS(s,t);
    }

        public int LCS(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s.length()][t.length()];
        }
}

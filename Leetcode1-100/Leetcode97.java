class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        //dp[i][j]表示s3的前i+j个字符可以由s1的前i个字符以及s2的前j个字符组成
        //前提是s1.length()+s2.length()==s3.length()
        for(int i=1;i<=s1.length();i++){
            dp[i][0] = s1.charAt(i-1)==s3.charAt(i-1)&&dp[i-1][0];
        }
        for(int j=1;j<=s2.length();j++){
            dp[0][j] = s2.charAt(j-1)==s3.charAt(j-1)&&dp[0][j-1];
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                dp[i][j] = (s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j])
                            ||
                           (s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

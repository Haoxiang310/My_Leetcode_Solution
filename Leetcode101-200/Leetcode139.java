class Solution {

    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n]=true;
        for(String word:wordDict){
            set.add(word);
        }
        for(int i=n-1;i>=0;i--){
            for(int len=1;i+len<=n;len++){
                String sub = s.substring(i,i+len);
                if(set.contains(sub) && dp[i+len]==true) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];

    }



}

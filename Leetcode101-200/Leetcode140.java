class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        List<String>[] dp = new ArrayList[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = new ArrayList<>();
        }
        dp[n].add("");
        for(String word:wordDict){
            set.add(word);
        }
        for(int i=n-1;i>=0;i--){
            for(int len=1;i+len<=n;len++){
                String sub = s.substring(i,i+len);
                if(set.contains(sub)) {
                    List<String> subproblem = dp[i+len];
                    for(String subp:subproblem){
                        if(subp.isEmpty()){
                            dp[i].add(sub);
                        }
                        else dp[i].add(sub + " " + subp);
                    }
                }
            }
        }
        return dp[0];
    }
}

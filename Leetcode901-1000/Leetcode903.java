class Solution {
    int MOD = (int)1e9+7;
    int[][] memo;
    public int numPermsDISequence(String s) {
        memo = new int[s.length()+1][s.length()+1];
        return (int)count(s,new HashMap<String, Long>());
    }

    public long count(String s, HashMap<String, Long> map){
        if(s.equals("")) return 1;
        if(map.containsKey(s)) return map.get(s);
        long res = 0;
        int n = s.length();
        if(s.charAt(0)=='D') res = (res + count(s.substring(1),map)) % MOD;
        if(s.charAt(n-1)=='I') res = (res + count(s.substring(0,n-1),map)) % MOD;
        for(int i=1;i<n;i++) {
            if(s.charAt(i-1)=='I' && s.charAt(i)=='D'){
                long left = count(s.substring(0,i-1),map);
                long right = count(s.substring(i+1),map);
                res += (((left * right)%MOD) * nCk(n,i)) % MOD;
                res %= MOD;
            }
        }
        map.put(s,res);
        return res;
    }

    public int nCk(int n, int k){
        if(n==k || k==0) return 1;
        if(memo[n][k]!=0) return memo[n][k];
        return memo[n][k] = (nCk(n-1,k-1) + nCk(n-1,k))%MOD;
    }
}

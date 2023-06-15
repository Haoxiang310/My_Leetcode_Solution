class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return count(1,n);
    }

    public int count(int lo, int hi){
        if(lo>=hi) return 1;
        if(memo[lo][hi]!=0) return memo[lo][hi];
        int res = 0;
        for(int i=lo;i<=hi;i++){
            int leftNum = count(lo,i-1);
            int rightNum = count(i+1,hi);
            res+=leftNum*rightNum;
        }
        memo[lo][hi] = res;
        return res;
    }
}

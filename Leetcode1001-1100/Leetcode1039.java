class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] memo = new int[values.length][values.length];
        return dfs(0,values.length-1,memo,values);
    }

    public int dfs(int i, int j, int[][] memo, int[] values){
        if(j - i < 2) return 0;
        if(memo[i][j]!=0) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            int left = dfs(i,k,memo,values);
            int right = dfs(k,j,memo,values);
            int curr = values[i] * values[k] * values[j];
            res = Math.min(res, left + right + curr);
        }
        return memo[i][j] = res;
    }
}

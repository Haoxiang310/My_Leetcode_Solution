class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        makePascal(dp);
        return getPath(destination[0],destination[1],k);
    }

    int[][] dp = new int[32][32];
    public void makePascal(int[][] dp){
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            dp[i][0]=1;
            for(int j=1;j<=i;j++){
                dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }

    //we consider the smallest path from destination to origin
    //since the moves will be the same as smallest path from origin to destination
    //the total paths of (r,c) will be the sum of path to (r-1,c) + (r,c-1);
    //the path to (r-1,c) will be larger than path to (r,c-1) since we gain an H while go from (r,c) to (r,c-1)
    public String getPath(int r, int c, int k){
        if(r==0 && c==0) return "";
        if(r==0) return "H"+getPath(r,c-1,k);
        else if(c==0) return "V"+getPath(r-1,c,k);
        else if(k<=dp[r+c-1][c-1]) return "H"+getPath(r,c-1,k);
        else return "V"+getPath(r-1,c,k-dp[r+c-1][c-1]);
    }
}

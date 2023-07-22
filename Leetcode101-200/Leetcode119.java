class Solution {

    int[][] memo;
    public List<Integer> getRow(int rowIndex) {
        memo = new int[rowIndex+1][rowIndex+1];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            res.add(nCk(rowIndex,i));
        }
        return res;
    }

    //pick k balls from n balls
    //n is row index and k is col index
    public int nCk(int n, int k){
        if(n==k || k==0) return 1;
        if(memo[n][k]!=0) return memo[n][k]; 
        int res = nCk(n-1,k-1) + nCk(n-1,k);
        memo[n][k] = res;
        return res;
    }
}

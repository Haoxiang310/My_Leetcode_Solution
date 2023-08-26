class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<res.length;i++){
            res[i] = res[i>>1]+i%2;
        }
        return res;
    }
}

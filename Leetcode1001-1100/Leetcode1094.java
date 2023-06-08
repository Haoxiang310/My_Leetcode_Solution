class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int[] trip:trips){
            int start = trip[1];
            int end = trip[2];
            int pass = trip[0];
            diff[start]+=pass;
            if(end<1001){
                diff[end]-=pass;
            }
        }
        int[] res = new int[1001];
        res[0]=diff[0];
        if(res[0]>capacity) return false;
        for(int i=1;i<diff.length;i++){
            res[i]=res[i-1]+diff[i];
            if(res[i]>capacity) return false;
        }
        return true;
    }
}

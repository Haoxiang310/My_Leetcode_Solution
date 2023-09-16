class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new ArrayList<>();
        boolean placed = false;
        for(int[] interval: intervals){
            int s = interval[0], e = interval[1];
            int new_s = newInterval[0], new_e = newInterval[1];
            if(e < new_s){
                res.add(interval);
            }
            else if(s > new_e){
                if(!placed) {
                    res.add(newInterval);
                    placed = true;
                }
                res.add(interval);
            }
            else{
                new_s = Math.min(new_s, s);
                new_e = Math.max(new_e, e);
                newInterval = new int[]{new_s, new_e};
            }
        }
        if(!placed) res.add(newInterval);
        int[][] ans = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}

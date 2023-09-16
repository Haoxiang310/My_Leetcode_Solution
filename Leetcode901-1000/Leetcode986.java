class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int l = 0, r = 0;
        List<int[]> res = new ArrayList<>();
        while(l < firstList.length && r < secondList.length){
            int lo = Math.max(firstList[l][0], secondList[r][0]);
            int hi = Math.min(firstList[l][1], secondList[r][1]);
            if(lo <= hi){
                res.add(new int[]{lo, hi});
            }
            if(firstList[l][1] < secondList[r][1]) l++;
            else r++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}

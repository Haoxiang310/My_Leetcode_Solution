class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows > 0) res.add(List.of(1));
        for(int i=1;i<numRows;i++){
            res.add(new ArrayList<>());
            res.get(i).add(1);
            for(int j=1;j<i;j++){
                int cur = res.get(i-1).get(j-1)+res.get(i-1).get(j);
                res.get(i).add(cur);
            }
            res.get(i).add(1);
        }
        return res;
    }
}

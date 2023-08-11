class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n,k,res,path,1);
        return res;
    }

    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> path, int i){
        if(n-i+1 < k - path.size()) return;
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int start = i;start<=n;start++){
            path.add(start);
            dfs(n,k,res,path,start+1);
            path.remove(path.size()-1);
        }
        return;
    }
}

class Solution {
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        int N = nums.length;
        used = new boolean[N];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, res, path);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path){
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            path.add(nums[i]);
            dfs(nums,res,path);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
}

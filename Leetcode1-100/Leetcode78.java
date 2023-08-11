class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int s = i;s<nums.length;s++){
            path.add(nums[s]);
            dfs(nums,s+1,path);
            path.remove(path.size()-1);
        }
    }
}

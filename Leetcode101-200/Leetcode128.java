class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        UF uf = new UF(nums.length);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)) uf.union(i,map.get(nums[i]+1));
            if(map.containsKey(nums[i]-1)) uf.union(i,map.get(nums[i]-1));
        }
        int max = 0;
        int[] count = new int[uf.parent.length];
        for(int i=0;i<uf.parent.length;i++){
            count[uf.find(i)]++;
            max = Math.max(max,count[uf.find(i)]);
        }
        return max;
    }
}

class UF{
    int[] parent;
    public UF(int n){
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        parent[rootx] = rooty;
    }
}

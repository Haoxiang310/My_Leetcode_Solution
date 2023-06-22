class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        for(int i = 0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int res = collect(0);
        return res==-1?0:res;
    }

    int collect(int root){
        if(visited.contains(root)) return -1;
        visited.add(root);
        int sum = 0;
        for(Integer i:graph.get(root)){
            int num = collect(i);
            if(num!=-1) sum+=num+2;
        }
        if(sum>0) return sum;
        if(sum==0 && hasApple.get(root)) return 0;
        return -1;
    }
}

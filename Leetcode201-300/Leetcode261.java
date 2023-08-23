//dfs+parent node solution
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++) res.add(new ArrayList<>());
        for(int[] edge:edges){
            int from = edge[0], to = edge[1];
            res.get(from).add(to);
            res.get(to).add(from);
        }
        boolean[] visited = new boolean[n];
        //connected graph or tree
        if(hasCycle(0,res,visited,-1)) return false;
        
        //disconnected graph
        int cnt = 0;
        for(int i = 0;i<visited.length;i++)
            if(visited[i]) cnt++;
        return cnt == n;
    }

    public boolean hasCycle(int cur, List<List<Integer>> graph, boolean[] visited, int prev){
        visited[cur] = true;
        List<Integer> neighbors = graph.get(cur);
        for(int i=0;i<neighbors.size();i++){
            int nei = neighbors.get(i);
            if(!visited[nei]){
                if(hasCycle(nei,graph,visited,cur)) return true;
            }
            else{
                if(nei!=prev) return true;
            }
        }
        return false;
    }
}

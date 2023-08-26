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

//UF Solution
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge: edges){
            int x = edge[0], y = edge[1];
            if(uf.find(x) == uf.find(y)) return false;
            uf.union(x,y);
        }
        //排除森林
        return edges.length == n - 1;
    }
}

class UF{
    int[] parent;

    public UF(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x), rootY = find(y);
        parent[rootX] = rootY;
    }
}

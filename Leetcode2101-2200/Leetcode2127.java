class Solution {
    //两种情况：
    //（1）二人组，然后向外扩展，找到两个方向的最大链
    //（2）找最大环（不存在最大环外的链子出现更大的人数，因为每个人只能喜欢一个人，环中每个节点都有喜欢的人了
    int maxCycleSize = 0;
    int N;
    int[] favorite;
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> pairs = new ArrayList<>();
    public int maximumInvitations(int[] favorite) {
        N = favorite.length;
        this.favorite = favorite;
        //1.build graph
        for(int i=0;i<favorite.length;i++){
            int from = favorite[i], to = i;
            graph.computeIfAbsent(from, k->new ArrayList<>());
            graph.get(from).add(to);
        }
        //2.count cycle
        countCycle();
        return Math.max(countAllPairs(), maxCycleSize);
    }

    Map<Integer, Integer> singleDirectionPathLen = new HashMap<>();
    public int countAllPairs(){

        int res = 0;
        for(List<Integer> pair:pairs){
            int a = pair.get(0), b = pair.get(1);
            boolean[] visited = new boolean[N];
            singleDirectionPathLen.put(a,0);
            singleDirectionPathLen.put(b,0);
            dfs(a,0,a,b);
            
            dfs(b,0,b,a);

            res += 2 + singleDirectionPathLen.get(a) + singleDirectionPathLen.get(b);
        }

        return res;
    }

    public void dfs(int cur,int len,int origin,int pairAnother){
        if(cur == pairAnother) return;
        singleDirectionPathLen.put(origin, Math.max(len,singleDirectionPathLen.get(origin)));
        for(int nei:graph.getOrDefault(cur,new ArrayList<>())){
            dfs(nei, len+1, origin, pairAnother);
        }
    }

    public void countCycle(){
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];
        for(int i=0;i<N;i++){
            isCycleUtil(visited, recStack,i,0);
        }
    }

    public void isCycleUtil(boolean[] visited, boolean[] recStack, int cur, int cnt){
        if(recStack[cur]){
            if(cnt == 2) pairs.add(List.of(cur,favorite[cur]));
            maxCycleSize = Math.max(maxCycleSize, cnt);
            return;
        }
        if(visited[cur]) return;
        visited[cur] = true;
        recStack[cur] = true;
        for(int nei:graph.getOrDefault(cur,new ArrayList<>())){
            isCycleUtil(visited, recStack, nei, cnt+1);
        }
        recStack[cur] = false;
        return;
    }
}

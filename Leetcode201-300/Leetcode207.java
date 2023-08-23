class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        boolean[] recStack = new boolean[numCourses];
        //visited数组用于记录每次dfs以后遍历到的节点的结果。比如从1开始遍历了1->2->3，发现没有环，那么如果有一条4->1的边，我们按顺序遍历完2,3，发现都被遍历过，所以return false。从4开始遍历时，会进入先前没有环的子图，由于visited数组记录了visited[1]=true，因此进入1后直接回返回false无环，就不需要重新走4->1->2->3这条路了。反之，如果1,2,3这个子图中有环，比如1->2->3->1，那么从1开始的遍历就会直接返回true，不会再走节点4开始的dfs了。同时，不存在1，2,3的子图无环，而1，2，3，4节点的子图有环的可能。如果这样的话，从1，,2，,3节点的子图一定有一条边到4，这样从1开始的dfs就会遍历到4了。
        boolean[] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(cycleDetection(visited, recStack, graph, i)) return false;
        }
        return true;
    }

    public List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numCourses;i++) res.add(new ArrayList<>());
        for(int[] prerequisite: prerequisites){
            int from = prerequisite[0], to = prerequisite[1];
            res.get(from).add(to);
        }
        return res;
    }

    public boolean cycleDetection(boolean[] visited, boolean[] recStack, List<List<Integer>> graph, int curr){
        if(recStack[curr]) return true;
        if(visited[curr]) return false;
        recStack[curr] = true;
        visited[curr] = true;
        for(int nei: graph.get(curr)){
            if(cycleDetection(visited, recStack, graph, nei)) return true;
        }
        recStack[curr] = false;
        return false;
    }
}

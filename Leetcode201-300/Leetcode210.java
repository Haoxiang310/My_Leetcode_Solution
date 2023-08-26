class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int cnt = 0;
        for(int i=0;i<graph.size();i++){
            for(int curr:graph.get(i)){
                indegree[curr]++;
            }
        }
        for(int i=0;i<indegree.length;i++)
            if(indegree[i] == 0) q.offer(i);
        while(!q.isEmpty()){
            int cur = q.poll();
            res[cnt++] = cur;
            for(int nei:graph.get(cur)){
                if(--indegree[nei] == 0) q.offer(nei);
            }
        }
        return numCourses != cnt ? new int[0] : res;
    }

    public List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] prerequisite: prerequisites){
            int from = prerequisite[1], to = prerequisite[0];
            graph.get(from).add(to);
        }
        return graph;
    }
}

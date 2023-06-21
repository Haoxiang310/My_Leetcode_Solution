class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        traverse(graph,0,path);
        return res;
    }

    public void traverse(int[][] graph, int start, List<Integer> path){

        if(start==0) path.add(0);
        if(start==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int ad:graph[start]){
            path.add(ad);
            traverse(graph,ad,path);
            path.remove(path.size()-1);
        }

        return;
    }
}

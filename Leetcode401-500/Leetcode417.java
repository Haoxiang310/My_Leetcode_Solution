class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int M = heights.length, N = heights[0].length;
        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> atlq = new LinkedList<>();
        for(int i=0;i<M;i++){
            pacq.offer(new int[]{i,0});
            atlq.offer(new int[]{i,N-1});
        }
        for(int j=0;j<N;j++){
            pacq.offer(new int[]{0,j});
            atlq.offer(new int[]{M-1,j});
        }
        boolean[][] pacList = bfs(pacq,heights);
        boolean[][] atlList = bfs(atlq,heights);
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(pacList[i][j] && atlList[i][j]){
                    res.add(List.of(i,j));
                } 
            }
        }
        return res;
    }

    public boolean[][] bfs(Queue<int[]> q,int[][] heights){
        int M = heights.length, N = heights[0].length;
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        boolean[][] res = new boolean[M][N];
        while(!q.isEmpty()){
            int[] curr = q.poll();
            res[curr[0]][curr[1]] = true;
            for(int[] d : dir){
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                    if(res[nx][ny]) continue;
                    if(heights[nx][ny] >= heights[curr[0]][curr[1]]){
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return res;
    }
}

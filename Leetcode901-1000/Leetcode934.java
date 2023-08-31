class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> island = new ArrayList<>();
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int M = grid.length, N = grid[0].length;
        int step = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j] == 1){
                    //bfs to connect one island and convert it into -1
                    q.offer(new int[]{i,j});
                    grid[i][j] = -1;
                    island.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] d:dir){
                            int nx = curr[0] + d[0];
                            int ny = curr[1] + d[1];
                            if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                                if(grid[nx][ny] == 1){
                                    q.offer(new int[]{nx,ny});
                                    island.add(new int[]{nx,ny});
                                    grid[nx][ny] = -1;
                                }
                            }
                        }
                    }
                    for(int[] is:island){
                        q.offer(is);
                    }
                    while(!q.isEmpty()){
                        int sz = q.size();
                        for(int k=0;k<sz;k++){
                            int[] cur = q.poll();
                            for(int[] di:dir){
                                int nextx = cur[0] + di[0];
                                int nexty = cur[1] + di[1];
                                if(nextx >= 0 && nextx < M && nexty >= 0 && nexty < N){
                                    if(grid[nextx][nexty] == 0){
                                        q.offer(new int[]{nextx,nexty});
                                        grid[nextx][nexty] = -1;
                                    }
                                    else if(grid[nextx][nexty] == 1) return step;
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return -1;
    }
}

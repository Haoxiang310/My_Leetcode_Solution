class Solution {
    public int closedIsland(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int res = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j] == 0){
                    if(bfs(grid,i,j)) res++;
                }
            }
        }
        return res;
    }

    public boolean bfs(int[][] grid, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        int M = grid.length, N = grid[0].length;
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        grid[x][y] = 1;
        boolean mark = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d: dir){
                int nextX = curr[0] + d[0];
                int nextY = curr[1] + d[1];
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) mark = false;
                else{
                    if(grid[nextX][nextY] == 0){
                        grid[nextX][nextY] = 1;
                        q.offer(new int[]{nextX,nextY});
                    }
                }
            }
        }
        return mark;
    }
}

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->b[2] - a[2]
        );
        int M = grid.length, N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        int res = Integer.MAX_VALUE;
        pq.offer(new int[]{0,0,grid[0][0]});
        visited[0][0] =  true;
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curX = cur[0], curY = cur[1], w = cur[2];
            res = Math.min(res, w);
            if(curX == M - 1 && curY == N - 1) return res;
            for(int[] d:dir){
                int nextX = curX + d[0], nextY = curY + d[1];
                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    pq.offer(new int[]{nextX, nextY, grid[nextX][nextY]});
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int M = maze.length, N = maze[0].length;
        int[][] dist = new int[M][N];
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[2]-b[2]
        );
        for(int[] row:dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        pq.offer(new int[]{start[0], start[1], 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int curX = curr[0], curY = curr[1], curDist = curr[2];
            for(int[] d: dir){
                int nextX = curX, nextY = curY, cnt = 0;
                while(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && maze[nextX][nextY] != 1){
                    nextX += d[0];
                    nextY += d[1];
                    cnt++;
                }
                cnt--;
                nextX -= d[0];
                nextY -= d[1];
                if(curDist + cnt < dist[nextX][nextY]){
                    dist[nextX][nextY] = curDist + cnt;
                    pq.offer(new int[]{nextX, nextY, dist[nextX][nextY]});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 :  dist[destination[0]][destination[1]];
    }
}

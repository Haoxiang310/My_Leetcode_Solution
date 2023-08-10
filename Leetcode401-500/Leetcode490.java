//DFS solution
class Solution {
    boolean[][] visited;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        return dfs(start,destination,maze);
    }

    public boolean dfs(int[] start, int[] destination, int[][] maze){
        int x = start[0], y = start[1];
        if(visited[x][y] == true) return false;
        if(x == destination[0] && y == destination[1]) {
            return true;
        }
        visited[x][y] = true;
        for(int d=0;d<4;d++){
            int i = start[0], j = start[1];
            while( i + dir[d][0] >= 0 && j + dir[d][1] >= 0 && i + dir[d][0] < maze.length && j + dir[d][1] < maze[0].length && maze[i + dir[d][0]][j + dir[d][1]]==0){
                i += dir[d][0];
                j += dir[d][1];
            }
            if(dfs(new int[]{i,j}, destination, maze)) return true;
        }
        return false;
    }
}

//BFS solution
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int M = maze.length, N = maze[0].length;
        boolean[][] visited = new boolean[M][N];
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                int[] cur = q.poll();
                if(cur[0] == destination[0] && cur[1] == destination[1]) return true;
                for(int[] d:dir){
                    int x = cur[0], y = cur[1];
                    while(x + d[0] >= 0 &&
                          y + d[1] >= 0 && 
                          x + d[0] < M && 
                          y + d[1] < N && 
                          maze[x+d[0]][y+d[1]] == 0){
                              x += d[0];
                              y += d[1];
                          }
			  //visited matrix can be judged either offering nodes into  queue or poll out from queue. When judging from polling out, we actually added visited nodes into queue. This will cost extra time. Hence we judge before offering nodes into queue, which will not add unnecessary nodes into queue	 
                          if(!visited[x][y]){
                              q.add(new int[]{x,y});
                              visited[x][y] = true;
                          }
                }
            }
        }
        return false;
    }
}

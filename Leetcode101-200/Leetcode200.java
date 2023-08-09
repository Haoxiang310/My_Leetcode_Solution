//dfs solution
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1') {
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    public void dfs(int x, int y, char[][] grid){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
        if(grid[x][y]=='1') grid[x][y]='0';
        dfs(x+1,y,grid);
        dfs(x-1,y,grid);
        dfs(x,y-1,grid);
        dfs(x,y+1,grid);
    }
}

//bfs solution
class Solution {

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    res++;
                    bfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]=='0') continue;
            grid[x][y] = '0';
            q.add(new int[]{x+1,y});
            q.add(new int[]{x-1,y});
            q.add(new int[]{x,y+1});
            q.add(new int[]{x,y-1});
        }
    }
}

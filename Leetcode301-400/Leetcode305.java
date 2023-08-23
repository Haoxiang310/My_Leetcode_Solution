class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        UF uf = new UF(m*n);
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        boolean[][] isIsland = new boolean[m][n];
        for(int[] position: positions){
            int x = position[0], y = position[1];
            if(isIsland[x][y] == true){
                res.add(cnt);
                continue;
            }
            isIsland[x][y] = true;
            cnt++;
            for(int[] d:dir){
                int curX = x + d[0], curY = y + d[1];
                if(curX < 0 || curX >= m || curY < 0 || curY >= n) continue;
                if(isIsland[curX][curY]){
                    int rootCur = uf.find(curX * n + curY);
                    int root = uf.find(x * n + y);
                    if(root != rootCur){
                        cnt--;
                        uf.union(root,rootCur);
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
}

class UF {
    int[] parents;
    public UF(int n){
        this.parents = new int[n];
        for(int i=0;i<n;i++) parents[i] = i;
    }
    public int find(int x){
        if(parents[x]!=x) parents[x] = find(parents[x]);
        return parents[x];
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        parents[rootX] = rootY;
    }
}

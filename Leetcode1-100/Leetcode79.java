class Solution {
    String word;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        int M = board.length, N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == word.charAt(0) && dfs(board,i,j,"",visited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String str, boolean[][] visited){
        int M = board.length, N = board[0].length;
        if(x < 0 || x >= M || y < 0 || y >= N) return false;
        if(visited[x][y]) return false;
        str += board[x][y];
        if(str.equals(word)) return true;
        if(str.length() > word.length()) return false;
        visited[x][y] = true;
        boolean b1 = dfs(board, x+1, y, str, visited);
        boolean b2 = dfs(board, x-1, y, str, visited);
        boolean b3 = dfs(board, x, y+1, str, visited);
        boolean b4 = dfs(board, x, y-1, str, visited);
        visited[x][y] = false;
        return b1 || b2 || b3 || b4;
    }
}

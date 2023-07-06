class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        //按照行递增或者列递增的顺序考虑
        dfs(res,0,board);
        return res;
    }

    public void dfs(List<List<String>> res, int row, char[][] board){
        if(row==board.length){
            res.add(construct(board));
            return;
        }
        for(int col = 0;col<board.length;col++){
            if(!valid(board,row,col)) continue;
            board[row][col]='Q';
            dfs(res,row+1,board);
            board[row][col]='.';
        }
    }

    public boolean valid(char[][] board, int x, int y){
        for(int r=0;r<x;r++){
            for(int c=0;c<board.length;c++){
                if(board[r][c]=='Q' && (((x-y)==(r-c)) || ((x+y)==(r+c)) || (y==c))){
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            //直接通过String构造函数把char array构建成string
            list.add(new String(board[i]));
        }
        return list;
    }
}

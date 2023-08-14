//Divide & Conquer
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0,0,matrix.length-1, matrix[0].length-1);
    }

    public boolean search(int[][] matrix, int target, int x1, int y1, int x2, int y2){
        if(x1 > x2 || y1 > y2) return false;
        int x = x1 + (x2-x1)/2;
        int y = y1 + (y2-y1)/2;
        if(matrix[x][y] == target) return true;
        else if(matrix[x][y] > target) return search(matrix, target, x1, y1, x-1, y2) || search(matrix, target, x1,y1,x2,y-1);
        else return search(matrix, target, x+1,y1,x2,y2) || search(matrix, target, x1,y+1,x2,y2);
    }
}

//O(M+N) Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = 0;
        while(row >=0 && col < matrix[0].length){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col] < target){
                col++;
            }
            else row--;
        }
        return false;
    }
}

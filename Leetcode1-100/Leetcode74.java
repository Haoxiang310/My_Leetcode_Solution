class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length;
        int left = 0, right = M - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid][0] <= target) left = mid + 1;
            else right = mid - 1;
        }
        int row = left - 1;
        if(row < 0) return false;
        left = 0; right = N - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}

class NumMatrix {

    public int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        prefixSumMatrix=new int[row+1][col+1];
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                prefixSumMatrix[i][j] = 
                    prefixSumMatrix[i-1][j] + prefixSumMatrix[i][j-1] + 
                    matrix[i - 1][j - 1] - prefixSumMatrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSumMatrix[row2+1][col2+1]-prefixSumMatrix[row2+1][col1]-prefixSumMatrix[row1][col2+1]+prefixSumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

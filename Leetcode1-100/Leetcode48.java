class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length==0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<col;i++){
            reverseArray(matrix[i]);
        }
        return;

    }

    void reverseArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int temp = arr[right];
            arr[right]=arr[left];
            arr[left]=temp;
            left++;
            right--;
        }
        return;
    }
}

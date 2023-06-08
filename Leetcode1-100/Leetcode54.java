class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int upper_bound = 0;
        int lower_bound = m-1;
        int left_bound = 0;
        int right_bound = n-1;

        while(res.size() < m*n){
            if(upper_bound<=lower_bound){
                for(int j=left_bound;j<=right_bound;j++){
                    res.add(matrix[upper_bound][j]);
                }
                upper_bound++;
            }
            if(right_bound>=left_bound){
                for(int i=upper_bound;i<=lower_bound;i++){
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;

            }
            if(lower_bound>=upper_bound){
                for(int j=right_bound;j>=left_bound;j--){
                    res.add(matrix[lower_bound][j]);
                }
                lower_bound--;
            }
            if(left_bound<=right_bound){
                for(int i=lower_bound;i>=upper_bound;i--){
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}

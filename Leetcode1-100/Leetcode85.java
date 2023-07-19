class Solution {
    public int maximalRectangle(char[][] matrix) {
        //we can use leetcode84 to solve this problem
        int M = matrix.length, N = matrix[0].length;
        int[] heights = new int[N];
        int res = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                //if current unit[i][j] is 0，then on layer i, height[j]=0
                if(matrix[i][j]=='0') heights[j]=0;
                else heights[j]++;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                //calculate res
                int preHeight = heights[stack.pop()];
                int width = i - (stack.isEmpty()?0:(stack.peek()+1));
                res = Math.max(res,preHeight * width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            //calculate res of remaining elements in stack
            int preHeight = heights[stack.pop()];
            int width = heights.length - (stack.isEmpty()?0:(stack.peek()+1));
            res = Math.max(res,preHeight * width);
        }
        return res;
    }
}

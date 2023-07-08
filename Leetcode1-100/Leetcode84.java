class Solution {

    //divide and conquer, TLE, since worst case require O(n^2)
    // public int largestRectangleArea(int[] heights) {
    //     return divide(heights, 0, heights.length-1);
    // }

    // public int divide(int[] heights, int start, int end){

    //     if(start > end) return 0;
    //     int minHeightIndex = start;
    //     for(int i=start;i<=end;i++){
    //         if(heights[minHeightIndex]>heights[i]) minHeightIndex = i;
    //     }
    //     int curr = heights[minHeightIndex] * (end - start + 1);
    //     int left = divide(heights, start, minHeightIndex - 1);
    //     int right = divide(heights, minHeightIndex + 1, end);
    //     return Math.max(curr, Math.max(left, right));
    // }


    //mono stack
    //维持一个递增栈，当遇到元素都是递增时不需要进行处理，因为此时面积都是在增加的
    //当递增规则被打破时，依次计算每个从需要出栈的元素到违背单调栈规则元素之间的面积
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int preHeight = heights[stack.pop()];
                int width = i-(stack.isEmpty()?0:stack.peek()+1);
                res = Math.max(preHeight * width,res);
            }
            stack.push(i);
        }

        //计算最终单调栈中剩余元素的情况，这是因为最终的单调栈无法触发当遇到违背规则的元素出现时（有元素需要出栈时）的统一计算，相当于最终的单调栈计算被漏掉了
        while(!stack.isEmpty()){
            int prevHeight = heights[stack.pop()];
            int width_ = heights.length -(stack.isEmpty()?0:stack.peek()+1);
            res = Math.max(prevHeight * width_, res);
        }
        return res;
    }
}

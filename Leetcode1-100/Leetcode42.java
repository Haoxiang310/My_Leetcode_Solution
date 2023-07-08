class Solution {
    //DP Solution
    // public int trap(int[] height) {
    //     int res = 0;
    //     int[] left = new int[height.length];
    //     int[] right = new int[height.length];
    //     left[0]=height[0];
    //     right[height.length-1]=height[height.length-1];
    //     for(int i=1;i<height.length;i++){
    //         left[i]=Math.max(left[i-1],height[i]);
    //     }
    //     for(int j=height.length-2;j>=0;j--){
    //         right[j]=Math.max(right[j+1],height[j]);
    //     }
    //     for(int k=0;k<height.length;k++){
    //         res+=Math.min(left[k],right[k])-height[k];
    //     }
    //     return res;
    // }

    //mono stack
    public int trap(int[] height) {
        //递减栈，在每次遇到高度增加的时候计算储水
        //高度增加时，当前高度与先前栈中的栈顶元素（湖底）以及栈中第二个元素（左墙壁）构成一个积水的结构。
        //每当遇到这样的结构，就计算一次储水量
        Stack<Integer> stack = new Stack<>();
        int N = height.length;
        int res = 0;
        for(int i=0;i < N;i++){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                int pre = stack.pop();
                if(stack.isEmpty()) break;
                res += (Math.min(height[i], height[stack.peek()]) - height[pre]) * (i - stack.peek() - 1);
            }            
            stack.push(i);
        }
        return res;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;
        while(left < right){
            int currWater = Math.min(height[right],height[left]) * (right - left);
            res = Math.max(currWater, res);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}

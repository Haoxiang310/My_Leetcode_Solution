//divide and conquer solution
class Solution {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    public int divide(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = left + (right - left)/2;
        int leftMax = divide(nums, left, mid);
        int rightMax = divide(nums, mid+1, right);
        int crossMax = conquer(nums, left, right, mid);
        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    public int conquer(int[] nums, int left, int right, int mid){
        int leftSum = 0, leftMax = Integer.MIN_VALUE;
        for(int i = mid;i>=left;i--){
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }
        int rightSum = 0, rightMax = Integer.MIN_VALUE;
        for(int i= mid + 1;i<=right;i++){
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        return leftMax + rightMax;
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[left] <= nums[right]) return nums[left];
            else if(nums[mid] >= nums[left] && nums[mid] > nums[right]) left = mid + 1;
            else if(nums[mid] < nums[left] && nums[mid] <= nums[right]) right = mid;
        }
        return 0;
    }
}

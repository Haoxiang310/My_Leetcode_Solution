class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[right]) right--;
            else if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid;
            }
            else if(nums[mid] > nums[right]){
                if(target < nums[mid] && target >= nums[left]) right = mid;
                else left = mid + 1;
            }
        }
        return nums[left] == target;
    }
}

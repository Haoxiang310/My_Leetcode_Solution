class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left=mid+1;
            else if(nums[mid]>target) right=mid;
        }
        return -1;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = 0, right = nums.length;
        
        int[] ans = new int[2];

        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>target) right = mid;
            else if(nums[mid]<target) left = mid + 1;
            else right = mid;
        }

        if(left == nums.length) ans[0]=-1;
        else ans[0] = nums[left]==target?left:-1;

        left = 0;
        right = nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>target) right = mid - 1;
            else if(nums[mid]<target) left = mid + 1;
            else left = mid + 1;
        }

        if(left-1 < 0) ans[1]=-1;
        else ans[1]=target==nums[right]?right:-1;

        return ans;

    }


}

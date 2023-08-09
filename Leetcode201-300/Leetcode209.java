class Solution {
    //Sliding Window O(N)
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int left = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum>=target){
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == nums.length+1?0:res;
    }

    //Binary Search 
}

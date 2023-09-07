class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1, cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) cnt++;
            else cnt = 1;
            if(cnt <= 2) nums[insertIndex++] = nums[i];
        }
        return insertIndex;
    }
}

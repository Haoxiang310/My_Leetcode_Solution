class Solution {
    public void moveZeroes(int[] nums) {
	//left pointer keep track of the leftmost available place for inserting a new non-zero element
        int left = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[left++] = nums[i];
            }
        }
        while(left < nums.length){
            nums[left++] = 0;
        }
    }
}

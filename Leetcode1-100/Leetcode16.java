class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length-1];
        for(int i=0;i<nums.length - 2;i++){
            int left = i + 1, right = nums.length-1;
            while(left < right){
                int curr = nums[left] + nums[right] + nums[i];
                if(Math.abs(target - res) > Math.abs(target - curr)){
                    res = curr;
                }
                if(curr > target) right --;
                else left ++;
            }
        }
        return res;
    }
}

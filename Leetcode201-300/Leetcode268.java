class Solution {
    public int missingNumber(int[] nums) {
        int miss = 0;
        for(int num:nums) miss ^= num;
        for(int i=0;i<=nums.length;i++){
            miss ^= i;
        }
        return miss;
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num:nums) xor ^= num;
        int lastDigit = xor & (-xor);
        int group1 = 0, group2 = 0;
        for(int num:nums){
            if((num & lastDigit) == 0) group1 ^= num;
            else group2 ^= num;
        }
        return new int[]{group1, group2};
    }
}

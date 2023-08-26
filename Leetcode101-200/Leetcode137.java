class Solution {
    public int singleNumber(int[] nums) {
        int[] map = new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){
                map[i] += (num>>i) & 1;
            }
        }
        for(int i=0;i<32;i++){
            map[i] %= 3;
        }
        int res = 0;
        for(int i=0;i<32;i++){
            res |= (map[i] << i);
        }
        return res;
    }
}

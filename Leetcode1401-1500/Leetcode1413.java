class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num:nums){
            sum += num;
            min = Math.min(min, sum);
        }
        return min > 0 ? 1 : Math.abs(min) + 1;
    }
}

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(calc(nums,mid) > threshold) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public long calc(int[] nums, int d){
        long res = 0;
        for(int num:nums){
            res += Math.ceil((double)num / d);
        }
        return res;
    }
}

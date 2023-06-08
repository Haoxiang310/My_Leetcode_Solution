class NumArray {

    int[] nums;

    int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums=nums;
        int n = nums.length;
        prefixSum = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefixSum[i]=sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right]-prefixSum[left]+nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

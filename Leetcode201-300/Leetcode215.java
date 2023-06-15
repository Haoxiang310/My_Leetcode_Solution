class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,nums.length-k,0,nums.length-1);
    }

    public int quickSelect(int[] nums, int k, int lo, int hi){
        int p = partition(nums,lo,hi);
        if(p>k) return quickSelect(nums,k,lo,p-1);
        else if(p<k) return quickSelect(nums,k,p+1,hi);
        else return nums[p];
    }

    public int partition(int[] nums, int lo, int hi){
        int i = lo+1;
        int j = hi;
        int pivot = nums[lo];
        while(i<=j){
            while(i<=hi && nums[i]<=pivot) i++;
            while(j>=lo+1 && nums[j]>pivot) j--;
            if(i>j) break;
            swap(i,j,nums);
        }
        swap(i-1,lo,nums);
        return i-1;
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

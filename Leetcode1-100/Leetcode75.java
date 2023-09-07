class Solution {
    public void sortColors(int[] nums) {
        divide(nums,0,nums.length - 1);
    }
    
    public void divide(int[] nums, int left, int right){
        if(left >= right) return;
        int pivot = partition(nums, left, right);
        divide(nums, left, pivot-1);
        divide(nums, pivot+1, right);
    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int l = left, r = right - 1;
        while(l <= r){
            while(l <= r && nums[l] < pivot) l++;
            while(l <= r && nums[r] >= pivot) r--;
            if(l > r) break;
            swap(nums, l, r);
        }
        swap(nums, l, right);
        return l;
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

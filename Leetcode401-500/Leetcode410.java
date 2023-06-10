class Solution {

    public int calculatek(int[] nums, int capacity){
        int k = 0;
        int i = 0;
        int cap = capacity;
        while(i<nums.length){
            if(cap>=nums[i]){
                cap-=nums[i];
                i++;
            }
            else{
                cap=capacity;
                k++;
            }
        }
        return ++k;

    }
    public int splitArray(int[] nums, int k) {
        
        int max = 0, sum = 0;
        for(int num:nums){
            max=Math.max(num,max);
            sum+=num;
        }

        int left = max;
        int right = sum+1;

        while(left<right){
            int mid = left + (right-left)/2;
            if(calculatek(nums,mid)>k) left=mid+1;
            else right = mid;
        }

        return left;

    }
}

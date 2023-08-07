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

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = Arrays.stream(nums).sum();
        while(left <= right){
            int mid = left + (right-left)/2;
            if(!kIsValid(nums,k,mid)) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public boolean kIsValid(int[] nums, int k, int subSum){
        int sum = 0;
	//since if our last subarray is valid, we won't count on it.(we only increase cnt when subarraySum is not valid) So we need to initiate cnt with 1.
        int cnt = 1;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > subSum){
                sum = 0;
                cnt++;
                i--;
            }
            if(cnt > k) return false;
        }
        return true;
    }
}

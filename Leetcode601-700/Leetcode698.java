class Solution {
    //In the perspective of nums:
    // int[] bucket;
    // public boolean canPartitionKSubsets(int[] nums, int k) {
    //     if(k>nums.length) return false;
    //     int sum = 0;
    //     for(int num:nums){
    //         sum+=num;
    //     }
    //     if(sum%k!=0) return false;
    //     int target = sum / k;
    //     bucket = new int[k];
    //     //Sort the array in descending order. Since the larger element will be easier to exceed target after adding to bucket[i], it will judge unsatisfiable cases earlier.
    //     Arrays.sort(nums);
    //     for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
    //     // 交换 nums[i] 和 nums[j]
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }
    //     return backtrack(nums,0,target);
    // }

    // public boolean backtrack(int[] nums, int i, int target){
    //     if(i == nums.length) {
    //        for(int k=0;k<bucket.length;k++){
    //            if(bucket[k]!=target) return false;
    //            else return true;
    //        } 
    //     }
    //     for(int j=0;j<bucket.length;j++){
    //         if(bucket[j]+nums[i]>target) continue;
    //         bucket[j]+=nums[i];
    //         if(backtrack(nums,i+1,target)) return true;
    //         bucket[j]-=nums[i];
    //     }
    //     return false;
    // }

    //Bucket perspective:
    HashMap<String, Boolean> memo;
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k>nums.length) return false;
        int sum = 0;
        used = new boolean[nums.length];
        memo = new HashMap<>();
        for(int num:nums){
            sum+=num;
        }
        if(sum%k!=0) return false;
        int target = sum / k;
        return backtrack(nums,k,target,0,0,used);
    }

    public boolean backtrack(int[] nums, int k, int target, int start, int bucket,boolean[] used){
        if(k==0) return true;
        String state = Arrays.toString(used);
        if(bucket==target) {
            boolean res = backtrack(nums,k-1,target,0,0,used);
            memo.put(state,res);
        }
        if(memo.containsKey(state)) return memo.get(state);
        for(int i=start;i<nums.length;i++){
            if(used[i]) continue;
            if(nums[i]+bucket>target) continue;
            bucket+=nums[i];
            used[i]=true;
            if(backtrack(nums,k,target,i+1,bucket,used)) return true;
            bucket-=nums[i];
            used[i]=false;
        } 
        return false;
    }
}

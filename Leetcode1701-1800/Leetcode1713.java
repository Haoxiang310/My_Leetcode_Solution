class Solution {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //相当于找两个数组的lcs，但是找lcs需要N^2的时间，会超时
        //转换思路，变成在在arr中寻找target中元素下标的lis
        //因为target中元素时unique的，因此值与下标一一对应。
        //而arr中如果有子序列为target，则子序列的下标顺序与target的下标顺序一致
        //相当于找arr中有多少个元素是与target中顺序一致的，然后补充其他缺失的元素即可。
        for(int i=0;i<target.length;i++){
            map.put(target[i],i);
        }
        int[] nums = new int[arr.length];
        for(int j=0;j<arr.length;j++){
            nums[j] = map.getOrDefault(arr[j],-1);
        }
        return target.length - lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int size = 0;
        // for(int x:nums){
        //     if(x==-1) continue;
        //     int i = Arrays.binarySearch(dp,0,size,x);
        //     if(i<0) i=-(i+1);
        //     dp[i]=x;
        //     if(i==size) size++;
        // }

        for(int i=0;i<nums.length;i++){
            //跳过所有不在target中的元素
            //因为我们是用下标递增来代替了原先数值递增的lis，所以下标-1有可能会造成lis比正确值大1，或者不大
            if(nums[i]==-1) continue;
            int pos = binarySearch(nums,size,dp,nums[i]);
            dp[pos] = nums[i];
            if(pos == size) size++;
        }
        return size;
    }

    public int binarySearch(int[] nums, int size, int[] dp, int target){
        int left = 0, right = size-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(dp[mid]<target) left = mid +1;
            else right = mid - 1;
        }
        return left;
    }
}

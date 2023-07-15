class Solution {
    public int maxProduct(int[] nums) {
        //max array is defined as on the interval of [0,i],and we must choose max[i], the maximum product value
        //which contains 2 situations:
        //(1)max[i]=max[i-1]*nums[i]
        //(2)max[i]=nums[i]

        //if current num >=0, then no matter the optimal value on [0,n-1] is >0 or <0, we should always choose max[i-1]
        //if current num<0, opposite to the previous situation
        int[] max = new int[nums.length+1], min = new int[nums.length+1];
        max[0]=1;
        min[0]=1;
        //global max may not be at last index of max array
        int res = Integer.MIN_VALUE;
        for(int i=1;i<max.length;i++){
            if(nums[i-1]>0){
                max[i]=Math.max(nums[i-1],max[i-1]*nums[i-1]);
                min[i]=Math.min(nums[i-1],min[i-1]*nums[i-1]);
            }
            else{
                max[i]=Math.max(nums[i-1],min[i-1]*nums[i-1]);
                min[i]=Math.min(nums[i-1],max[i-1]*nums[i-1]);
            }
            res = Math.max(max[i],res);
        }
        return res;
    }
}

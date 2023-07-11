class Solution {
    public int findMaxLength(int[] nums) {
        //注意增强for循环不会修改数组的原始值，而是取原先数组的副本
        //把所有0变成-1，这样如果subarray的和为0，说明这是一个满足条件的subarray
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]==0?-1:nums[i];
        }
        int res = 0, sum = 0;
        //（sum,leftMost index)
        //依然是leftmost index，因为我们希望取最长的subarray
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                res = Math.max(i-map.get(sum),res);
            }
            else map.put(sum,i);
        }
        return res;
    }
    //暴力法,n^2
    // public int findMaxLength(int[] nums){
    //     int maxlen = 0;
    //     for (int start = 0; start < nums.length; start++) {
    //         int zeroes = 0,ones = 0;
    //         for (int end = start; end < nums.length; end++){
    //         if (nums[end] == 0) zeroes++;
    //         else ones++;
    //         if (zeroes == ones)
    //             maxlen = Math.max(maxlen, end - start + 1);
    //         }
    //     }
    //     return maxlen;
    // }
}


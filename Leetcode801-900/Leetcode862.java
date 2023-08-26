class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        long[] prefixSum = new long[nums.length+1];
        for(int i=1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }
        int res = nums.length+1;
        for(int i=0;i<prefixSum.length;i++){
            while(!q.isEmpty() && prefixSum[i]-prefixSum[q.peekFirst()]>=k){
                res = Math.min(res, i - q.pollFirst());
            }                
            while(!q.isEmpty() && prefixSum[i] <= prefixSum[q.peekLast()]) q.pollLast();
            q.offerLast(i);
        }
        return res <= nums.length ? res : -1;
    }
}

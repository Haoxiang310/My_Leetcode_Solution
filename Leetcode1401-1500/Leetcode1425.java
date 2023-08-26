class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] sums = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for(int i=0;i<sums.length;i++){
            sums[i] = nums[i];
            if(!q.isEmpty()) {
                sums[i] = sums[i]+sums[q.peekFirst()];
            }
            res = Math.max(res, sums[i]);
            while(!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
            while(!q.isEmpty() && sums[i] >= sums[q.peekLast()]) q.pollLast();
            q.offerLast(i);
        }
        return res;
    }
}

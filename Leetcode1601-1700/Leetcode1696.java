class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Deque<Integer> q = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && i - k > q.peekFirst()) q.pollFirst();
            if(!q.isEmpty()) dp[i] = dp[q.peekFirst()] + nums[i];
            while(!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();
            q.offer(i);
        }
        return dp[nums.length-1];
    }
}
